package micc.android.cookiecounter.views.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeButton(navigation: NavController) {
    Button(onClick = {
        navigation.navigate("home")
    }) {
        Text("To home")
    }
}