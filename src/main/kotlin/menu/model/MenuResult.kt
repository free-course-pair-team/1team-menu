package menu.model

class MenuResult {
    private val menuResult = mutableMapOf<String, MutableList<String>>()

    fun addUserMenus(name: String, menu: String) {
        if (name in menuResult.keys) {
            menuResult.get(name)?.add(menu)
        } else {
            menuResult.set(name, mutableListOf(menu))
        }
    }

    fun getMenuResult(): Map<String, MutableList<String>> {
        return menuResult.toMap()
    }
}
