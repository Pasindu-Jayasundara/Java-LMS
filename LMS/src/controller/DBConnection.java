package controller;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost/java_lms ";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Pasindu328@Bhathiya";

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

    public static ResultSet search(String query){

        System.out.println(query);
        
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            return statement.executeQuery(query);

        } catch (SQLException e) {
           e.printStackTrace();
           return null;
        }

    }
}