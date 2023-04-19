class Position(private val x: Int, private val y: Int) {
    init {
        if (this.x < 0 || this.y < 0) {
            throw PositionOutOfBoundsException("Negative position not allowed")
        }
    }
}