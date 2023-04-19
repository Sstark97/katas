import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

class RoverTest {

    private val curiosity: Rover = Rover(
        Position(0, 0),
        DIRECTION.NORTH
    )

    @Test
    fun `check if there is any command`() {
        val exception = assertFailsWith<NotCommandException>(
            block = { curiosity.followThisOrders([]) }
        )
        assertEquals(exception.message, "Any command received")
    }
}