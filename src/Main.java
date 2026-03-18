import com.servicefinder.database.DBConnection;
import java.sql.Connection;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();
        if (con != null) {
            System.out.println("Connection SUCCESS");
        } else {
            System.out.println("Connection FAILED");
        }

        SwingUtilities.invokeLater(() -> new com.servicefinder.ui.LoginPage());
    }
}