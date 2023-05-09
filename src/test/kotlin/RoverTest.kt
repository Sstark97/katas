import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

class RoverTest {

    private val startPosition = Position(1, 1)
    private val startDirection = DIRECTION.NORTH
    private val obstacles = listOf(
        Obstacle(Position(2,2)),
        Obstacle(Position(0,4)),
        Obstacle(Position(5,3))
    )
    private val mars = Planet(6,6, obstacles)

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
    fun `if curiosity moves out of upper limit facing north, it appears on the opposite side`() {
        val commands = listOf(MOVE.FORWARD, MOVE.FORWARD)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(5,1), curiosity.getCurrentPosition())
    }

    @Test
    fun `if curiosity moves out of lower limit facing south, it appears on the opposite side`() {
        val commands = listOf(TURN.LEFT, TURN.LEFT, MOVE.FORWARD, MOVE.FORWARD, MOVE.FORWARD, MOVE.FORWARD, MOVE.FORWARD)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(0,1), curiosity.getCurrentPosition())
    }

    @Test
    fun `if curiosity moves out of left limit facing west, it appears on the opposite side`(){
        val commands = listOf(TURN.LEFT, MOVE.FORWARD, MOVE.FORWARD)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(1,5), curiosity.getCurrentPosition())
    }

    @Test
    fun `if curiosity moves out of right limit facing east, it appears on the opposite side`(){
        val commands = listOf(TURN.RIGHT, MOVE.FORWARD, MOVE.FORWARD, MOVE.FORWARD, MOVE.FORWARD, MOVE.FORWARD)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(1,0), curiosity.getCurrentPosition())
    }

    @Test
    fun `if curiosity moves out of upper limit facing south, it appears on the opposite side`() {
        val commands = listOf(TURN.LEFT, TURN.LEFT, MOVE.BACKWARD, MOVE.BACKWARD)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(5,1), curiosity.getCurrentPosition())
    }

    @Test
    fun `if curiosity moves out of lower limit facing north, it appears on the opposite side`() {
        val commands = listOf(MOVE.BACKWARD, MOVE.BACKWARD, MOVE.BACKWARD, MOVE.BACKWARD, MOVE.BACKWARD)
        curiosity.followTheseOrders(commands)

        assertEquals(Position(0,1), curiosity.getCurrentPosition())
    }

    @Test
    fun `if curiosity detects an obstacle, aborts the orders and reports it`() {
        val commands = listOf(MOVE.BACKWARD, TURN.RIGHT, MOVE.FORWARD, MOVE.FORWARD)

        val exception = assertFailsWith<ObstacleFoundException>(
            block = { curiosity.followTheseOrders(commands) }
        )

        assertEquals(exception.message, "Obstacle Found in (2, 2)")
        assertEquals(Position(2,1), curiosity.getCurrentPosition())
    }

    @Test
    fun `if curiosity moves out of upper limit facing north, should keep moving forward`() {
        val commands = listOf(MOVE.FORWARD, MOVE.FORWARD, MOVE.FORWARD)

        curiosity.followTheseOrders(commands)

        assertEquals(Position(4,1), curiosity.getCurrentPosition())
    }
}