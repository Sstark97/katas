import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

class PlanetTest {
    @Test
    fun `check if Planet dimension is not negative`() {
        val obstacles = listOf(
            Obstacle(Position(2,2))
        )
        val exception = assertFailsWith<DimensionOutOfBoundsException>(
            block = { Planet(-1, -1, obstacles) }
        )
        assertEquals(exception.message, "Negative dimension not allowed")
    }
}