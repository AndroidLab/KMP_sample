package org.example.project.ui.bluetooth_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benasher44.uuid.uuidFrom
import com.juul.kable.Filter
import com.juul.kable.Scanner
import com.juul.kable.logs.Logging
import com.juul.kable.logs.SystemLogEngine
import de.jensklingenberg.ktorfit.Ktorfit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.ui.main_screen.api.IBirdApi
import org.example.project.ui.main_screen.data.MainScreenUiState
import org.example.project.db.AppDatabase
import org.example.project.ui.main_screen.db.TodoDao
import org.example.project.preferences.AppPreferences


/**
 * Предствавляет модель представления экрана поиска устройст.
 */
class BluetoothScreenViewModel(): ViewModel() {

    val scanner = Scanner {
        filters = null
        logging {
            engine = SystemLogEngine
            level = Logging.Level.Warnings
            format = Logging.Format.Multiline
        }
        filters = listOf(
            Filter.Service(uuidFrom("0000aa80-0000-1000-8000-00805f9b34fb")), // SensorTag
            Filter.NamePrefix("Ex"),
        )
    }

    val devices = scanner.advertisements

    init {
        println("AAAAAA Bluetooth init")
        viewModelScope.launch {
            devices.collect {
                println("AAAAAA" + it)
            }
        }

    }

}