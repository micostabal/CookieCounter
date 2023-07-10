package micc.android.cookiecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import micc.android.cookiecounter.data.Counter
import micc.android.cookiecounter.ui.theme.CookieCounterTheme
import java.util.UUID

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookieCounterTheme {
                App(counterViewModel)
            }
        }
    }
}

@Composable
fun App(counterViewModel: CounterViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navigation = navController)
        }
        composable("create_counter") {
            AddCounterScreen(navigation = navController, counterViewModel)
        }
        composable("counter") {
            CounterScreen(navigation = navController)
        }
        composable("see_all_counters") {
            SeeAllCountersScreen(navigation = navController, counterViewModel)
        }
        composable("about") {
            AboutMeScreen(navigation = navController)
        }
    }
}

@Composable
fun SeeAllCountersScreen(navigation: NavController, counterViewModel: CounterViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val counterList: List<Counter> by counterViewModel.counterList
            .observeAsState(initial = listOf())

        if (counterList.isNotEmpty()) {
            for (counter in counterList) {
                val counterName = counter.name
                Text(counterName)
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
fun AddCounterScreen(navigation: NavController, counterViewModel: CounterViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        var text by remember { mutableStateOf(TextFieldValue("")) }

        TopAppBar(title = {
            Text(
                text = "Add new Counter",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
        })
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(text = "Your Label") },
            placeholder = { Text(text = "Your Placeholder/Hint") },
        )
        Button(onClick = {
            val newCounter = Counter(
                id=UUID.randomUUID().toString(),
                name="fvindfvi",
                count=0
            )

            counterViewModel.saveCounter(newCounter)

            navigation.navigate("home")
        }) {
            Text("Create new counter")
        }
        Button(onClick = {
            navigation.navigate("home")
        }) {
            Text("To home")
        }
    }
}

@Composable
fun HomeScreen(navigation: NavController) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally,
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

@Composable
fun CounterScreen(navigation: NavController) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Counter()
        HomeButton(navigation = navigation)
    }
}

@Composable
fun AboutMeScreen(navigation: NavController) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text("Something about me")
        Text("Something else about me...")
        HomeButton(navigation = navigation)
    }
}

@Composable
fun HomeButton(navigation: NavController) {
    Button(onClick = {
        navigation.navigate("home")
    }) {
        Text("To home")
    }
}
