class Rover(private val position: Position, private val direction: DIRECTION) {
    fun followThisOrders(commands: List<Movement>) {
        if (commands.isEmpty()) {
            throw NotCommandException("Any command received")
        }

        if(commands[0] == MOVE.FORWARD && this.direction == DIRECTION.NORTH) {
            this.position.moveVertically(-1)
        }
    }

    fun getCurrentPosition(): Position {
        return this.position
    }
}
