class Maxibon {
    private var maxibons = 10;

    fun getMaxibons (): Int {
        return this.maxibons
    }

    fun take(developer: String) {
        when (developer) {
            "Pedro" -> this.maxibons -= 3
            "Fran", "Jorge" -> this.maxibons -= 1
            "Sergio" -> this.maxibons -= 2
        }

        checkAmountOfMaxibonsAfterTakenBy(developer)
    }

    private fun checkAmountOfMaxibonsAfterTakenBy(developer: String) {
        if (this.maxibons <= 2) {
            this.maxibons += 10
            throw MaxibonLimitException("Hi guys, I'm $developer. We need more maxibons!")
        }
    }

    fun takeInGroupOf(developers: List<String>) {
        developers.forEach { developer -> this.take(developer) }
    }
}