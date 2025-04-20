package controller.common;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost/java_lms ";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Pasindu328@Bhathiya";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Integer iud(String query, Object... params) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            setParameters(preparedStatement, params);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            return null;

//            Statement statement = connection.createStatement();
//            statement.executeUpdate(query);
//            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ResultSet search(String query, Object... params) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            setParameters(preparedStatement, params);
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private static void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
        }
    }
}