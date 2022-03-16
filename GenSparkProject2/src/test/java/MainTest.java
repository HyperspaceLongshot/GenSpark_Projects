import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void verifyGuessRangeTest() {

        for (int i = 1; i <= 100; i++) {
            if (i <= 20) {
                assertTrue(Main.verifyGuessRange(i), "Fail: " + i);
                if (Main.verifyGuessRange(i)){
                    System.out.println("Index: " + i);
                }
            } else {
                assertFalse(Main.verifyGuessRange(i), "Fail: " + i);
                if (!Main.verifyGuessRange(i)){
                    System.out.println("Index: " + i);
                }
            }
        }
    }
}