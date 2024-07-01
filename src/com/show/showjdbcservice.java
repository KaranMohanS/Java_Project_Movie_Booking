package com.show;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class showjdbcservice {

   
    public static void addshow() throws SQLException
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
       
        //System.out.println("enter update query");
        String query="select show.id,Movie.movieid,Movie.name,Movie.genre,Movie.language";
        scanner.close();
        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement p=connection.prepareStatement(query);

        //p.setInt(1, show_id);

        p.executeQuery();







    }
    
}
