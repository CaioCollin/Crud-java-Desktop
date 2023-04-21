package DAO;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class ConexaoDAO {

    public Connection conectaBD() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/cdjogos?user=root&password=";
            conn = DriverManager.getConnection(url);            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + e);
        }

        return conn;
    }

}
