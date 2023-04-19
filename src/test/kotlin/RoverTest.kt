import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

class RoverTest {

    private val startPosition = Position(0, 0)
    private val startDirection = DIRECTION.NORTH

    private val curiosity: Rover = Rover(startPosition, startDirection)

    @Test
    fun `check if there is any command`() {
        val exception = assertFailsWith<NotCommandException>(
            block = { curiosity.followThisOrders(listOf()) }
        )
        assertEquals(exception.message, "Any command received")
    }
}