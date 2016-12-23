package hangman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SingletonConnection {

    private static SingletonConnection instance = null;
    String URL = "jdbc:mysql://127.0.0.1/hangman?user=root&password=haslo";
    Connection conn;
    Statement st;

    private SingletonConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL);
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }
    
    int getQuantity(){
        ResultSet rs;
        int quantity = 0;
        try {
            rs = st.executeQuery("Select count(*) from haslo");
            rs.next();
            quantity = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return quantity;
    }
    
    String getPhrase(int rand){
        String phrase = "";
        try {
            ResultSet rs = st.executeQuery("Select do_zgadniecia from haslo where id = " + rand);
            rs.next();
            phrase = rs.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return phrase;
    }
    
    String getCategory(int rand){
        String category = "";
        try {
            ResultSet rs = st.executeQuery("Select kategoria from haslo where id = " + rand);
            rs.next();
            category = rs.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return category;
    }

    
    

}
