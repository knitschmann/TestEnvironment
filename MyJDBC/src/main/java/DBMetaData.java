/**
 * Created by kevin on 25/08/15.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBMetaData {
    public static void main(String[] args) throws Exception {
        Connection con = initDriver();
        makeQuery(con);
        con.close();
    }

    private static Connection initDriver() throws IOException, ClassNotFoundException, SQLException {
        FileInputStream fin = null;
        Properties prop = new Properties();
        fin = new FileInputStream("dbconnect.properties");
        prop.load(fin);
        fin.close();

        //read all settings from dbconnect.properties
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        if (driver != null) {
            Class.forName(driver);
        } else {
            //Standard Driver for XAMP MYSQL
            Class.forName("com.mysql.jdbc.Driver");
        }
        return DriverManager.getConnection(url, user, password);
    }

    private static void makeQuery(Connection con) throws SQLException {
        //make a Query
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM buch");

        //output Result Set of Query
        while (rs.next()) {
            System.out.println(
                    rs.getString("autor") + ", " +
                            rs.getString("titel")

            );
        }
    }
}