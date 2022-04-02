package com.marcinkap.chart_compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.marcinkap.chart_compose.models.ChartColumn
import com.marcinkap.chart_compose.models.ChartSinglePart
import kotlin.math.roundToInt

@Composable
fun Chart(
    modifier: Modifier = Modifier,
    listStats: List<ChartSinglePart>,
    select: (Any?) -> Unit = {},
    horizontalLineColor: Color = Color.Gray,
    axisLinesColor: Color = Color.Black,
    showHorizontalLines: Boolean = true,
    showVerticalAxisLine: Boolean = true,
    maxScaleValue: Int? = null,
    leftScaleValues: List<String>? = null,
    leftScaleTextStyle: TextStyle = MaterialTheme.typography.overline,
    leftScaleHorizontalAlignment: Alignment.Horizontal = Alignment.Start,
    useDefaultLeftScale: Boolean = false,
    rightScaleValues: List<String>? = null,
    rightScaleTextStyle: TextStyle = MaterialTheme.typography.overline,
    rightScaleHorizontalAlignment: Alignment.Horizontal = Alignment.Start,
    columnDescriptionTextStyle: TextStyle = MaterialTheme.typography.overline,
    isRoundedCorner: Boolean = false
) {
    val maxValueOnChart: Int
    if (maxScaleValue == null) {
        maxValueOnChart = calculateMaxScaleValue(listStats = listStats)
    } else {
        maxValueOnChart = maxScaleValue
    }

    val numberOfHorizontalLines: Int
    if (leftScaleValues?.isNotEmpty() == true) {
        numberOfHorizontalLines = leftScaleValues.size
    } else if (rightScaleValues?.isNotEmpty() == true) {
        numberOfHorizontalLines = rightScaleValues.size
    } else {
        numberOfHorizontalLines = 6
    }

    Box(modifier = modifier) {
        Surface(Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                ConstraintLayout(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    val (leftColumn, midColumn, rightColumn, bottomDayList) = createRefs()
                    val leftScaleModifier = Modifier
                        .padding(end = 4.dp)
                        .constrainAs(leftColumn) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(bottomDayList.top)
                            height = Dimension.fillToConstraints
                        }
                    val rightScaleModifier = Modifier
                        .padding(start = 4.dp)
                        .constrainAs(rightColumn) {
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                            bottom.linkTo(bottomDayList.top)
                            height = Dimension.fillToConstraints
                        }

                    if (!leftScaleValues.isNullOrEmpty()) {
                        CustomScale(
                            modifier = leftScaleModifier,
                            listValues = leftScaleValues,
                            textStyle = leftScaleTextStyle,
                            horizontalAlignment = leftScaleHorizontalAlignment
                        )
                    } else if (useDefaultLeftScale) {
                        DefaultLeftScale(
                            modifier = leftScaleModifier,
                            maxValue = maxValueOnChart,
                            numberOfHorizontalLines = numberOfHorizontalLines,
                            textStyle = rightScaleTextStyle,
                            horizontalAlignment = leftScaleHorizontalAlignment
                        )
                    } else {
                        Box(modifier = leftScaleModifier)
                    }

                    Box(
                        modifier = Modifier
                            .constrainAs(midColumn) {
                                start.linkTo(leftColumn.end)
                                end.linkTo(rightColumn.start)
                                top.linkTo(parent.top)
                                bottom.linkTo(leftColumn.bottom)
                                width = Dimension.fillToConstraints
                                height = Dimension.fillToConstraints
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        if (listStats.isNotEmpty()) {
                            CanvasChartWithButtons(
                                modifier = Modifier
                                    .fillMaxHeight(fraction = (numberOfHorizontalLines - 1) / numberOfHorizontalLines.toFloat()),
                                listStats = listStats,
                                select = select,
                                horizontalLineColor = horizontalLineColor,
                                axisLinesColor = axisLinesColor,
                                numberOfHorizontalLines = numberOfHorizontalLines,
                                showHorizontalLines = showHorizontalLines,
                                showVerticalAxisLine = showVerticalAxisLine,
                                isRoundedCorner = isRoundedCorner,
                                maxValueOnChart = maxValueOnChart
                            )
                        }
                    }



                    if (!rightScaleValues.isNullOrEmpty()) {
                        CustomScale(
                            modifier = rightScaleModifier,
                            listValues = rightScaleValues,
                            textStyle = rightScaleTextStyle,
                            horizontalAlignment = rightScaleHorizontalAlignment
                        )
                    } else {
                        Box(modifier = rightScaleModifier)
                    }

                    ColumnDescription(
                        modifier = Modifier
                            .constrainAs(bottomDayList) {
                                top.linkTo(midColumn.bottom)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(midColumn.start)
                                end.linkTo(midColumn.end)
                                width = Dimension.fillToConstraints
                            },
                        listStats = listStats,
                        textStyle = columnDescriptionTextStyle
                    )
                }
            }
        }
    }
}

