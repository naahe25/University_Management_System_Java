import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class StudentDetailsTest {
    @Test
    void testStudentDetailsPresent() throws Exception {
        Conn c = new Conn();
        // Replace with actual rollno
        String rollno = "222-134-5555";
        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE rollno='" + rollno + "'");
        assertTrue(rs.next(), "Student details for " + rollno + " should exist");
    }
}