import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;

public class LoginTest {

    @Test
    void testAdminLoginSuccess() throws Exception {
        String username = "admin";
        String password = "12345";
        String query = "select * from login where username = '" + username + "' and password ='" + password + "'";
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        assertTrue(rs.next(), "Login should succeed for admin with correct password");
    }

    @Test
    void testAdminLoginFailure() throws Exception {
        String username = "admin";
        String password = "wrongpassword";
        String query = "select * from login where username = '" + username + "' and password ='" + password + "'";
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        assertFalse(rs.next(), "Login should fail for admin with incorrect password");
    }
}