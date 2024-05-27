package org.example.project.ui.measurements_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.chuvak
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

/**
 *
 */
@Composable
fun MeasurementsScreen(
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Измерения",
                    color = Color.White
                )
            },
            navigationIcon = {
                Icon(
                    modifier = Modifier.padding(start = 12.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Кнопка назад",
                    tint = Color.White
                )
            },
            actions = {
                Icon(
                    modifier = Modifier.padding(end = 12.dp),
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Кнопка назад",
                    tint = Color.White
                )
            },
            backgroundColor = Color(0xFF27C6DA)
        )

        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()
        Column(
            modifier = Modifier.background(Color(0xFF27C6DA)).draggable(
                orientation = Orientation.Vertical,
                state = rememberDraggableState { delta ->
                    coroutineScope.launch {
                        scrollState.scrollBy(-delta)
                    }
                },
            )
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF27C6DA))
                    .graphicsLayer {
                        alpha = 1f - (scrollState.value.toFloat() / scrollState.maxValue)
                        translationY = 0.5f * scrollState.value
                    }, contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp).background(Color.White, RoundedCornerShape(16.dp)).padding(16.dp)
                ) {
                    Row{
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Активность",
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                modifier = Modifier.padding(top = 8.dp),
                                text = "Выполняйте задания каждый день,\nподдерживая свое здоровье",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }
                        Image(
                            painter = painterResource(Res.drawable.chuvak),
                            contentDescription = null
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp).background(Color(0Xffdff7f9), RoundedCornerShape(12.dp)).padding(12.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "+365 дней",
                            fontSize = 18.sp,
                            color = Color(0xFF27C6DA),
                            fontWeight = FontWeight.W800
                        )
                    }
                }

                /*Image(
                    painter = painterResource(Res.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )*/
            }

            Column(
                modifier = Modifier.fillMaxHeight().padding(top = 16.dp).background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)).padding(top = 8.dp)
            ) {
                Text(
                    text = "The King is back - Virat Kohli leads India to victory against Pakistan, Twitter erupts in celebrations",//stringResource(id = R.string.title),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Not for the first time - and unlikely to be the last - former skipper Virat Kohli turned back the clock with a brilliant individual knock of 82 from just 53 deliveries that saved the day for India.\\n\\nKohli came to the crease in the second over when KL Rahul (4) was undone by Naseem Shah (1/23) and things looked forlorn for India when a fired-up Haris Rauf (2/36) reduced them to 31/3 after the batting Powerplay.\\n\\nVirat Kohli took up the responsibility of hitting the big ones at a time when India was in trouble chasing 160. He made 82 out off 53 balls.\\n\\nVirat Kohli treated his fans to one of the memorable innings in the history of T20 World Cup as made an unbeaten knock of 82 and led India to victory against Pakistan by four wickets.\\n\\nIn what turned out to be a thriller of a match at the Melbourne Cricket Ground, Kohli took up the responsibility of hitting the big ones at a time when India was in trouble chasing 160. He made 82 out off 53 balls and Indian team\\'s fans on Twitter welcomed their \"king\".\\n\\nVirat Kohli is an Indian international cricketer and former captain of the India national cricket team. Widely regarded as one of the greatest batsmen of all time, Kohli plays as a right-handed batsman for Royal Challengers Bangalore in the Indian Premier League and for Delhi in domestic Indian cricket Not for the first time - and unlikely to be the last - former skipper Virat Kohli turned back the clock with a brilliant individual knock of 82 from just 53 deliveries that saved the day for India.\\n\\nKohli came to the crease in the second over when KL Rahul (4) was undone by Naseem Shah (1/23) and things looked forlorn for India when a fired-up Haris Rauf (2/36) reduced them to 31/3 after the batting Powerplay.\\n\\nVirat Kohli took up the responsibility of hitting the big ones at a time when India was in trouble chasing 160. He made 82 out off 53 balls.\\n\\nVirat Kohli treated his fans to one of the memorable innings in the history of T20 World Cup as made an unbeaten knock of 82 and led India to victory against Pakistan by four wickets.\\n\\nIn what turned out to be a thriller of a match at the Melbourne Cricket Ground, Kohli took up the responsibility of hitting the big ones at a time when India was in trouble chasing 160. He made 82 out off 53 balls and Indian team\\'s fans on Twitter welcomed their \"king\".\\n\\nVirat Kohli is an Indian international cricketer and former captain of the India national cricket team. Widely regarded as one of the greatest batsmen of all time, Kohli plays as a right-handed batsman for Royal Challengers Bangalore in the Indian Premier League and for Delhi in domestic Indian cricket", //stringResource(Res.string.desc),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}
