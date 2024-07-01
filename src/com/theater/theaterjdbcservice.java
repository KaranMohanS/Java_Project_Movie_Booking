package com.theater;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class theaterjdbcservice {
 
    
    public static void addtheater() throws SQLException     // add
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter theater id");
        int theater_id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter theater name");
        String name=scanner.nextLine();
        System.out.println("enter theater location");
        String location=scanner.nextLine();
        System.out.println("enter show id ");
        int show_id=scanner.nextInt();
        System.out.println("enter movie id");
        int movie_id=scanner.nextInt();
        scanner.close();
        String query="insert into theater values(?,?,?,?,?)";

        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement ps=connection.prepareStatement(query);
        
        ps.setInt(1,theater_id);
        ps.setString(2, name);
        ps.setString(3, location);
        ps.setInt(4, show_id);
        ps.setInt(5, movie_id);
        int row=ps.executeUpdate();
        System.out.println("number of row affected:"+row);
        connection.close();
        ps.close();
    }


    public static void updatetheater() throws SQLException   // update
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement ps=connection.prepareStatement(query);
        int row=ps.executeUpdate();
        System.out.println("number of row affected:"+row);
        connection.close();
        ps.close();
    }

    public static void gettheater() throws SQLException      //  get
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter get query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=DriverManager.getConnection(path, username, password);
        java.sql.Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println("theater id :"+rs.getInt(1)+" "+"theater name :"+rs.getString(2)+" "+"theater location :"+rs.getString(3)+" "+"show id :"+rs.getInt(4)+" "+"movie id :"+rs.getInt(5));

        }

        connection.close();
        st.close();
        rs.close();
    }


    public static void deletetheater() throws SQLException
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();
        
        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement ps=connection.prepareStatement(query);
        int row=ps.executeUpdate();
        System.out.println("number of row affected:"+row);
    }


    public static void printtheater() throws SQLException   // print
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";

        String query="select * from theater";
        Connection connection=DriverManager.getConnection(path, username, password);
        java.sql.Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println("theater id :"+rs.getInt(1)+" "+"theater name :"+rs.getString(2)+" "+"theater location :"+rs.getString(3)+" "+"show id :"+rs.getInt(4)+" "+"movie id :"+rs.getInt(5));

        }
        connection.close();
        st.close();
        rs.close();
    }
}
