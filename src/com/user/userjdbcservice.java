package com.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.databaseconnection;

public class userjdbcservice {


    public static void adduser() throws SQLException   // add
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter name: ");
        String name=scanner.nextLine();
        System.out.print("Enter email: ");
        String email=scanner.nextLine();
        System.out.print("Enter password: ");
        String pass=scanner.nextLine();
        //scanner.close();
        String query="insert into user(name,email,password) values(?,?,?)";
        
        
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        p.setString(1, name);
        p.setString(2, email);
        p.setString(3, pass);

        int row=p.executeUpdate();

        System.out.println("number of row affected :"+row);
        connection.close();

    }


    public static void deleteUser() throws SQLException     // delete user
    {   
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter delete query");
        String query=scanner.nextLine();
        scanner.close();
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);

        long  row=p.executeLargeUpdate();

        System.out.println("number of row affected :"+row);
        connection.close();
    }

    public static void updateuser() throws SQLException   // update
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter update query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);

        int row=p.executeUpdate();
        System.out.println("number of row affected :"+row);
        connection.close();

    }

    public static void getuser() throws SQLException  // get
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter getuser query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            
            System.out.println("id :"+rs.getInt(1)+" "+"name :"+rs.getString(2)+" "+"email :"+rs.getString(3)+" "+"password :"+rs.getString(4));
        }
        
    }

    public static void printusers()throws Exception        // print
    {
        
    
        Connection condition=databaseconnection.getConnection();
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


   
   
    
}
    

