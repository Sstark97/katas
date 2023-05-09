class Rover(private var position: Position, private var direction: DIRECTION, private val surface: Planet) {
    val MAX_LATITUDE = this.surface.latitude - 1
    val MAX_LONGITUDE = this.surface.longitude - 1

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
        val expectedPosition = this.position.clone()
        val movePosition =
            if (isFacingVertically) expectedPosition::moveVertically else expectedPosition::moveHorizontally
        val isMovingForward = movement == MOVE.FORWARD
        val isFacingNorthOrWest = this.direction == DIRECTION.NORTH || this.direction == DIRECTION.WEST
        val steps = stepsToMove(isFacingVertically, movement)

        if (isMovingForward) {
            if (isFacingNorthOrWest) movePosition(-steps) else movePosition(steps)
        } else {
            if (isFacingNorthOrWest) movePosition(steps) else movePosition(-steps)
        }

        if (surface.haveAnObstacleIn(expectedPosition)) {
            val verticalPosition = expectedPosition.getVertical()
            val horizontalPosition = expectedPosition.getHorizontal()
            throw ObstacleFoundException("Obstacle Found in ($verticalPosition, $horizontalPosition)")
        } else {
            this.position = expectedPosition
        }
    }

    private fun stepsToMove(isFacingVertically: Boolean, movement: MOVE) =
        if (isInVerticalLimit(movement)) -(MAX_LATITUDE)
        else if (isInHorizontalLimit(isFacingVertically, movement)) -(MAX_LONGITUDE)
        else 1

    private fun isInHorizontalLimit(isFacingVertically: Boolean, movement: MOVE) =
        ((this.position.getHorizontal() == 0 &&
            ((this.direction == DIRECTION.EAST && movement == MOVE.BACKWARD) ||
            this.direction == DIRECTION.WEST && movement == MOVE.FORWARD))
        || (this.position.getHorizontal() == MAX_LONGITUDE &&
            ((this.direction == DIRECTION.WEST && movement == MOVE.BACKWARD) ||
            (this.direction == DIRECTION.EAST && movement == MOVE.FORWARD)))) && !isFacingVertically

    private fun isInVerticalLimit(movement: MOVE): Boolean {
        return (position.getVertical() == 0 && moveOutOfUpperLimit(movement)) ||
                (position.getVertical() == MAX_LATITUDE && moveOutOfLowerLimit(movement))
    }

    private fun moveOutOfLowerLimit(movement: MOVE): Boolean {
        return direction == DIRECTION.NORTH && movement == MOVE.BACKWARD ||
                direction == DIRECTION.SOUTH && movement == MOVE.FORWARD
    }

    private fun moveOutOfUpperLimit(movement: MOVE): Boolean {
        return direction == DIRECTION.NORTH && movement == MOVE.FORWARD ||
                direction == DIRECTION.SOUTH && movement == MOVE.BACKWARD
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