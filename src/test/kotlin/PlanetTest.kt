import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

class PlanetTest {
    @Test
    fun `check if Planet dimension is not negative`() {
        val exception = assertFailsWith<DimensionOutOfBoundsException>(
            block = { Planet(-1, -1) }
        )
        assertEquals(exception.message, "Negative dimension not allowed")
    }
}