package com.example.androidlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidlibrary.ui.theme.AndroidLibraryTheme
import com.marcinkap.chart_compose.Chart
import com.marcinkap.chart_compose.models.ChartColumn
import com.marcinkap.chart_compose.models.ChartSinglePart


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val color1 = Color(0xff15a8a6)
            val color2 = Color(0xffefaf23)
            val color3 = Color(0xff0082d5)
            val color4 = Color(0xffe4335d)
            val color5 = Color(0xff2c3a8c)


            AndroidLibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface() {


                    LazyColumn() {

                        item {
                            val listStats = listOf(
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 10,
                                            color = color1,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 151,
                                            color = color2,
                                            informationToSend = 1,
                                        )
                                    ),

                                    description = "MON"
                                ),
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 35,
                                            color = color1,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 100,
                                            color = color2,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "TUE"
                                ),
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 35,
                                            color = color1,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 100,
                                            color = color2,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "WED"
                                ),
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 35,
                                            color = color1,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 100,
                                            color = color2,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "THU"
                                ),
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 35,
                                            color = color1,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 100,
                                            color = color2,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "FRI"
                                ),
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 35,
                                            color = color1,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 100,
                                            color = color2,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "SAT"
                                ),
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 35,
                                            color = color1,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 100,
                                            color = color2,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "SUN"
                                ),
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .height(400.dp)
                            ) {
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
                                            isRoundedCorner = true
                                        )
                                    }
                                }
                            }
                        }

                        item {
                            val listStats = listOf(
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 10,
                                            color = color3,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 51,
                                            color = color4,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 130,
                                            color = color5,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "JAN"
                                ),
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 99,
                                            color = color3,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 56,
                                            color = color4,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 42,
                                            color = color5,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "FEB"
                                ),
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 81,
                                            color = color3,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 67,
                                            color = color4,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 101,
                                            color = color5,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "MAR"
                                ),
                                ChartSinglePart(
                                    columns = listOf(
                                        ChartColumn(
                                            value = 13,
                                            color = color3,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 61,
                                            color = color4,
                                            informationToSend = 1,
                                        ),
                                        ChartColumn(
                                            value = 150,
                                            color = color5,
                                            informationToSend = 1,
                                        )
                                    ),
                                    description = "MAR"
                                )
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .height(400.dp)
                            ) {
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
                                            maxScaleValue = 160,
                                            leftScaleValues = listOf("200","180","160", "120", "80", "40", "0"),
                                            isRoundedCorner = false,
                                            showHorizontalLines = false,
                                            showVerticalAxisLine = false
                                        )
                                    }
                                }
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