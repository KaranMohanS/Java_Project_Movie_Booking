package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseconnection {
    
    private static final String path="jdbc:mysql://localhost:3306/movie";
    private static final String username="root";
    private static final String password="1234";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(path, username, password);
    }
}
