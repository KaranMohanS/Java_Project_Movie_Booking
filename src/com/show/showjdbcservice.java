package com.show;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class showjdbcservice {

   
    public static void addshow() throws SQLException  // add show
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter show id");
        int show_id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter time");
        String time=scanner.nextLine();
        System.out.println("enter movie id ");
        int id=scanner.nextInt();
        System.out.println("enter cost");
        int cost=scanner.nextInt();

        String query="insert into show_details values(?,?,?,?)";
        scanner.close();
        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement p=connection.prepareStatement(query);

        p.setInt(1, show_id);
        p.setString(2, time);
        p.setInt(3, id);
        p.setInt(4, cost);

        int row=p.executeUpdate();
        System.out.println("number of row affected"+row);

    }


    public static void getshow() throws SQLException    // get
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter get query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=DriverManager.getConnection(path, username, password);
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

        System.out.println("nuber of row affected :"+row);
        connection.close();
        ps.close();
    }


    public static void deleteshow() throws Exception
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter delete query");
        String query=scanner.nextLine();
        scanner.close();


        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement ps=connection.prepareStatement(query);
        int row=ps.executeUpdate();
        System.out.println("number of row affected:"+row);
        connection.close();
        ps.close();
    }


    public static void printshow() throws SQLException      // print show
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";

        String query="select * from show_details";

        Connection connection=DriverManager.getConnection(path, username, password);
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);
        while (rs.next()) {
            System.out.println("show id :"+rs.getInt(1)+" "+"time :"+rs.getString(2)+" "+"movie id :"+rs.getInt(3)+" "+"cost :"+rs.getInt(4));
        }
        connection.close();
        st.close();
        rs.close();

    }
    
}
