package com.show;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.databaseconnection;

public class showjdbcservice {

   
    public static void addshow() throws SQLException  // add show
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter time");
        String time=scanner.nextLine();
        System.out.println("enter movie id ");
        int id=scanner.nextInt();
        System.out.println("enter cost");
        int cost=scanner.nextInt();

        String query="insert into show_details(show_time,movie_id,cost) values(?,?,?)";
        scanner.close();
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);

        p.setString(1, time);
        p.setInt(2, id);
        p.setInt(3, cost);

        int row=p.executeUpdate();
        System.out.println("number of row affected"+row);

    }


    public static void getshow() throws SQLException    // get
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter get query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);
        while (rs.next()) {
            System.out.println("show id :"+rs.getInt(1)+" "+"time :"+rs.getString(2)+" "+"movie id :"+rs.getInt(3)+" "+"cost :"+rs.getInt(4)); 
        }
        connection.close();
        rs.close();
        st.close();

        }

    public static void updateshow() throws SQLException    // update 
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement(query);
        int row=ps.executeUpdate();

        System.out.println("nuber of row affected :"+row);
        connection.close();
        ps.close();
    }


    public static void deleteshow() throws Exception
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter delete query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        PreparedStatement ps=connection.prepareStatement(query);
        int row=ps.executeUpdate();
        System.out.println("number of row affected:"+row);
        connection.close();
        ps.close();
    }


    public static void printshow() throws SQLException      // print show
    {
        String query="select show_details.show_id,show_details.show_time,Movie.id,Movie.name,show_details.cost from show_details join Movie on show_details.movie_id=Movie.id";

        Connection connection=databaseconnection.getConnection();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);
        while (rs.next()) {
            System.out.println("show id :"+rs.getInt(1)+" "+"time :"+rs.getString(2)+" "+"movie id :"+rs.getInt(3)+" "+"cost :"+rs.getInt(5));
        }
        connection.close();
        st.close();
        rs.close();

    }


    public static void totaldetails() throws SQLException        // total
    {
        String query="select s.show_id, s.show_time, " +"m.id,m.name,m.genre,m.language,s.cost " +
        "from show_details as s "+
        "join Movie as m on s.movie_id=m.id ";

        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        ResultSet rs=p.executeQuery();
        while (rs.next()) {
            System.out.println("show id :"+rs.getInt(1)+" "+"time :"+rs.getString(2)+" "+"movie id :"+rs.getInt(3)+" "+"movie name :"+rs.getString(4)
            +" "+"movie genre :"+rs.getString(5)+" "+"movie language :"+rs.getString(6)+" "+"cost :"+rs.getInt(7));
          
        }
        connection.close();
    }
    
}
