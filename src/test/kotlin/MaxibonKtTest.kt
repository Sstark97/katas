import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxibonKtTest {
    private  val maxibon: Maxibon = Maxibon()
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
}