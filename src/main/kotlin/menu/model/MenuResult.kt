package menu.model

class MenuResult {
    private val menuResult = mutableMapOf<String, Map<Int, String>>()

    fun addUserMenus(name: String, menus: Map<Int, String>) {
        menuResult.put(name, menus)
    }

    fun getMenuResult(): Map<String, Map<Int, String>> {
        return menuResult.toMap()
    }
}
