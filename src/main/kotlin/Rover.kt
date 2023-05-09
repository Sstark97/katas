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
        val movePosition = if (isFacingVertically) expectedPosition::moveVertically else expectedPosition::moveHorizontally
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
        if (isInVerticalLimit(isFacingVertically, movement)) -(MAX_LATITUDE)
        else if (isInHorizontalLimit(isFacingVertically)) -(MAX_LONGITUDE)
        else 1

    private fun isInHorizontalLimit(isFacingVertically: Boolean) =
        (this.position.getHorizontal() == 0 || this.position.getHorizontal() == MAX_LONGITUDE) && !isFacingVertically

    private fun isInVerticalLimit(isFacingVertically: Boolean, movement: MOVE): Boolean {
        return (position.getVertical() == 0 &&
                (this.direction == DIRECTION.NORTH && movement == MOVE.FORWARD ||
                        this.direction == DIRECTION.SOUTH && movement == MOVE.BACKWARD)) ||
                (position.getVertical() == MAX_LATITUDE &&
                        (this.direction == DIRECTION.NORTH && movement == MOVE.BACKWARD ||
                    this.direction == DIRECTION.SOUTH && movement == MOVE.FORWARD))
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