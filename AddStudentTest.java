import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class AddStudentTest {

    @Test
    void testStudentDataPresent() throws Exception {
        Conn c = new Conn();
        // Replace with an actual rollno you want to test
        String testRoll = "222-134-9999";
        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE rollno='" + testRoll + "'");
        assertTrue(rs.next(), "Student with rollno " + testRoll + " should exist in DB");
        // Add more assertions as per your schema, e.g., check name, etc.
    }
}