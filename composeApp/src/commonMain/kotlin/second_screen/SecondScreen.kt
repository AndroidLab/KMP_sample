package second_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.alexgladkov.odyssey.compose.local.LocalRootController


@Composable
fun SecondScreen() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val localRootController = LocalRootController.current
        Text(text = "Second screen")
        Button(
            onClick = {
                localRootController.popBackStack()
            },
            modifier = Modifier.wrapContentSize()
        ) {
            Text(text = "Назад")
        }
    }
}