import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

class RoverTest {

    private val startPosition = Position(1, 1)
    private val startDirection = DIRECTION.NORTH

    private val curiosity: Rover = Rover(startPosition, startDirection)

    @Test
    fun `check if there is any command`() {
        val exception = assertFailsWith<NotCommandException>(
            block = { curiosity.followThisOrders(listOf()) }
        )
        assertEquals(exception.message, "Any command received")
    }

    @Test
    fun `check if curiosity moves correctly with one command`(){
        val commands = listOf(MOVE.FORWARD)
        curiosity.followThisOrders(commands)

        assertEquals(Position(0,1), curiosity.getCurrentPosition())
    }

    @Test
    fun `check if curiosity turns correctly with one command`(){
        val commands = listOf(TURN.LEFT)
        curiosity.followThisOrders(commands)

        assertEquals(DIRECTION.WEST, curiosity.getCurrentDirection())
    }
}