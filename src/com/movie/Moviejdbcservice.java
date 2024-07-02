package com.movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.databaseconnection;


public class Moviejdbcservice {
    

    public static void printmovie() throws SQLException       // print 
    {
        String query="select * from Movie";
    try{
        Connection connection=databaseconnection.getConnection();
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
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter name: ");
        String name=scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre=scanner.nextLine();
        System.out.print("Enter language: ");
        String lang=scanner.nextLine();
        scanner.close();

        String query="insert into Movie(name,genre,language) values(?,?,?)";
  
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        
        p.setString(1, name);
        p.setString(2, genre);
        p.setString(3, lang);
        int row=p.executeUpdate();
        System.out.println("number of row aggected :"+row);
        connection.close();
        }


        public static void getmovie() throws SQLException    // get movie
        {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter get query");
        String query=scanner.nextLine();
        scanner.close();
        
        try{
        Connection connection=databaseconnection.getConnection();
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


    public static void deletemovie() throws SQLException  // delete
    {
        Scanner scanner=new Scanner(System.in);  
        System.out.println("enter delete query");
        String query=scanner.nextLine();
        scanner.close();

        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        int row=p.executeUpdate();
        System.out.println("number of row affected :"+row);
    }

    
    public static void totalmovie() throws SQLException   // total
    {
        String query="select m.id,m.name,m.genre,m.language, "+
        "u.id,u.name,u.email "+
        "from Movie as m "+
        "left join user as u on m.user_id=u.id";
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        ResultSet rs=p.executeQuery();

        while (rs.next()) {
            System.out.println("movie id :"+rs.getInt(1)+" "+"movie name :"+rs.getString(2)+" "+"movie genre :"+rs.getString(3)+" "
            +"movie language :"+rs.getString(4)+" "+"user id :"+rs.getInt(5)+" "+"user name :"+rs.getString(6)+" "+"user email :"+rs.getString(7));
        }
        rs.close();
    }
}
