package micc.android.cookiecounter.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import micc.android.cookiecounter.CounterViewModel
import micc.android.cookiecounter.data.Counter
import java.util.UUID


@Composable
fun AddCounterScreen(navigation: NavController, counterViewModel: CounterViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally,
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
                id= UUID.randomUUID().toString(),
                name=text.text,
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