import java.util.*    // required import

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    /*return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" ->  true
        else -> false
    }*/
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}



fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

//
//fun main(args: Array<String>) {
//    println("Hello, ${args[0]}")
//
//    // Will assign kotlin.Unit
//    val isUnit = println("This is an expression")
//    println(isUnit)
//
//    // val is if/else statement
//    val temperature = 10
//    val isHot = if (temperature > 50) true else false
//    println(isHot) //return false
//
//    //Statement in string template
//    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
//    println(message)
//
//
//    //function
//    feedTheFish()
//
//    //default
//    swim()   // uses default speed
//    swim("slow")   // positional argument
//    swim(speed="turtle-like")   // named parameter
//
//    //Make compact functions
//}

// Part 5:
// Step 1: Create a filter
//val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
//fun main() {
//    println( decorations.filter {it[0] == 'p'})
//}

//Step 2:  Compare eager and lazy filters
fun main() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // eager, creates a new list
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")
    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")



    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")



    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")
}


// Part 6: Get started with lambdas and higher-order functions
// Step 1: Learn about lambdas