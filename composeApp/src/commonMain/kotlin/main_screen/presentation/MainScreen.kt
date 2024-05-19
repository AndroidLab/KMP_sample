package main_screen.presentation

import SamGMYTheme
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.delay
import main_screen.data.models.BirdModel
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import kotlin.math.sin

@OptIn(ExperimentalResourceApi::class, InternalResourceApi::class)
@Composable
fun MainScreen() {
    var showContent by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize()) {
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { showContent = !showContent }) {
            Text("Click me!")
        }
        AnimatedVisibility(showContent) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                //Image(painterResource(Res.drawable.compose_multiplatform), null)
                Image(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(
                        DrawableResource(
                            "drawable:samgmu_logo.jpg",
                            setOf(
                                org.jetbrains.compose.resources.ResourceItem(
                                    setOf(),
                                    "drawable/samgmu_logo.jpg"
                                ),
                            )
                        )
                    ),
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
        Button(
            modifier = Modifier.padding(12.dp),
            onClick = {
                rootController.push("SecondScreen")
            }
        ) {
            Text("К графику")
        }

        Text(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            text = "Compose: $greeting",
            textAlign = TextAlign.End
        )
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
                        org.jetbrains.compose.resources.ResourceItem(
                            setOf(),
                            "drawable/check.png"
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
