import org.junit.*;
import org.junit.Assert.*;

class Task3Test:

    @Test def testGCD(): Unit =
        assertEquals(4, Task3.gcd(12, 8))
        assertEquals(7, Task3.gcd(14, 7))
        assertEquals(7, Task3.gcd(0, 7))
    