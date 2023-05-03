class Rover(private val position: Position, private var direction: DIRECTION) {
    fun followTheseOrders(commands: List<Movement>) {
        if (commands.isEmpty()) {
            throw NotCommandException("Any command received")
        }
        commands.forEach { movement ->
            when (movement) {
                is MOVE -> {
                    this.nextPosition(movement)
                }
                is TURN -> {
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
    private fun nextPosition(movement: MOVE) {
        val isFacingVertically = this.direction == DIRECTION.NORTH || this.direction == DIRECTION.SOUTH
        val movePosition = if (isFacingVertically) this.position::moveVertically else this.position::moveHorizontally
        val isMovingForward = movement == MOVE.FORWARD
        val isFacingNorthOrWest = this.direction == DIRECTION.NORTH || this.direction == DIRECTION.WEST
        if (isMovingForward) {
            if (isFacingNorthOrWest) movePosition(-1) else movePosition(1)
        } else {
            if (isFacingNorthOrWest) movePosition(1) else movePosition(-1)
        }
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
                if (isFirstPosition) cardinalPoints.last() else cardinalPoints[currentPoint - 1]
            }
        }
    }
}