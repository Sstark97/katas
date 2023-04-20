class Rover(private val position: Position, private var direction: DIRECTION) {
    fun followThisOrders(commands: List<Movement>) {
        if (commands.isEmpty()) {
            throw NotCommandException("Any command received")
        }

        commands.forEach { movement ->
            when {
                movement == MOVE.FORWARD && this.direction == DIRECTION.NORTH -> {
                    this.position.moveVertically(-1)
                }
                movement == MOVE.BACKWARD && this.direction == DIRECTION.NORTH -> {
                    this.position.moveVertically(1)
                }
                movement == TURN.LEFT -> {
                    this.direction = DIRECTION.WEST
                }
                movement == TURN.RIGHT -> {
                    this.direction = DIRECTION.EAST
                }
            }
        }
    }

    fun getCurrentPosition(): Position {
        return this.position
    }

    fun getCurrentDirection(): DIRECTION {
        return this.direction
    }
}
