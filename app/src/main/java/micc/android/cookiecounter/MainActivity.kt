package micc.android.cookiecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import micc.android.cookiecounter.ui.theme.CookieCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookieCounterTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navigation = navController)
        }
        composable("counter") {
            CounterScreen(navigation = navController)
        }
        composable("about") {
            AboutMeScreen(navigation = navController)
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
