import java.sql.*;

public class Main {

    public static void startJDBC() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1. LOADING AND REGISTERING THE DRIVER CLASS
            Class.forName("com.mysql.cj.jdbc.Driver");
            //DriverManager.registerDriver(new Driver());

            //2. ESTABLISHING THE CONNECTION
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo", "root", "root");
            if (!connection.isClosed()) {
                System.out.println("CONNECTION ESTABLISHED!");
            }

            //3. CREATE QUERY, STATEMENT/PREPARED STATEMENT/CALLABLE STATEMENT, EXECUTE QUERY
            String query = "SELECT * FROM EMPLOYEE";
            System.out.println("QUERY: " + query);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            //4. PROCESS DATA FORM RESULT SET
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double salary = resultSet.getDouble(3);
                System.out.println(id + " " + name + " " + salary);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //6. CLOSING RESULT SET, STATEMENT, CONNECTION
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        startJDBC();
    }
}