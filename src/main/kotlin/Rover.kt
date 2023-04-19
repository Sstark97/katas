class Rover(private val position: Position, private val direction: DIRECTION) {
    fun followThisOrders(commands: List<Pair<MOVE, TURN>>) {
        if (commands.isEmpty()) {
            throw NotCommandException("Any command received")
        }
    }
}