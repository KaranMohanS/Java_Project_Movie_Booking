package com.theater;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.databaseconnection;

public class theaterjdbcservice {
 
    
    public static void addtheater() throws SQLException     // add
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter theater name");
        String name=scanner.nextLine();
        System.out.println("enter theater location");
        String location=scanner.nextLine();
        System.out.println("enter show id ");
        int show_id=scanner.nextInt();
        scanner.close();
        String query="insert into theater(name,location,show_id) values(?,?,?)";

        Connection connection=databaseconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement(query);
    
        ps.setString(1, name);
        ps.setString(2, location);
        ps.setInt(3, show_id);
        int row=ps.executeUpdate();
        System.out.println("number of row affected:"+row);
        connection.close();
        ps.close();
    }


    public static void updatetheater() throws SQLException   // update
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement(query);
        int row=ps.executeUpdate();
        System.out.println("number of row affected:"+row);
        connection.close();
        ps.close();
    }

    public static void gettheater() throws SQLException      //  get
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter get query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        java.sql.Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println("theater id :"+rs.getInt(1)+" "+"theater name :"+rs.getString(2)+" "+"theater location :"+rs.getString(3)+" "+"show id :"+rs.getInt(4));

        }

        connection.close();
        st.close();
        rs.close();
    }


    public static void deletetheater() throws SQLException  //delete
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();
        
        Connection connection=databaseconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement(query);
        int row=ps.executeUpdate();
        System.out.println("number of row affected:"+row);
    }


    public static void printtheater() throws SQLException   // print
    {
        String query="select * from theater";
        Connection connection=databaseconnection.getConnection();
        java.sql.Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println("theater id :"+rs.getInt(1)+" "+"theater name :"+rs.getString(2)+" "+"theater location :"+rs.getString(3)+" "+"show id :"+rs.getInt(4));

        }
        connection.close();
        st.close();
        rs.close();
    }

    public static void totaldetails() throws SQLException // total information
    {
        String query = "SELECT theater.theater_id, theater.name, theater.location, " +
               "show_details.show_id, show_details.show_time, " +
               "Movie.id, Movie.name, Movie.genre, Movie.language, show_details.cost " +
               "FROM theater " +
               "JOIN show_details ON theater.show_id = show_details.show_id " +
               "JOIN Movie ON show_details.movie_id = Movie.id";


        Connection connection=databaseconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            
            System.out.println("theater id :"+rs.getInt(1)+" "+"theater name :"+rs.getString(2)+" "+"theater location :"+rs.getString(3)+" "+"show id :"+rs.getInt(4)
            +" "+"show time :"+rs.getString(5)+" "+"movie id :"+rs.getInt(6)+" "+"movie name :"+rs.getString(7)+" "+"movie genre :"+rs.getString(8)+" "+"movie language :"+rs.getString(9)
            +" "+"show cost:"+rs.getInt(10));
          
        }
        connection.close();
    }

    

   
}
