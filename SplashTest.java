// --- Standard Assert Test ---
import org.junit.jupiter.api.Test;

public class SplashTest {
    @Test
    void testSplashMainDoesNotThrow() {
        assertDoesNotThrow(() -> Splash.main(new String[]{}));
    }
}
