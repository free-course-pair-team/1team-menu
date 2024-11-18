package menu

data class Coach(val name: String,private val avoidFoods:List<String>){
    fun getAvoidFoods() = avoidFoods.toList()
}