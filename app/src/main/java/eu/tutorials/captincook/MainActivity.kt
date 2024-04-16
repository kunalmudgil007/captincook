package eu.tutorials.captincook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.tutorials.captincook.ui.theme.CaptincookTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<CaptinGameViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptincookTheme { // Assuming CaptincookTheme is the correct theme to use
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptinGame(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun CaptinGame(viewModel: CaptinGameViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "TreasuresFound:${viewModel.treasuresFound.value}")
        Text(text = "Current Direction:${viewModel.direction.value}")
        Text(text = "${viewModel.stromOrTreasures.value}")

        Button(onClick = { viewModel.sail("East") }) {
            Text(text = "Sail East")
        }
        Button(onClick = { viewModel.sail("West") }) {
            Text(text = "Sail West")
        }
        Button(onClick = { viewModel.sail("North") }) {
            Text(text = "Sail North")
        }
        Button(onClick = { viewModel.sail("South") }) {
            Text(text = "Sail South")
        }
    }
}
