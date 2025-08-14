import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class AddTeacherTest {

    @Test
    void testTeacherDataPresent() throws Exception {
        Conn c = new Conn();
        // Replace with an actual emp_id you want to test
        String testEmpId = "921-9999";
        ResultSet rs = c.s.executeQuery("SELECT * FROM teacher WHERE emp_id='" + testEmpId + "'");
        assertTrue(rs.next(), "Teacher with emp_id " + testEmpId + " should exist in DB");
        // Add more assertions as per your schema
    }
}