class Position(private val x: Int, private val y: Int) {
    private val MIN: Int = 0
    
    init {
        val isNegativeInPosX = this.x < 0
        val isNegativeInPosY = this.y < 0
        if (isNegativeInPosX || isNegativeInPosY) {
            throw PositionOutOfBoundsException("Negative position not allowed")
        }
    }
}