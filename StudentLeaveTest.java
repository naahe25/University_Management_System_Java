// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class StudentLeaveTest {
    @Test
    void testStudentLeavePresent() throws Exception {
        Conn c = new Conn();
        String rollno = "222-134-4444";
        String date = "2025-08-03";
        ResultSet rs = c.s.executeQuery("SELECT * FROM studentleave WHERE rollno='" + rollno + "' AND date='" + date + "'");
        assertTrue(rs.next(), "Student leave for " + rollno + " on " + date + " should exist");
    }
}