@Composable
fun CustomScale(
    modifier: Modifier,
    listValues: List<String>,
    textStyle: TextStyle = MaterialTheme.typography.overline,
    textColor: Color = Color.Black,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        listValues.forEach {
            Text(
                text = it,
                style = textStyle,
                color = textColor,
            )
        }
    }
}

@Composable
fun DefaultLeftScale(
    modifier: Modifier,
    maxValue: Int,
    numberOfHorizontalLines: Int,
    textStyle: TextStyle = MaterialTheme.typography.overline,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        for (i in (numberOfHorizontalLines - 1) downTo 0) {
            Text(
                text = "${(i * (maxValue / (numberOfHorizontalLines - 1).toFloat())).roundToInt()}",
                style = textStyle,
            )
        }
    }
}


@Composable
fun CanvasChartWithButtons(
    modifier: Modifier,
    listStats: List<ChartSinglePart>,
    select: (Any?) -> Unit,
    horizontalLineColor: Color,
    axisLinesColor: Color,
    numberOfHorizontalLines: Int,
    showHorizontalLines: Boolean,
    showVerticalAxisLine: Boolean,
    isRoundedCorner: Boolean,
    maxValueOnChart: Int
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        UniversalChartCanvas(
            listStats = listStats,
            horizontalLineColor = horizontalLineColor,
            axisLinesColor = axisLinesColor,
            numberOfHorizontalLines = numberOfHorizontalLines,
            showHorizontalLines = showHorizontalLines,
            isRoundedCorner = isRoundedCorner,
            showVerticalAxisLine = showVerticalAxisLine,
            maxScaleValue = maxValueOnChart
        )
        Row {
            listStats.forEach {
                it.columns.forEach {
                    Box(
                        modifier = Modifier
                            .alpha(0f)
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable(onClick = { select(it.informationToSend) })
                            .background(Color.White)
                    )
                }
            }
        }
    }
}


