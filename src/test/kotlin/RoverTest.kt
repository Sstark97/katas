import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

class RoverTest {

    private val startPosition = Position(1, 1)
    private val startDirection = DIRECTION.NORTH
    private val mars = Planet(3,3)

    private val curiosity: Rover = Rover(startPosition, startDirection, mars)

    @Test
    fun `check if there is any command`() {
        val exception = assertFailsWith<NotCommandException>(
            block = { curiosity.followTheseOrders(listOf()) }
        )
        assertEquals(exception.message, "Any command received")
    }

    @Test
    fun `check if curiosity moves correctly with one command`(){
        val commands = listOf(MOVE.FORWARD)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(0,1), curiosity.getCurrentPosition())
    }

    @Test
    fun `check if curiosity turns correctly with one command`(){
        val commands = listOf(TURN.LEFT)
        curiosity.followTheseOrders(commands)

        assertEquals(DIRECTION.WEST, curiosity.getCurrentDirection())
    }

    @Test
    fun `check if curiosity moves and turns correctly`(){
        val commands = listOf(MOVE.BACKWARD, TURN.RIGHT)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(2,1), curiosity.getCurrentPosition())
        assertEquals(DIRECTION.EAST, curiosity.getCurrentDirection())
    }

    @Test
    fun `check if curiosity moves, turns and moves correctly`() {
        val commands = listOf(MOVE.FORWARD, TURN.LEFT, MOVE.FORWARD)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(0,0), curiosity.getCurrentPosition())
        assertEquals(DIRECTION.WEST, curiosity.getCurrentDirection())
    }

    @Test
    fun `if curiosity moves out of upper limit, it appears on the opposite side`() {
        val commands = listOf(MOVE.FORWARD, MOVE.FORWARD)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(2,1), curiosity.getCurrentPosition())
    }

}