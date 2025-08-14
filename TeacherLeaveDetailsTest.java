// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class TeacherLeaveDetailsTest {
    @Test
    void testTeacherLeaveDetailsPresent() throws Exception {
        Conn c = new Conn();
        String empId = "921-3333";
        ResultSet rs = c.s.executeQuery("SELECT * FROM teacherleave WHERE emp_id='" + empId + "'");
        assertTrue(rs.next(), "Teacher leave details for " + empId + " should exist");
    }
}
