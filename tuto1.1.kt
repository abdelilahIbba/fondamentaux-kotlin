fun main() {
    val trafficLightColor = "Amber"
    // 1- if statement
//     if (trafficLightColor == "Red")
//     {
//         println("Stop")
//     }
//     else if (trafficLightColor == "Yellow")
//     {
//         println("Slow")
//     }
//     else {
//         println("Go")
//     }

//    val message =
//        if (trafficLightColor == "Red") "Stop"
//        else if (trafficLightColor == "Yellow") "Slow"
//        else if (trafficLightColor == "Green") "Go"
//        else "Invalid traffic-light color"
//
//    println(message)

    // 2- when statement
    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow", "Amber" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }
//    val x: Any = 12
//    when (x) {
////        2 -> println("x is a prime number between 1 and 10.") ...
//        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
//        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
//        is String -> println("x is a string.")
//        is Int -> println("x is an integer number, but not between 1 and 10.")
//        else -> println("x is not a prime number between 1 and 10.")
//    }
}
