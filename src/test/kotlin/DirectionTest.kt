import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

class DirectionTest {

    @Test
    fun `check if direction is valid`() {
        val exception = assertFailsWith<DirectionNotValidException>(
            block = { Direction("J") }
        )
        assertEquals(exception.message, "Direction not valid")
    }
}