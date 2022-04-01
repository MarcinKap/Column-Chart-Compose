# Column Chart - Jetpack Compose


Compose Column Chart is an open source library for creating views of column charts in compose.  


# Download

Add the code below to your gradle files

    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
       ...
    }

    dependencies {
		implementation 'com.github.MarcinKap:Column-Chart-Compose:1.0'
	}

# Examples of use

<img width="401" alt="Zrzut ekranu 2022-04-1 o 18 30 51" src="https://user-images.githubusercontent.com/53196103/161304770-aa60b959-145a-408b-90cd-cd513318cdb7.png">

<img width="401" alt="Zrzut ekranu 2022-04-1 o 18 33 56" src="https://user-images.githubusercontent.com/53196103/161305195-926ab0c3-d3a2-4c60-bf58-0751e96eaa86.png">

# How to use

To create a graph in your project you need to use a method called 'Chart' in which the obligatory parameter is the list of ChartSinglePart.
So you have to make a list of such items.  

	data class ChartSinglePart(val columns: List<ChartColumn>, val description: String)
	
ChartSinglePart contains a description placed under the chart and a list of columns.  
Each 'ChartColumn' object accepts values of int, color and 'informationToSend' of Any type (described later).

	data class ChartColumn(val value: Int, val color: Color, val informationToSend: Any?)






