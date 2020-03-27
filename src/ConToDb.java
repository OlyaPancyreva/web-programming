import java.sql.*;

public class ConToDb {

    /*  подключение к базе данных   */
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/servlet";
            String loginDB = "postgres";
            String passwordDB = "root";
            con = DriverManager.getConnection(url, loginDB, passwordDB);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }

    /*  создание и добавление пользователя в бд     */
    public static void createUser(String login, String password) throws SQLException {
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("INSERT INTO users VALUES (?, ?)");
        statement.setString(1, login);
        statement.setString(2, password);
        statement.executeUpdate();
        con.close();
    }
}
