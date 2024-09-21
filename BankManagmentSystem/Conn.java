import java.sql.SQLException;
import java.sql.*;


class Conn{
    

    Connection c ;
    Statement S;

    public Conn(){
       
        try{
            // Class.forName(com.mysql.cj.jdbc.Driver);

            c= DriverManager.getConnection("jdbc:mysql:///bankmanagemetsystem", "root", "Aditi@123");
            S= c.createStatement();


        }
        catch(Exception e){
            System.out.println(e);

        }
    }

}

