package micc.android.cookiecounter.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import micc.android.cookiecounter.Counter
import micc.android.cookiecounter.views.components.HomeButton

@Composable
fun CounterScreen(navigation: NavController) {
    var expanded by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        DropdownMenu(
            expanded = true,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                content = { Text("Load") },
                onClick = {

                }
            )
            DropdownMenuItem(
                content = { Text("Save") },
                onClick = {

                }
            )
        }
        Counter()
        HomeButton(navigation = navigation)
    }
}