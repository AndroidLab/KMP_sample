package org.example.project.ui.bluetooth_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexgladkov.odyssey.compose.local.LocalRootController

/**
 * TODO Для сэмпла, удалить на реальном проекте.
 */
@Composable
fun BluetoothScreen(
    bluetoothScreenViewModel: BluetoothScreenViewModel
) {
    val localRootController = LocalRootController.current
    Button(
        onClick = {
            localRootController.popBackStack()
        },
        modifier = Modifier.wrapContentSize().padding(12.dp)
    ) {
        Text(text = "Назад")
    }
}