// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class TeacherDetailsTest {
    @Test
    void testTeacherDetailsPresent() throws Exception {
        Conn c = new Conn();
        String empId = "921-5555";
        ResultSet rs = c.s.executeQuery("SELECT * FROM teacher WHERE emp_id='" + empId + "'");
        assertTrue(rs.next(), "Teacher details for " + empId + " should exist");
    }
}
