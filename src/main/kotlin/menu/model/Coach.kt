package menu.model

class Coach(private val name: String) {

    private var hateMenus = mutableListOf<String>()

    init {
        validateName()
    }

    private fun validateName() {
        require(name.length in 2..4) {
            "[ERROR] 코치의 이름은 2글자 이상 4글자 이하 이여야 합니다."
        }
    }

    fun getName() = name

    fun setHateMenu(hateMenu: List<String>) {
        validateMenus(hateMenu)
        hateMenu.forEach { hateMenus.add(it.trim()) }
    }

    private fun validateMenus(hateMenu: List<String>) {
        require(hateMenu.size == hateMenu.distinct().size) {
            "[ERROR] 중복된 메뉴가 존재합니다."
        }
        require(hateMenu.size <= 2) {
            "[ERROR] 메뉴는 2개까지 입력 가능합니다."
        }
        // TODO("기존 음식에 해당하는 지 확인")
    }


}