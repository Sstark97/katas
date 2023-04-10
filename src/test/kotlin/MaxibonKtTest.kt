import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxibonKtTest {
    private val slackRepository: SlackRepository = SlackRepository()
    private  val maxibon: Maxibon = Maxibon(slackRepository)
    @Test
    fun `check that there are 10 ice creams when started` () {
        assertEquals(10,maxibon.getMaxibons())
    }

    @Test
    fun `check that there are 7 ice creams when Pedro takes ice creams` () {
        val developer = Developer("Pedro", 3)

        maxibon.take(developer)
        assertEquals(7, maxibon.getMaxibons())
    }

    @Test
    fun `check that there are 9 ice creams when Fran takes ice creams` () {
        val developer = Developer("Fran", 1)

        maxibon.take(developer)
        assertEquals(9, maxibon.getMaxibons())
    }

    @Test
    fun `check that there are 10 ice creams when David takes ice creams` () {
        val developer = Developer("David", 0)

        maxibon.take(developer)
        assertEquals(10, maxibon.getMaxibons())
    }

    @Test
    fun `check that there are 8 ice creams when Sergio takes ice creams` () {
        val developer = Developer("Sergio", 2)

        maxibon.take(developer)
        assertEquals(8, maxibon.getMaxibons())
    }

    @Test
    fun `check that there are 9 ice creams when Jorge takes ice creams` () {
        val developer = Developer("Sergio", 1)

        maxibon.take(developer)
        assertEquals(9, maxibon.getMaxibons())
    }

    @Test
    fun `check that there are 7 ice creams when Sergio and Jorge takes ice creams` () {
        val developers = listOf(
            Developer("Sergio", 2),
            Developer("Jorge", 1)
        )
        maxibon.takeInGroupOf(developers)
        assertEquals(7, maxibon.getMaxibons())
    }

    @Test
    fun `send message with Slack API when ice creams are 2 and then there are 12`() {
        val developers = listOf(
            Developer("Sergio", 2),
            Developer("Fran", 1),
            Developer("Jorge", 1)
        )
        maxibon.takeInGroupOf(developers)
        maxibon.takeInGroupOf(developers)

        assertEquals("Hi guys, I'm Jorge. We need more maxibons!", maxibon.getApiMessage())
        assertEquals(12, maxibon.getMaxibons())
    }

/*    @Test
    fun `check that there are 10 ice creams if the number of maxibons left is lower than the number of maxibons the developer tries to get`() {
        val firstGroupOfDevelopers = listOf("Pedro", "Sergio", "Jorge")
        val secondGroupOfDevelopers = listOf("Sergio", "Pedro")

        maxibon.takeInGroupOf(firstGroupOfDevelopers)
        maxibon.takeInGroupOf(secondGroupOfDevelopers)

        assertEquals(10, maxibon.getMaxibons())
    }*/

    @Test
    fun `check that there are 20 ice creams when started` () {
        val maxibon = Maxibon(slackRepository, 20)
        assertEquals(20,maxibon.getMaxibons())
    }

    @Test
    fun `check that there are 12 ice creams when started with 2` () {
        val maxibon = Maxibon(slackRepository, 2)
        assertEquals(12, maxibon.getMaxibons())
    }

    @Test
    fun `check that there are 10 ice creams when started negative numbers` () {
        val maxibon = Maxibon(slackRepository, -5)
        assertEquals(10, maxibon.getMaxibons())
    }
}