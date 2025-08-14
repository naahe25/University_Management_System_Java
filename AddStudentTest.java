import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class AddStudentTest {

    private final String testName = "Test Student " + System.currentTimeMillis();

    @AfterEach
    void tearDown() throws Exception {
        Conn c = new Conn();
        c.s.executeUpdate("DELETE FROM student WHERE name='" + testName + "'");
    }

    @Test
    void testAddStudentEntry() throws Exception {
        Conn c = new Conn();
        // Example minimal insert (add more fields as needed by your schema)
        String sql = "INSERT INTO student (name, fname, dob, address, phone, email, sscgpa, hscgpa, nid, course, batch) VALUES (" +
                "'" + testName + "', 'Father Name', '2000-01-01', 'Address', '1234567890', 'test@student.com', 8.5, 8.0, '123456789', 'BSC Sofware Engineering', '20th Batch')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count, "Insert should affect 1 row");

        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE name='" + testName + "'");
        assertTrue(rs.next(), "Student entry should exist in DB after insert");
        assertEquals(testName, rs.getString("name"));
    }
}