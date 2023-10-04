import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith
class PositionTest {
    @Test
    fun `check if position is not negative`() {
        val exception = assertFailsWith<PositionOutOfBoundsException>(
            block = { Position(-1, -1) }
        )
        assertEquals(exception.message, "Negative position not allowed")
    }
}