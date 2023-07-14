package micc.android.cookiecounter.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import micc.android.cookiecounter.viewmodel.CounterViewModel
import micc.android.cookiecounter.data.Counter
import micc.android.cookiecounter.ui.theme.Purple500

@Composable
fun SeeAllCountersScreen(navigation: NavController, counterViewModel: CounterViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val counterList: List<Counter> by counterViewModel.counterList
            .observeAsState(initial = listOf())
        if (counterList.isNotEmpty()) {
            Box(modifier=Modifier.height(400.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(Purple500)
                .padding(2.dp)) {
                CountersList(counterList)
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

@Composable
fun CountersList(counterList: List<Counter>) {
    LazyColumn(modifier = Modifier) {
        items(counterList) { counter ->
            CountCard(counter)
        }
    }
}

@Composable
fun CountCard(counter: Counter) {
    val name = counter.name
    val count = counter.count
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        modifier = Modifier.padding(16.dp).clickable {

        }
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = name,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.weight(1f)
            )
            Text(
                text = count.toString(),
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}