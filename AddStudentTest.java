// --- Standard Assert Test ---
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;

// --- Parameterized Test (@ValueSource) ---
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// --- Parameterized Test (@MethodSource) ---
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

// --- Mockito Test ---
import org.mockito.Mockito;

public class AddStudentTest {

    private final String testName = "Test Student " + System.currentTimeMillis();

    @AfterEach
    void tearDown() throws Exception {
        Conn c = new Conn();
        c.s.executeUpdate("DELETE FROM student WHERE name='" + testName + "'");
    }

    // Standard Assert Test
    @Test
    void testAddStudentEntry() throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO student (name, fathers_name, dob, address, phone, email, sscgpa, hscgpa, nid, course, batch) VALUES (" +
                "'" + testName + "', 'Father Name', '2000-01-01', 'Address', '1234567890', 'test@student.com', 8.5, 8.0, '123456789', 'CS', '2025')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count, "Insert should affect 1 row");

        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE name='" + testName + "'");
        assertTrue(rs.next(), "Student entry should exist in DB after insert");
        assertEquals(testName, rs.getString("name"));
    }

    // Parameterized Test (@ValueSource)
    @ParameterizedTest
    @ValueSource(strings = {"Alice", "Bob", "Charlie"})
    void testAddStudentValueSource(String name) throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO student (name, fathers_name, dob, address, phone, email, sscgpa, hscgpa, nid, course, batch) VALUES (" +
                "'" + name + "', 'Father Name', '2000-01-01', 'Address', '1234567890', 'test@student.com', 8.5, 8.0, '123456789', 'CS', '2025')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE name='" + name + "'");
        assertTrue(rs.next());
        assertEquals(name, rs.getString("name"));
        c.s.executeUpdate("DELETE FROM student WHERE name='" + name + "'");
    }

    // Parameterized Test (@MethodSource)
    static Stream<String> studentNameProvider() {
        return Stream.of("Daniel", "Eve", "Frank");
    }

    @ParameterizedTest
    @MethodSource("studentNameProvider")
    void testAddStudentMethodSource(String name) throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO student (name, fathers_name, dob, address, phone, email, sscgpa, hscgpa, nid, course, batch) VALUES (" +
                "'" + name + "', 'Father Name', '2000-01-01', 'Address', '1234567890', 'test@student.com', 8.5, 8.0, '123456789', 'CS', '2025')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM student WHERE name='" + name + "'");
        assertTrue(rs.next());
        assertEquals(name, rs.getString("name"));
        c.s.executeUpdate("DELETE FROM student WHERE name='" + name + "'");
    }

    // Mockito Test
    @Test
    void testAddStudentWithMockedConn() throws Exception {
        Statement mockStatement = Mockito.mock(Statement.class);
        Mockito.when(mockStatement.executeUpdate(Mockito.anyString())).thenReturn(1);
        Conn mockConn = Mockito.mock(Conn.class);
        mockConn.s = mockStatement;
        int count = mockConn.s.executeUpdate("INSERT INTO student ...");
        assertEquals(1, count);
    }
}
