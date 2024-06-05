
import java.sql.*;

public class DbConnection {
    
    Connection con;
    Statement st;
    
    public DbConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsimulator", "root","Swathi---@2003");
            st = con.createStatement();
        }catch(Exception e){
        System.out.println(e);
    }
    }
}
