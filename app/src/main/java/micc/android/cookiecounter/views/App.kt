package micc.android.cookiecounter.views

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import micc.android.cookiecounter.viewmodel.CounterViewModel

@Composable
fun App(counterViewModel: CounterViewModel) {
    val navController = rememberNavController()
    counterViewModel.getAllCounters()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navigation = navController)
        }
        composable("create_counter") {
            AddCounterScreen(navigation = navController, counterViewModel)
        }
        composable("counter") {
            CounterScreen(navigation = navController, counterViewModel)
        }
        composable("see_all_counters") {
            SeeAllCountersScreen(navigation = navController, counterViewModel)
        }
        composable("about") {
            AboutMeScreen(navigation = navController)
        }
    }
}