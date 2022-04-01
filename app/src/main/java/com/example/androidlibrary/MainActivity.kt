package com.example.androidlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlibrary.ui.theme.AndroidLibraryTheme
import com.marcinkap.chart_compose.Chart
import com.marcinkap.chart_compose.models.ChartColumn
import com.marcinkap.chart_compose.models.ChartSinglePart

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            AndroidLibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface() {

                    val listStats = listOf(
                        ChartSinglePart(
                            columns = listOf(
                                ChartColumn(
                                    value = 10,
                                    color = Color.Red,
                                    informationToSend = 1,
                                ),
                                ChartColumn(
                                    value = 151,
                                    color = Color.Blue,
                                    informationToSend = 1,
                                )
                            ),

                            description = "MON"
                        ),
                        ChartSinglePart(
                            columns = listOf(
                                ChartColumn(
                                    value = 35,
                                    color = Color.Red,
                                    informationToSend = 1,
                                ),
                                ChartColumn(
                                    value = 100,
                                    color = Color.Blue,
                                    informationToSend = 1,
                                )
                            ),
                            description = "TUE"
                        ),
                        ChartSinglePart(
                            columns = listOf(
                                ChartColumn(
                                    value = 35,
                                    color = Color.Red,
                                    informationToSend = 1,
                                ),
                                ChartColumn(
                                    value = 100,
                                    color = Color.Blue,
                                    informationToSend = 1,
                                )
                            ),
                            description = "WED"
                        ),
                        ChartSinglePart(
                            columns = listOf(
                                ChartColumn(
                                    value = 35,
                                    color = Color.Red,
                                    informationToSend = 1,
                                ),
                                ChartColumn(
                                    value = 100,
                                    color = Color.Blue,
                                    informationToSend = 1,
                                )
                            ),
                            description = "THU"
                        ),
                        ChartSinglePart(
                            columns = listOf(
                                ChartColumn(
                                    value = 35,
                                    color = Color.Red,
                                    informationToSend = 1,
                                ),
                                ChartColumn(
                                    value = 100,
                                    color = Color.Blue,
                                    informationToSend = 1,
                                )
                            ),
                            description = "FRI"
                        ),
                        ChartSinglePart(
                            columns = listOf(
                                ChartColumn(
                                    value = 35,
                                    color = Color.Red,
                                    informationToSend = 1,
                                ),
                                ChartColumn(
                                    value = 100,
                                    color = Color.Blue,
                                    informationToSend = 1,
                                )
                            ),
                            description = "SAT"
                        ),
                        ChartSinglePart(
                            columns = listOf(
                                ChartColumn(
                                    value = 35,
                                    color = Color.Red,
                                    informationToSend = 1,
                                ),
                                ChartColumn(
                                    value = 100,
                                    color = Color.Blue,
                                    informationToSend = 1,
                                )
                            ),
                            description = "SUN"
                        ),
                    )

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(400.dp)) {

                        Card() {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    text = "Example chart title",
                                    style = MaterialTheme.typography.subtitle2,
                                    color = Color.Black,
                                    fontWeight = FontWeight.W500
                                )
                                Text(
                                    text = "Example unit",
                                    style = MaterialTheme.typography.caption,
                                    color = Color.Black
                                )
                                Chart(
                                    listStats = listStats,
                                    useDefaultLeftScale = true,
                                    isRoundedCorner = true)
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidLibraryTheme {
        Greeting("Android")
    }
}