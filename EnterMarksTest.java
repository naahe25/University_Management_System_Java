import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class EnterMarksTest {

    @Test
    void testMarksDataPresent() throws Exception {
        Conn c = new Conn();
        // Replace with a rollno and semester that you want to verify marks for
        String testRoll = "222-134-8888";
        String semester = "1";
        ResultSet rs = c.s.executeQuery("SELECT * FROM marks WHERE rollno='" + testRoll + "' AND semester='" + semester + "'");
        assertTrue(rs.next(), "Marks for rollno " + testRoll + " in semester " + semester + " should exist");
        // assertEquals(expectedMark, rs.getInt("marks1")); // and similar
    }
}