package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.*;

/**
 *
 * @author Vitoco
 */
public class ConexionDAO {
    private static Connection conn;
    String url = "jdbc:mysql://localhost:3306/distribuidora_tcg";
    String usuario = "admin_tcg";
    String password = "admin_tcg";

    private ConexionDAO() throws SQLException {
        DriverManager.registerDriver (new com.mysql.cj.jdbc.Driver());
        conn = DriverManager.getConnection(url, usuario, password);
    }

    public static Connection getConnection() throws SQLException 
    
    {
        if (conn == null) {
            new ConexionDAO();
        }
        return conn;
    }
}
