import org.junit.*;
import org.junit.Assert.*;

class Task2Test:

    @Test def testStrings() =
        val s = "Ciao"
        val predicate: (String => Boolean) = (s) => s.length() % 2 == 0
        assertTrue:
            predicate(s)
        assertFalse:
            Task2a.genericNeg(predicate)(s)
    
    @Test def testInts() =
        val predicate: (Int => Boolean) = (s) => s % 2 == 0
        assertTrue:
            predicate(8)
        assertFalse:
            Task2a.genericNeg(predicate)(8)