/**
 * Created by kevin on 25/08/15.
 */

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DBMetaData {
    public static void main(String[] args) throws Exception {
        Connection con = initDriver();
        userInteraction(con);
//        makeQuery(con);
        con.close();
    }

    private static Connection initDriver() throws IOException, ClassNotFoundException, SQLException {
        FileInputStream fin = null;
        Properties prop = new Properties();
        fin = new FileInputStream("MyJDBC/src/main/resources/dbconnect.properties");
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

    public static DataSource initDataSource() {
        Properties props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
            fis = new FileInputStream("resources/db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mysqlDS;
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

    private static boolean searchDBforaBook(Connection con, String authorName, String bookName) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM buch WHERE autor=? AND titel=?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, authorName);
        statement.setString(2, bookName);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("count");
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    private static void userInteraction(Connection con) {
        Scanner scanner = new Scanner(System.in);
        String author = "none";
        String bookTitle = "none";
        System.out.println("Please enter author and the book title you want to search for:");
        author = scanner.nextLine();
        bookTitle = scanner.nextLine();
        boolean containsBook;
        try {
            containsBook = searchDBforaBook(con, author, bookTitle);
            System.out.println("Das Buch namens 'Mein Buch' vom Autor Kevin" +
                    " ist in der Datenbank vorhanden: " + containsBook);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}