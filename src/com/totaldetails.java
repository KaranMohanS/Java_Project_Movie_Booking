package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class totaldetails {

    public static void total()
    {
    String query="SELECT b.book_id,b.book_date, "+
                   "t.theater_id, t.name AS theater_name, t.location, " +
                   "s.show_id, s.show_time, " +
                   "m.id AS movie_id, m.name AS movie_name, m.genre, m.language, " +
                   "u.id AS user_id, u.name AS user_name, u.email, " +
                   "s.cost " +
                   "FROM booking b " +
                   "JOIN theater t ON b.theater_id=t.theater_id "+
                   "JOIN show_details s ON t.show_id = s.show_id " +
                   "JOIN Movie m ON s.movie_id = m.id " +
                   "JOIN user u ON m.user_id = u.id";
    
    try{
    Connection connection=databaseconnection.getConnection();
    PreparedStatement p=connection.prepareStatement(query);
    ResultSet rs=p.executeQuery();
    
    while (rs.next()) {

            int bookid=rs.getInt("book_id");
            String bookdate=rs.getString("book_date");
            int theaterId = rs.getInt("theater_id");
            String theaterName = rs.getString("theater_name");
            String location = rs.getString("location");
            int showId = rs.getInt("show_id");
            String showTime = rs.getString("show_time");
            int movieId = rs.getInt("movie_id");
            String movieName = rs.getString("movie_name");
            String genre = rs.getString("genre");
            String language = rs.getString("language");
            int userId = rs.getInt("user_id");
            String userName = rs.getString("user_name");
            String email = rs.getString("email");
            int cost = rs.getInt("cost");
            
            System.out.println("Booking Id: "+bookid);
            System.out.println("Booking Date: "+bookdate);
            System.out.println("Theater ID: " + theaterId);
            System.out.println("Theater Name: " + theaterName);
            System.out.println("Location: " + location);
            System.out.println("Show ID: " + showId);
            System.out.println("Show Time: " + showTime);
            System.out.println("Movie ID: " + movieId);
            System.out.println("Movie Name: " + movieName);
            System.out.println("Genre: " + genre);
            System.out.println("Language: " + language);
            System.out.println("User ID: " + userId);
            System.out.println("User Name: " + userName);
            System.out.println("User Email: " + email);
            System.out.println("Cost: " + cost);
            System.out.println("--------------------");
    }
    
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
}
