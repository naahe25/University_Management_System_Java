// --- Standard Assert Test ---
import org.junit.jupiter.api.Test;

public class ProjectTest {
    @Test
    void testProjectMainDoesNotThrow() {
        assertDoesNotThrow(() -> Project.main(new String[]{}));
    }
}
