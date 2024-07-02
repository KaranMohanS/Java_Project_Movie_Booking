package com.booking;

import java.sql.Connection;
import java.sql.Date;
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
        System.out.println("enter number of seats");
        int no_seats=scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter seat type");
        String seat_type=scanner.nextLine();
        System.out.println("enter payment method");
        String payment_method=scanner.nextLine();
        System.out.println("enter payment status");
        String payment_status=scanner.nextLine();
        System.out.println("enter screen number");
        int screen_id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter date");
        String date=scanner.nextLine();
        System.out.println("enter theater id");
        int id=scanner.nextInt();
        scanner.close();
        Date sqlDate = Date.valueOf(date);
        String query="insert into booking(no_seat,seat_type,payment_method,payment_status,screen_no,book_date,theater_id) values(?,?,?,?,?,?,?)";
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        

       p.setInt(1, no_seats);
       p.setString(2, seat_type);
       p.setString(3, payment_method);
       p.setString(4, payment_status);
       p.setInt(5, screen_id);
       p.setDate(6, sqlDate);
       p.setInt(7, id);
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
            System.out.println("booking id :"+rs.getInt(1)+" "+"number of seats :"+rs.getInt(2)+" "+"seat type :"+rs.getString(3)+" "+"payment method :"+rs.getString(4)
            +" "+"payment status :"+rs.getString(5)+" "+"screen number :"+rs.getInt(6)+" "+"booking date :"+rs.getString(7)+" "+"theater id :"+rs.getInt(8));
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
            System.out.println("booking id :"+rs.getInt(1)+" "+"number of seats :"+rs.getInt(2)+" "+"seat type :"+rs.getString(3)+" "+"payment method :"+rs.getString(4)
            +" "+"payment status :"+rs.getString(5)+" "+"screen number :"+rs.getInt(6)+" "+"booking date :"+rs.getString(7)+" "+"theater id :"+rs.getInt(8));
        } 
        
        connection.close();
    }
    
}
