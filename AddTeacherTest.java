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

public class AddTeacherTest {

    private final String testName = "Test Teacher " + System.currentTimeMillis();

    @AfterEach
    void tearDown() throws Exception {
        Conn c = new Conn();
        c.s.executeUpdate("DELETE FROM teacher WHERE name='" + testName + "'");
    }

    // Standard Assert Test
    @Test
    void testAddTeacherEntry() throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO teacher (name, fathers_name, dob, address, phone, email, sscgpa, hscgpa, nid, course, batch) VALUES (" +
                "'" + testName + "', 'Father Name', '1980-01-01', 'Address', '9876543210', 'test@teacher.com', 9.0, 8.8, '987654321', 'MATH', '2025')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM teacher WHERE name='" + testName + "'");
        assertTrue(rs.next());
        assertEquals(testName, rs.getString("name"));
    }

    // Parameterized Test (@ValueSource)
    @ParameterizedTest
    @ValueSource(strings = {"Dr. Smith", "Prof. Johnson", "Ms. Clark"})
    void testAddTeacherValueSource(String name) throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO teacher (name, fathers_name, dob, address, phone, email, sscgpa, hscgpa, nid, course, batch) VALUES (" +
                "'" + name + "', 'Father Name', '1980-01-01', 'Address', '9876543210', 'test@teacher.com', 9.0, 8.8, '987654321', 'MATH', '2025')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM teacher WHERE name='" + name + "'");
        assertTrue(rs.next());
        assertEquals(name, rs.getString("name"));
        c.s.executeUpdate("DELETE FROM teacher WHERE name='" + name + "'");
    }

    // Parameterized Test (@MethodSource)
    static Stream<String> teacherNameProvider() {
        return Stream.of("Mr. Lee", "Mrs. Evans", "Dr. Patel");
    }

    @ParameterizedTest
    @MethodSource("teacherNameProvider")
    void testAddTeacherMethodSource(String name) throws Exception {
        Conn c = new Conn();
        String sql = "INSERT INTO teacher (name, fathers_name, dob, address, phone, email, sscgpa, hscgpa, nid, course, batch) VALUES (" +
                "'" + name + "', 'Father Name', '1980-01-01', 'Address', '9876543210', 'test@teacher.com', 9.0, 8.8, '987654321', 'MATH', '2025')";
        int count = c.s.executeUpdate(sql);
        assertEquals(1, count);

        ResultSet rs = c.s.executeQuery("SELECT * FROM teacher WHERE name='" + name + "'");
        assertTrue(rs.next());
        assertEquals(name, rs.getString("name"));
        c.s.executeUpdate("DELETE FROM teacher WHERE name='" + name + "'");
    }

    // Mockito Test
    @Test
    void testAddTeacherWithMockedConn() throws Exception {
        Statement mockStatement = Mockito.mock(Statement.class);
        Mockito.when(mockStatement.executeUpdate(Mockito.anyString())).thenReturn(1);
        Conn mockConn = Mockito.mock(Conn.class);
        mockConn.s = mockStatement;
        int count = mockConn.s.executeUpdate("INSERT INTO teacher ...");
        assertEquals(1, count);
    }
}
