/**
 * Created by kevin on 25/08/15.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;
public class DBMetaData {
    public static void main(String[] args)throws Exception{
        FileInputStream fin = null;
        Properties prop = new Properties();
        try {
            fin = new FileInputStream("MyJDBC/dbconnect.properties");
            prop.load(fin);
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        if (driver != null){
                Class.forName(driver);
        }
        Connection con = DriverManager.getConnection(url, user, password);
        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println("URL "+ dbmd.getURL());
        System.out.println("User "+ dbmd.getUserName());
        System.out.println("DatabaseProductname "+dbmd.getDatabaseProductName());
        System.out.println("");
        con.close();
    }
}

