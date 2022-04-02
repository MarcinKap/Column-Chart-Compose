package com.marcinkap.chart_compose.models

import androidx.compose.ui.graphics.Color


data class ChartColumn(
    val value: Int,
    val color: Color,
    val informationToSend: Any? = null,
)