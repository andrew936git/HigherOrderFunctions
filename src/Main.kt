import kotlin.random.Random

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//1
    do{
        var i = 1
        println(
            """Введите два цвета
        |1 - красный
        |2 - зеленый
        |3 - синий
    """.trimMargin()
        )
        var color1 = readln()
        when(color1){
            "1" -> color1 = "красный"
            "2" -> color1 = "зеленый"
            "3" -> color1 = "синий"
            else -> color1 = ""
        }
        var color2 = readln()
        when(color2){
            "1" -> color2 = "красный"
            "2" -> color2 = "зеленый"
            "3" -> color2 = "синий"
            else -> color2 = ""
        }
        println("При смешении выбраных цветов получится ${ action(color1, color2, ::mixColor) }")
        println("Попробовать еще раз(1-да/2-нет)")
        i = readln().toInt()

    }while (i == 1)
    println("--------------------------------------------")
//2
    val random = Random
    val array: Array<Int> = Array(5){random.nextInt(0, 9)}
    print("Начальный массив: ")
    for (i in array){
        print("$i ")
    }
    println()
    map(array,::multiplication)
    print("Массив после умножения элементов на 2: ")
    for (i in array){
        print("$i ")
    }
    println()
    print("Массив после прибавлении к элементам 1: ")
    map(array, ::addition)
    for (i in array){
        print("$i ")
    }

}
fun mixColor(color1: String, color2: String): String {
    var resultColor = ""
    when {
        color1 == "красный" -> {
            if (color2 == "красный") resultColor = "красный"
            else if (color2 == "зеленый") resultColor = "желтый"
            else resultColor = "пурпурный"
        }

        color1 == "синий" -> {
            if (color2 == "красный") resultColor = "пурпурный"
            else if (color2 == "зеленый") resultColor = "голубой"
            else resultColor = "синий"
        }

        color1 == "зеленый" -> {
            if (color2 == "красный") resultColor = "желтый"
            else if (color2 == "зеленый") resultColor = "зеленый"
            else resultColor = "голубой"
        }
    }
    return  resultColor
}

fun action(color1: String, color2: String, op:(String, String) -> String): String{
    return mixColor(color1, color2)
}

fun addition(num: Int) = num + 1
fun multiplication(num: Int) = num * 2

fun map(array: Array<Int>, someFun: (Int) -> Int): Array<Int>{
    for (i in array.indices){
        array[i] = someFun(array[i])
    }
    return array
}