import java.sql.*;
public class Conn {


    public Statement s1;

    public Conn(){
        Connection c;

        try {

        c = DriverManager.getConnection("jdbc:mysql:///bankmanegmentsystem","root", "1990bin");
        s1 = c.createStatement();

        } catch (SQLException e) {


            System.out.println(e);
        }
    }


}
