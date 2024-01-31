
import java.sql.*;

public class jbdc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/databasetest1";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            String insertSQL = "INSERT INTO personnes (name, age, country, height) " +
                    "VALUES ('JP', '21', 'Lebanon', 1.80)";
            statement.executeUpdate(insertSQL);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM personnes");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int code = resultSet.getInt("age");
                String address = resultSet.getString("country");
                int age = resultSet.getInt("height");

                System.out.println("Name: " + name + ", Code: " + code + ", Address: " + address + ", Age: " + age);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}