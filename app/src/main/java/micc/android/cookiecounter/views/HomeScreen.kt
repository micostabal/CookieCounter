package micc.android.cookiecounter.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(navigation: NavController) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text("Home Screen")
        Button(onClick = {
            navigation.navigate("counter")
        }) {
            Text("To counter")
        }
        Button(onClick = {
            navigation.navigate("create_counter")
        }) {
            Text("Create counter")
        }
        Button(onClick = {
            navigation.navigate("see_all_counters")
        }) {
            Text("See all counters")
        }
        Button(onClick = {
            navigation.navigate("about")
        }) {
            Text("To about")
        }
    }
}