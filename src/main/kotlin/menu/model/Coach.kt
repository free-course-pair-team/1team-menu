package menu.model

class Coach(private val name: String) {


    private val notEatMenu = emptyList<String>()

    init {
        validateName()
    }

    private fun validateName() {
        require( name.length in 2..4 ) {
            "[ERROR] 코치의 이름은 2글자 이상 4글자 이하 이여야 합니다."
        }
    }

}