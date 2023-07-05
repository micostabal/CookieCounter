package micc.android.cookiecounter

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CurrentCookieCount(count: Int) {
    Text("Cookie count: $count")
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