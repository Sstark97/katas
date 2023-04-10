data class Developer(val name: String, val maxibonToTake: Int)

class Maxibon(private val slackApi: SlackApi) {
    private var maxibons = 10
    private val LIMIT: Int = 2
    private val INCREMENT: Int = 10

    fun getMaxibons (): Int {
        return this.maxibons
    }

    fun take(developer: Developer) {
        this.maxibons -= if (this.maxibons < developer.maxibonToTake) this.maxibons else developer.maxibonToTake

        checkAmountOfMaxibonsAfterTakenBy(developer)
    }

    fun takeInGroupOf(developers: List<Developer>) {
        developers.forEach { developer -> this.take(developer) }
    }

    fun getApiMessage(): String {
        return this.slackApi.get()
    }

    private fun checkAmountOfMaxibonsAfterTakenBy(developer: Developer) {
        if (this.maxibons <= this.LIMIT) {
            this.maxibons += this.INCREMENT
            this.slackApi.send("Hi guys, I'm ${developer.name}. We need more maxibons!")
        }
    }
}
