package com.movie;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Moviejdbcservice {
    

    public static void printmovie() throws SQLException       // print 
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";

        String query="select * from Movie";
    try{
        Connection connection=DriverManager.getConnection(path,username,password);
        java.sql.Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {

            System.out.println("id :"+rs.getInt(1)+" "+"name :"+rs.getString(2)+" "+"genre :"+rs.getString(3)+" "+"language :"+rs.getString(4));
        }
        connection.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }


    public static void addmovie() throws SQLException    // addmovie
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter id: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name=scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre=scanner.nextLine();
        System.out.print("Enter language: ");
        String lang=scanner.nextLine();
        scanner.close();

        String query="insert into Movie values(?,?,?,?)";
  
        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement p=connection.prepareStatement(query);
        
        p.setInt(1, id);
        p.setString(2, name);
        p.setString(3, genre);
        p.setString(4, lang);
        int row=p.executeUpdate();
        System.out.println("number of row aggected :"+row);
        connection.close();
        }


        public static void getmovie() throws SQLException    // get movie
        {
            
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
       
        System.out.println("enter get query");
        String query=scanner.nextLine();
        scanner.close();
        
        try{
        Connection connection=DriverManager.getConnection(path, username, password);
        java.sql.Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);
         
        while (rs.next()) {

            System.out.println("id :"+rs.getInt(1)+" "+"name :"+rs.getString(2)+" "+"genre :"+rs.getString(3)+" "+"language :"+rs.getString(4));
        }
       }
       catch(Exception e)
       {
        e.printStackTrace();
       }
    }


    public static void updatemovie() throws SQLException //update
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
       
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement p=connection.prepareStatement(query);

        int row=p.executeUpdate();
        System.out.println("number of row affected :"+row);

        connection.close();
    }


    public static void deletemovie() throws SQLException
    {
      
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
       
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement p=connection.prepareStatement(query);
        int row=p.executeUpdate();
        System.out.println("number of row affected :"+row);
    }
}
