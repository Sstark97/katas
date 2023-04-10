class SlackRepository : SlackApi {
    private var message = ""

    override fun send(message: String) {
        this.message = message
    }

    override fun get(): String {
        return this.message
    }
}