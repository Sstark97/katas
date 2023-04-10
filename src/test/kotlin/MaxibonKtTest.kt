import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxibonKtTest {
    private val slackRepository: SlackRepository = SlackRepository()
    private  val maxibon: Maxibon = Maxibon(slackRepository)
    @Test
    fun `check that there are 10 ice creams when started` () {
        assertEquals(maxibon.getMaxibons(), 10)
    }

    @Test
    fun `check that there are 7 ice creams when Pedro takes ice creams` () {
        maxibon.take("Pedro")
        assertEquals(maxibon.getMaxibons(), 7)
    }

    @Test
    fun `check that there are 9 ice creams when Fran takes ice creams` () {
        maxibon.take("Fran")
        assertEquals(maxibon.getMaxibons(), 9)
    }

    @Test
    fun `check that there are 10 ice creams when David takes ice creams` () {
        maxibon.take("David")
        assertEquals(maxibon.getMaxibons(), 10)
    }

    @Test
    fun `check that there are 8 ice creams when Sergio takes ice creams` () {
        maxibon.take("Sergio")
        assertEquals(maxibon.getMaxibons(), 8)
    }

    @Test
    fun `check that there are 9 ice creams when Jorge takes ice creams` () {
        maxibon.take("Jorge")
        assertEquals(maxibon.getMaxibons(), 9)
    }

    @Test
    fun `check that there are 7 ice creams when Sergio and Jorge takes ice creams` () {
        val developers = listOf("Sergio", "Jorge")
        maxibon.takeInGroupOf(developers)
        assertEquals(maxibon.getMaxibons(), 7)
    }

    @Test
    fun `throw and Exception when ice creams are 2 and then there are 12` () {
        val developers = listOf("Sergio", "Jorge")
        maxibon.takeInGroupOf(developers)
        assertEquals(maxibon.getMaxibons(), 7)
    }

    @Test
    fun `send message with Slack API when ice creams are 2 and then there are 12`() {
        val developers = listOf("Sergio", "Fran", "Jorge")
        maxibon.takeInGroupOf(developers)
        maxibon.takeInGroupOf(developers)

        assertEquals(maxibon.getApiMessage(), "Hi guys, I'm Jorge. We need more maxibons!")
        assertEquals(maxibon.getMaxibons(), 12)
    }

    @Test
    fun `check that there are 10 ice creams if the number of maxibons left is lower than the number of maxibons the developer tries to get`() {
        val firstGroupOfDevelopers = listOf("Pedro", "Sergio", "Jorge")
        val secondGroupOfDevelopers = listOf("Sergio", "Pedro")

        maxibon.takeInGroupOf(firstGroupOfDevelopers)
        maxibon.takeInGroupOf(secondGroupOfDevelopers)

        assertEquals(maxibon.getMaxibons(), 10)
    }
}