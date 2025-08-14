import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class AddTeacherTest {

    private final String testName = "Test Teacher " + System.currentTimeMillis();

    @AfterEach
    void tearDown() throws Exception {
        Conn c = new Conn();
        c.s.executeUpdate("DELETE FROM teacher WHERE name='" + testName + "'");
    }

    @Test
    void testAddTeacherEntry() throws Exception {
        Conn c = new Conn();
        // Example minimal insert (add more fields as needed by your schema)
        String sql = "INSERT INTO teacher (name, fname,empId, dob, address, phone, email,nid, sscgpa, hscgpa,  education, department) VALUES (" +
                "'" + testName + "', 'Father Name', '921-8570', '1980-01-01', 'Address', '9876543210', 'test@teacher.com','5274264725', 9.0, 8.8,  'BSC Sofware Engineering', 'BSC Sofware Engineering\n')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count, "Insert should affect 1 row");

        ResultSet rs = c.s.executeQuery("SELECT * FROM teacher WHERE name='" + testName + "'");
        assertTrue(rs.next(), "Teacher entry should exist in DB after insert");
        assertEquals(testName, rs.getString("name"));
    }
}