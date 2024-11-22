package menu.model

class MenuResult {
    private val menuResult = mutableMapOf<String, MutableList<String>>()

    fun initializeUser(name: String) {
        menuResult.set(name, mutableListOf())
    }

    fun addUserMenus(name: String, menu: String) {
        menuResult.get(name)?.add(menu)
    }

    fun getMenuResult(): Map<String, MutableList<String>> {
        return menuResult.toMap()
    }
}
