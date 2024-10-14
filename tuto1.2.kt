//fun main() {
//    var favoriteActor: String? = "Sandra Oh"
//    println(favoriteActor)
//    favoriteActor = null
//    println(favoriteActor)
//
//    var number: Int? = 10
//    println(number)
//    number = null
//    println(number)
//}

//fun main() {
//    var favoriteActor: String = "Sandra Oh"
//
////    println(favoriteActor.length)
////    println(favoriteActor?.length)  // fach kayt7dd type d var mymknch ikon null
////    println(favoriteActor!!.length) // kanzidoha f7alt kna mt2kdin var machi null
//}

//fun main() {
//    var favoriteActor: String? = null
//
//    if (favoriteActor != null) {
//        println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
//    } else {
//        println("You didn't input a name.")
//    }
//}

fun main() { // ida kan (favoriteActor = null) kay rj3 0 blast error
    var favoriteActor: String? = "Sandra Oh"
    val lengthOfName = favoriteActor?.length ?: 0  // elvis operator

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}

