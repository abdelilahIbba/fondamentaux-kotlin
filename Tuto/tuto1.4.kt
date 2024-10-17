fun main() {
    val coins: (Int) -> String = {
        "You have $it coins."
    }
//    val cupcake: (Int) -> String = { quantity ->
//        "Have a cupcake!"
//    }

    val treatFunction = trickOrTreat(false) { "You have $it coins." }
    val trickFunction = trickOrTreat(true, null)
    repeat(4) {
        treatFunction()
    }
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}
