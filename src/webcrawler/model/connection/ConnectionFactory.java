package webcrawler.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/PREFEITURA_MC";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível acessar a classe de Conexão.\n");
            return null;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Não foi possível acessar o banco de dados.\n");
            return null;
        }
    }
    
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
                System.out.println("Não foi possível encerrar a Connection.\n");
            }
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
                System.out.println("Não foi possível encerrar o PreparedStatement.\n");
            }
        }
        closeConnection(conn);
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
                System.out.println("Não foi possível encerrar o ResultSet.\n");
            }
        }
        closeConnection(conn, stmt);
    }
    
}
