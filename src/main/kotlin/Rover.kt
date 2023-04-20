class Rover(private val position: Position, private var direction: DIRECTION) {
    fun followThisOrders(commands: List<Movement>) {
        if (commands.isEmpty()) {
            throw NotCommandException("Any command received")
        }

        when {
            commands[0] == MOVE.FORWARD && this.direction == DIRECTION.NORTH -> {
                this.position.moveVertically(-1)
            }
            commands[0] == TURN.LEFT -> {
                this.direction = DIRECTION.WEST
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
