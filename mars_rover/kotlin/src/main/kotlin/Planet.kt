class Planet(val latitude: Int, val longitude: Int, val obstacles: List<Obstacle>) {
    private val MIN: Int = 0

    init {
        val isNegativeLatitude = this.latitude < this.MIN
        val isNegativeLongitude = this.longitude < this.MIN
        if (isNegativeLatitude || isNegativeLongitude) {
            throw DimensionOutOfBoundsException("Negative dimension not allowed")
        }
    }

    fun haveAnObstacleIn(position: Position): Boolean {
        return obstacles.any { it.position == position }
    }
}
