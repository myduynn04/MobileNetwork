package example.myapp
import kotlin.math.PI
//class Aquarium {
//    var width: Int = 20
//    var height: Int = 40
//    var length: Int = 100
//    fun printSize() {
//        println("Width: $width cm " +
//                "Length: $length cm " +
//                "Height: $height cm ")
//    }
//}

open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    // Dimensions in cm
    init {
        println("aquarium initializing")
    }
//    init {
//        // 1 liter = 1000 cm^3
//        println("Volume: ${width * length * height / 1000} liters")
//    }
//    fun printSize() {
//        println("Width: $width cm " +
//                "Length: $length cm " +
//                "Height: $height cm ")
//        println("Volume: $volume liters")
//    }
    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    //Step 4
//    val volume: Int
//        get() = width * height * length / 1000  // 1000 cm^3 = 1 liter

    //Step 5:
//    var volume: Int
//        get() = width * height * length / 1000
//        private set(value) {
//            height = (value * 1000) / (width * length)
//        }

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }
    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    override var water = volume * 0.8
    override val shape = "cylinder"
}

fun buildAquarium() {
//    val myAquarium = Aquarium()
//    myAquarium.printSize()
//    myAquarium.height = 60
//    myAquarium.printSize()

//    val aquarium1 = Aquarium()
//    aquarium1.printSize()
//    // default height and length
//    val aquarium2 = Aquarium(width = 25)
//    aquarium2.printSize()
//    // default width
//    val aquarium3 = Aquarium(height = 35, length = 110)
//    aquarium3.printSize()
//    // everything custom
//    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
//    aquarium4.printSize()
//
//    val aquarium6 = Aquarium(numberOfFish = 29)
//    aquarium6.printSize()
//    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} liters")



//    val aquarium6 = Aquarium(numberOfFish = 29)
//    aquarium6.printSize()
//    aquarium6.volume = 70
//    aquarium6.printSize()

//    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
//    aquarium6.printSize()

    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()

}

fun main() {
    buildAquarium()
}