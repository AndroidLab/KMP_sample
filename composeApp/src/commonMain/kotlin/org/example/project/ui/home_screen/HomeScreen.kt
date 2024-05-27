package org.example.project.ui.home_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.emk
import kotlinproject.composeapp.generated.resources.home
import kotlinproject.composeapp.generated.resources.journal
import kotlinproject.composeapp.generated.resources.measurements
import kotlinproject.composeapp.generated.resources.medicines
import kotlinproject.composeapp.generated.resources.samgmu_logo
import org.example.project.SamGMYTheme
import org.example.project.ui.main_screen.db.TodoEntity
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.ResourceItem
import org.jetbrains.compose.resources.painterResource
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

/**
 * Представляет главный экран приложения.
 */
@OptIn(ExperimentalResourceApi::class, InternalResourceApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    SamGMYTheme {
        LaunchedEffect(Unit) {
            //println("AAAAAA " + mainScreenViewModel.appPreferences.isDarkModeEnabled())
            //mainScreenViewModel.appPreferences.changeDarkMode(true)
        }

        var showContent by remember { mutableStateOf(false) }
        Column(
            Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        ) {
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { showContent = !showContent }
            ) {
                Text("Нажми на меня!")
            }
            AnimatedVisibility(showContent) {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Image(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        painter = painterResource(Res.drawable.samgmu_logo),
                        contentDescription = null
                    )
                }
            }
            val greeting = remember { Greeting().greet() }

            KMMRow("Котлин транспилируется в нативные языки")
            KMMRow("Котлин позволяет проще свичнуться в нативную разработку (востребованность на рынке)")
            KMMRow("Multiplathorm позволяет писать нативный платформенный код (Kotlin, Swift) и нативный ui (Compose, SwiftUI)")
            KMMRow("Compose multiplathorm для ios использует skia, а для android нативную отрисовку (Лучше UX)")
            KMMRow("IOS разработчикам проще перейти в multiplatform, поскольку swift похож на котлин, а swiftUi на сщьзщыу")
            KMMRow("Удешевляет разработку, поскольку разработчиков знающих kotlin намного больше, чем знающих dart. + легче втянуть IOS разработчиков, поскольку языки и ui фреймворки похожи")
            val rootController = LocalRootController.current

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AsyncImage(
                    modifier = Modifier.size(150.dp).padding(12.dp),
                    model = "https://wdorogu.ru/images/wp-content/uploads/2020/04/s1200-30-1.jpg",
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    //colorFilter = if (applyTint) ColorFilter.tint(color = tint) else null,
                    onError = {
                        //loadingProgress(ImageState.Failure)
                    },
                    onLoading = {
                        //loadingProgress(ImageState.Loading)
                    },
                    onSuccess = {
                        //loadingProgress(ImageState.Success)
                    },
                )
                Text(
                    text = "Картинка загруженная из сети",
                    fontSize = 18.sp,
                    color = Color.Blue
                )
            }

            val title by viewModel.titleText.collectAsState()
            TextField(
                value = title,
                onValueChange = { viewModel.titleText.value = it },
                modifier = Modifier.padding(12.dp)
                    .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)),
                label = { Text(text = "Введите имя") },
                /*leadingIcon = {
                    Icon(imageVector = Icons.Default.Email,
                        contentDescription ="Email icon",
                        // tint = myColor5
                    )
                },*/
                /*trailingIcon = {
                    Icon(imageVector = Icons.Filled.Send, contentDescription = null)
                },*/
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp)
            )

            val pref: Boolean by viewModel.prefFlow.collectAsState(false)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier.padding(12.dp),
                    onClick = {
                        viewModel.changePref()
                    }
                ) {
                    Text(text = "Изменить преф")
                }
                Text(
                    text = "pref = ${pref}"
                )
            }
            val db: List<TodoEntity> by viewModel.dbFlow.collectAsState(emptyList())
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier.padding(12.dp),
                    onClick = {
                        viewModel.changeDB()
                    }
                ) {
                    Text(text = "Изменить БД")
                }
                Text(
                    text = "БД count = ${db.size}"
                )
            }

            val fileType = listOf("jpg", "png")
            Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var showSingleFilePicker by remember { mutableStateOf(false) }
                var pathSingleChosen by remember { mutableStateOf("") }

                Button(onClick = {
                    showSingleFilePicker = true
                }) {
                    Text("Выбрать файл")
                }
                Text(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    text = "Файл: $pathSingleChosen"
                )

                FilePicker(showSingleFilePicker, fileExtensions = fileType) { platformFile ->
                    if (platformFile != null) {
                        pathSingleChosen = platformFile.toString()
                    }
                    showSingleFilePicker = false
                }
            }

            Text(
                modifier = Modifier.fillMaxSize().padding(12.dp),
                text = "Compose: $greeting",
                textAlign = TextAlign.End
            )
        }
    }

    /*SamGMYTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            val birdsViewModel = getViewModel(Unit, viewModelFactory { MainScreenViewModel() })
            BirdsPage(birdsViewModel)
        }
    }*/
}

@OptIn(ExperimentalResourceApi::class, InternalResourceApi::class)
@Composable
fun KMMRow(text: String) {
    Row(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(18.dp),
            painter = painterResource(
                DrawableResource(
                    "drawable:check.png",
                    setOf(
                        ResourceItem(
                            qualifiers = setOf(),
                            path = "drawable/check.png",
                            offset = 0L,
                            size = 0L
                        ),
                    )
                )
            ),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 16.sp,
            text = text
        )
    }
}

/*@Composable
fun BirdsPage(viewModel: MainScreenViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Main screen")
        Row(
            Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            for (category in uiState.categories) {
                Button(
                    onClick = {
                        viewModel.selectCategory(category)
                    },
                    modifier = Modifier.aspectRatio(1.0f).fillMaxSize().weight(1.0f),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        focusedElevation = 0.dp
                    )
                )
                {
                    Text(category)
                }
            }
        }
        AnimatedVisibility(uiState.selectedImages.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
                content = {
                    items(uiState.selectedImages) {
                        BirdImageCell(it)
                    }
                }
            )
        }
        val rootController = LocalRootController.current
        Button(
            onClick = {
                rootController.push("SecondScreen")
            },
            modifier = Modifier.wrapContentSize()
        ) {
            Text(text = "Следующий экран")
        }
    }
}*/

/*
@Composable
fun BirdImageCell(image: BirdModel) {
    KamelImage(
        asyncPainterResource("https://sebastianaigner.github.io/demo-image-api/${image.path}"),
        "${image.category} by ${image.author}",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().aspectRatio(1.0f)
    )
}*/
