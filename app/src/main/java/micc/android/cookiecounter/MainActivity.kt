package micc.android.cookiecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import micc.android.cookiecounter.ui.theme.CookieCounterTheme
import micc.android.cookiecounter.viewmodel.CounterViewModel
import micc.android.cookiecounter.views.*

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
