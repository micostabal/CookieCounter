package micc.android.cookiecounter.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import micc.android.cookiecounter.CounterViewModel
import micc.android.cookiecounter.views.components.HomeButton

@Composable
fun CounterScreen(navigation: NavController, counterViewModel: CounterViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        DropDownCounters(counterViewModel)
        Counter()
        HomeButton(navigation = navigation)
    }
}

@Composable
fun DropDownCounters(counterViewModel: CounterViewModel) {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("A", "B", "C", "D", "E", "F")
    var selectedIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier.clip(shape = RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            expanded = !expanded
        }) {
            Text(items[selectedIndex])
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    Text(text = s, color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Text("Current cookie count: $count")
    Button(onClick = {
        count++
    }) {
        Text("Add Cookie!")
    }
}