@Composable
fun UniversalChartCanvas(
    listStats: List<ChartSinglePart>,
    horizontalLineColor: Color,
    axisLinesColor: Color,
    maxScaleValue: Int,
    numberOfHorizontalLines: Int,
    showHorizontalLines: Boolean,
    showVerticalAxisLine: Boolean,
    isRoundedCorner: Boolean,
) {
    Surface {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            //Horizontal Lines
            val mainHorizontalLineOffsetY = canvasHeight / (numberOfHorizontalLines - 1)


            if (showVerticalAxisLine){
                drawRect(
                    color = axisLinesColor,
                    topLeft = Offset(x = 0f, y = 0f),
                    size = Size(
                        width = 2f,
                        height = canvasHeight
                    ),
                )
            }
            if (showHorizontalLines) {
                for (i in 0..numberOfHorizontalLines - 1) {
                    val horizontalLineOffsetY = mainHorizontalLineOffsetY * i
                    drawRect(
                        color = horizontalLineColor,
                        topLeft = Offset(x = 0f, y = horizontalLineOffsetY),
                        size = Size(
                            width = canvasWidth,
                            height = 2f
                        ),
                    )
                }
            }
            //Vertical columns
            val eachDayWidth = canvasWidth / (listStats.size)
            val eachColumnHeight: Float
            //Select Rounded top or not
            if (isRoundedCorner) {
                eachColumnHeight = canvasHeight + canvasWidth / 2  //rounded
            } else {
                eachColumnHeight = canvasHeight
            }
            //calculate spaceBetweenColumn
            var numberOfPart = 0
            listStats.forEach {
                val numberOfColumns = it.columns.size
                val columnWidth: Float
                if (numberOfColumns == 1) {
                    columnWidth = eachDayWidth / 3
                } else if (numberOfColumns == 2) {
                    columnWidth = eachDayWidth / 7 * 2
                } else {
                    columnWidth = eachDayWidth / (numberOfColumns * 2)
                }
                val cornerRadius = columnWidth / 2
                val spaceBetweenColumn =
                    (eachDayWidth - numberOfColumns * columnWidth) / (numberOfColumns + 1)
                val dayOffsetX = numberOfPart * eachDayWidth

                for (i in it.columns.indices) {
                    val offsetX = ((i + 1) * spaceBetweenColumn) + dayOffsetX + i * columnWidth

                    val heightValue =
                        if (it.columns[i].value >= maxScaleValue) {
                            maxScaleValue
                        } else {
                            it.columns[i].value
                        }
                            .div(maxScaleValue.toFloat())

                    val offsetY = canvasHeight * (1 - heightValue)

                    drawRoundRect(
                        color = it.columns[i].color,
                        topLeft = Offset(x = offsetX, y = offsetY),
                        size = Size(
                            width = columnWidth,
                            height = eachColumnHeight
                        ),
                        cornerRadius = if (isRoundedCorner) {
                            CornerRadius(
                                x = cornerRadius,
                                y = cornerRadius
                            )
                        } else {
                            CornerRadius.Zero
                        },
                    )
                }
                numberOfPart++
            }
            val horizontalLineOffsetY = mainHorizontalLineOffsetY * (numberOfHorizontalLines - 1) - 2
            drawRect(
                color = horizontalLineColor,
                topLeft = Offset(x = 0f, y = horizontalLineOffsetY),
                size = Size(
                    width = canvasWidth,
                    height = 2f
                ),
            )
        }
    }
}

@Composable
fun ColumnDescription(
    modifier: Modifier = Modifier,
    listStats: List<ChartSinglePart>,
    textStyle: TextStyle = MaterialTheme.typography.overline
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Top
    ) {
        listStats.forEach {
            Text(
                modifier = Modifier.weight(1f),
                text = it.description,
                style = textStyle,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ColumnDescriptionPreview(){
    val listStats = listOf(
        ChartSinglePart(
            columns = listOf(
                ChartColumn(
                    value = 10,
                    color = Color(0xff15a8a6),
                    informationToSend = 1,
                ),
                ChartColumn(
                    value = 151,
                    color = Color(0xffefaf23),
                    informationToSend = 1,
                )
            ),

            description = "MON"
        )
    )
    MaterialTheme{
        ColumnDescription(
            listStats = listStats)
    }
}


fun calculateMaxScaleValue(listStats: List<ChartSinglePart>): Int {
    var maxScaleValue = 10
    var maxValueInList = 0

    listStats.forEach {
        it.columns.forEach {
            if (maxValueInList < it.value) {
                maxValueInList = it.value
            }
        }
    }

    while (maxScaleValue < maxValueInList) {
        if (maxScaleValue == 10) {
            maxScaleValue = 20
        } else if (maxScaleValue == 20) {
            maxScaleValue = 50
        } else {
            maxScaleValue += 50
        }
    }
    return maxScaleValue
}
