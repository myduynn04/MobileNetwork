package example.myapp

//abstract class AquariumFish {
//    abstract val color: String
//}

//class Shark: AquariumFish(), FishAction {
//    override val color = "grey"
//    override fun eat() {
//        println("hunt and eat fish")
//    }
//}

//class Plecostomus: FishAction, FishColor {
//    override val color = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
//}

//  create an interface called FishAction
interface FishAction  {
    fun eat()

}
interface FishColor {
    val color: String
}
//class Plecostomus: FishAction, FishColor {
//    override val color = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
//}

//class Plecostomus(fishColor: FishColor = GoldColor):  FishAction,
//    FishColor by fishColor {
//    override fun eat() {
//        println("eat algae")
//    }
//}

class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

class Shark: FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

//abstract class AquariumFish : FishAction {
//    abstract val color: String
//    override fun eat() = println("yum")
//}

object GoldColor : FishColor {
    override val color = "gold"
}


class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}