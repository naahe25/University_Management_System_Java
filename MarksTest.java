import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class MarksTest {
    @Test
    void testMarksExistForStudent() throws Exception {
        Conn c = new Conn();
        String testRoll = "222-134-7777";
        ResultSet rs = c.s.executeQuery("SELECT * FROM marks WHERE rollno='" + testRoll + "'");
        assertTrue(rs.next(), "Marks for rollno " + testRoll + " should exist");
    }
}