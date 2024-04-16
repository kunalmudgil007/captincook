package eu.tutorials.captincook

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class CaptinGameViewModel : ViewModel() {
    val treasuresFound: MutableState<Int> = mutableStateOf(0)
    val direction: MutableState<String> = mutableStateOf("North")
    val stromOrTreasures: MutableState<String> = mutableStateOf("")

    fun sail(direction: String) {
        this.direction.value = direction

        if (Random.nextBoolean()) {
            treasuresFound.value += 1
            stromOrTreasures.value = "Found a Treasure!"
        } else {
            stromOrTreasures.value = "Storm Ahead!!!"
        }
    }
}
