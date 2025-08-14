import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ConnTest {
    @Test
    void testConnectionAndStatement() {
        Conn conn = new Conn();
        assertNotNull(conn.c, "Connection should be established");
        assertNotNull(conn.s, "Statement should be created");
    }
}