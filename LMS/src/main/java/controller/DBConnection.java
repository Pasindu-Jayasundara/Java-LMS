package controller;

import org.jetbrains.annotations.Nullable;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void connect(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void iud(String query){

        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static @Nullable ResultSet search(String query){

        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);

        } catch (SQLException e) {
           e.printStackTrace();
           return null;
        }

    }
}
