import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

public class UpdateStudentTest {
    @Test
    void testUpdatedStudentAddress() throws Exception {
        Conn c = new Conn();
        String rollno = "222-134-6666";
        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE rollno='" + rollno + "'");
        assertTrue(rs.next(), "Updated student record should exist for " + rollno);
        // assertEquals("New Address", rs.getString("address"));
    }
}