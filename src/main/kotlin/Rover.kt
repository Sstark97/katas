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

                movement is TURN -> {
                    this.direction = nextDirectionToFace(movement)
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

    private fun nextDirectionToFace(command: TURN): DIRECTION {
        val cardinalPoints = listOf(
            DIRECTION.NORTH,
            DIRECTION.EAST,
            DIRECTION.SOUTH,
            DIRECTION.WEST
        )
        val currentPoint = cardinalPoints.indexOf(this.direction)
        val isLastPosition = currentPoint == cardinalPoints.size - 1
        val isFirstPosition = currentPoint == 0

        return when (command) {
            TURN.RIGHT -> {
                if (isLastPosition) cardinalPoints.first() else cardinalPoints[currentPoint + 1]
            }

            else -> {
                if(isFirstPosition) cardinalPoints.last() else cardinalPoints[currentPoint - 1]
            }
        }
    }
}
