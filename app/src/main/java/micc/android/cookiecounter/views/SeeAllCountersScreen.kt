package micc.android.cookiecounter.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import micc.android.cookiecounter.CounterViewModel
import micc.android.cookiecounter.data.Counter

@Composable
fun SeeAllCountersScreen(navigation: NavController, counterViewModel: CounterViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val counterList: List<Counter> by counterViewModel.counterList
            .observeAsState(initial = listOf())

        if (counterList.isNotEmpty()) {
            for (counter in counterList) {
                val name = counter.name
                val count = counter.count

                Text("$name, $count")
            }
        } else {
            Text("No counters created yet...")
        }
        Button(onClick = {
            navigation.navigate("home")
        }) {
            Text("To home")
        }
    }
}