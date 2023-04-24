class Position(private var row: Int, private var col: Int) {
    private val MIN: Int = 0
    
    init {
        val isNegativeInPosX = this.row < 0
        val isNegativeInPosY = this.col < 0
        if (isNegativeInPosX || isNegativeInPosY) {
            throw PositionOutOfBoundsException("Negative position not allowed")
        }
    }

    fun moveVertically(position: Int) {
        this.row += position
    }

    override fun toString(): String {
        return "Position(row=$row, col=$col)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (row != other.row) return false
        return col == other.col
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + col
        return result
    }

}