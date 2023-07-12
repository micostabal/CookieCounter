package micc.android.cookiecounter.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import micc.android.cookiecounter.CounterViewModel
import micc.android.cookiecounter.data.Counter
import micc.android.cookiecounter.views.components.HomeButton

@Composable
fun CounterScreen(navigation: NavController, counterViewModel: CounterViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        var expanded by remember { mutableStateOf(false) }
        val counterList: List<Counter> by counterViewModel.counterList
            .observeAsState(initial = listOf())
        var selectedIndex by remember { mutableStateOf(0) }
        if (counterList.isNotEmpty()) {
            Box(modifier = Modifier.clip(shape = RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    expanded = !expanded
                }) {
                    Text(counterList[selectedIndex].name)
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    counterList.forEachIndexed { index, s ->
                        DropdownMenuItem(onClick = {
                            selectedIndex = index
                            expanded = false
                        }) {
                            Text(text = s.name, color = Color.Black)
                        }
                    }
                }
            }
            Text("Current cookie count: ${counterList[selectedIndex].count}")
            Button(onClick = {
                val currentCount: Int = counterList[selectedIndex].count

                counterViewModel.setCount(
                    counterList[selectedIndex],
                    currentCount+1
                )
            }) {
                Text("Add Cookie!")
            }
            Button(onClick = {
                val currentCount: Int = counterList[selectedIndex].count

                counterViewModel.setCount(
                    counterList[selectedIndex],
                    currentCount-1
                )
            }) {
                Text("Remove Cookie!")
            }
        } else {
            Text("No counters on the list")
        }
        HomeButton(navigation = navigation)
    }
}
