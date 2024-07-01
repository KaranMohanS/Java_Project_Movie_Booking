package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class userjdbcservice {


    public static void adduser() throws SQLException   // add
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
        System.out.print("Enter email: ");
        String email=scanner.nextLine();
        System.out.print("Enter password: ");
        String pass=scanner.nextLine();
        scanner.close();

        String query="insert into user values(?,?,?,?)";
        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement p=connection.prepareStatement(query);

        p.setInt(1, id);
        p.setString(2, name);
        p.setString(3, email);
        p.setString(4, pass);

        int row=p.executeUpdate();

        System.out.println("number of row affected :"+row);

    }


    public static void deleteUser() throws SQLException     // delete user
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        
        Scanner scanner=new Scanner(System.in);
        long id =scanner.nextInt();
        scanner.close();
        Scanner scanner1=new Scanner(System.in);
        System.out.println("enter delete query");
        String query=scanner.nextLine();
        Connection connection=DriverManager.getConnection(path, username, password);
        PreparedStatement p=connection.prepareStatement(query);

        long  row=p.executeLargeUpdate();

        System.out.println("number of row affected :"+row);
        connection.close();
    }

    public static void updateuser() throws SQLException   // update
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

    public static void getuser() throws SQLException
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter getuser query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=DriverManager.getConnection(path, username, password);
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            
            System.out.println("id :"+rs.getInt(1)+" "+"name :"+rs.getString(2)+" "+"email :"+rs.getString(3)+" "+"password :"+rs.getString(4));
        }
        
    }

    public static void printusers()        // print
    {
        String path="jdbc:mysql://localhost:3306/movie";
        String username="root";
        String password="1234";
    try{
        Connection condition=DriverManager.getConnection(path, username, password);
        java.sql.Statement st= condition.createStatement();

        String query="select * from user";
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println("id :"+rs.getInt(1)+" "+"name :"+rs.getString(2)+" "+"email :"+rs.getString(3)+" "+"password :"+rs.getString(4));
        }
        condition.close();
        rs.close();
        st.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
    
}
