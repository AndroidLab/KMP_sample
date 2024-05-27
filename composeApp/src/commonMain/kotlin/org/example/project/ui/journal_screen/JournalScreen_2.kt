package org.example.project.ui.journal_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

/**
 *
 */
@Composable
fun JournalScreen_2(
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val rootController = LocalRootController.current
        Column {
            Text(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = "Дневник (Внутренняя вкладка)",
                fontSize = 22.sp
            )
            Button(
                modifier = Modifier.padding(12.dp).align(alignment = Alignment.CenterHorizontally),
                onClick = {
                    rootController.popBackStack()
                }
            ) {
                Text("Назад")
            }
        }
    }
}