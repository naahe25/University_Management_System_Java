import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class TeacherLeaveTest {
    @Test
    void testTeacherLeavePresent() throws Exception {
        Conn c = new Conn();
        String empId = "921-4444";
        String date = "2025-08-03";
        ResultSet rs = c.s.executeQuery("SELECT * FROM teacherleave WHERE emp_id='" + empId + "' AND date='" + date + "'");
        assertTrue(rs.next(), "Teacher leave for " + empId + " on " + date + " should exist");
    }
}