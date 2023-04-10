interface SlackApi {
    fun send(message: String)
    fun get(): String
}
