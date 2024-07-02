package com.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.databaseconnection;

public class Bookingjdbcconnection {

    public static void addbook() throws SQLException   // add
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter date");
        String date=scanner.nextLine();
        System.out.println("enter theater id");
        int id=scanner.nextInt();
        scanner.close();
        String query="insert into booking(book_date,theater_id) values(?,?)";
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        

       p.setString(1, date);
       p.setInt(2, id);
       int row=p.executeUpdate();
       System.out.println("number of row affected :"+row);
       connection.close();
    }



    public static void getbook() throws SQLException   // get
    {
        Scanner scanner=new Scanner(System.in);
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        Statement st=connection.createStatement();
        System.out.println("enter get query");
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println("booking id :"+rs.getInt(1)+" "+"booking date :"+rs.getString(2)+" "+"theater id :"+rs.getInt(3));
        }
        connection.close();
    }


    public static void updatebook() throws SQLException // update
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        Statement st=connection.createStatement();
        int row=st.executeUpdate(query);
        System.out.println("number of row affected :"+row);
        connection.close();
    }

    public static void delete() throws SQLException
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        Statement st=connection.createStatement();
        int row =st.executeUpdate(query);

        System.out.println("number of row affected :"+row);
        connection.close();
    }

    public static void printbook() throws SQLException  // print
    {
        String query="select * from booking";
        Connection connection=databaseconnection.getConnection();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            
            System.out.println("booking id :"+rs.getInt(1)+" "+"booking date :"+rs.getString(2)+" "+"theater id :"+rs.getInt(3));
        }
        connection.close();
    }
    
}
