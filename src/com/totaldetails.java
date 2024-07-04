package com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.movie.Moviejdbcservice;
import com.show.showjdbcservice;

public class totaldetails {

   /*  public static void total()
    {
    String query="SELECT b.book_id,b.no_seat,b.seat_type,b.payment_method,b.payment_status,b.screen_no,b.book_date, "+
                   "t.theater_id, t.name AS theater_name, t.location, " +
                   "s.show_id, s.show_time, " +
                   "m.id AS movie_id, m.name AS movie_name, m.genre, m.language, " +
                   "u.id AS user_id, u.name AS user_name, u.email, " +
                   "s.cost " +
                   "FROM booking b " +
                   "JOIN theater t ON b.theater_id=t.theater_id "+
                   "JOIN show_details s ON t.show_id = s.show_id " +
                   "JOIN Movie m ON s.movie_id = m.id " +
                   "JOIN user u ON m.user_id = u.id";
    
    try{
    Connection connection=databaseconnection.getConnection();
    PreparedStatement p=connection.prepareStatement(query);
    ResultSet rs=p.executeQuery();
    
    while (rs.next()) {

            int bookid=rs.getInt("book_id");
            int seat=rs.getInt("no_seat");
            String seattype=rs.getString("seat_type");
            String payment=rs.getString("payment_method");
            String paymentstatus=rs.getString("payment_status");
            int screen=rs.getInt("screen_no");
            String bookdate=rs.getString("book_date");
            int theaterId = rs.getInt("theater_id");
            String theaterName = rs.getString("theater_name");
            String location = rs.getString("location");
            int showId = rs.getInt("show_id");
            String showTime = rs.getString("show_time");
            int movieId = rs.getInt("movie_id");
            String movieName = rs.getString("movie_name");
            String genre = rs.getString("genre");
            String language = rs.getString("language");
            int userId = rs.getInt("user_id");
            String userName = rs.getString("user_name");
            String email = rs.getString("email");
            int cost = rs.getInt("cost");
            
            System.out.println("Booking Id: "+bookid);
            System.out.println("Number of Seats: "+seat);
            System.out.println("Seat type: "+seattype);
            System.out.println("Payment Method: "+payment);
            System.out.println("Payment Status: "+paymentstatus);
            System.out.println("Screen Number: "+screen);
            System.out.println("Booking Date: "+bookdate);
            System.out.println("Theater ID: " + theaterId);
            System.out.println("Theater Name: " + theaterName);
            System.out.println("Location: " + location);
            System.out.println("Show ID: " + showId);
            System.out.println("Show Time: " + showTime);
            System.out.println("Movie ID: " + movieId);
            System.out.println("Movie Name: " + movieName);
            System.out.println("Genre: " + genre);
            System.out.println("Language: " + language);
            System.out.println("User ID: " + userId);
            System.out.println("User Name: " + userName);
            System.out.println("User Email: " + email);
            System.out.println("Cost: " + cost);
            System.out.println("--------------------");
    }
    
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }*/

    

     public static boolean userlogin() throws SQLException       // login
    {
        //Scanner scanner=new Scanner(System.in);
        System.out.println("enter user name");
        String name=App.scanner.nextLine();
        System.out.println("enter password");
        String password=App.scanner.nextLine();
        String query="Select name,password from user where name=? and password=?";
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        p.setString(1, name);
        p.setString(2, password);
        ResultSet rs=p.executeQuery();
        boolean login=false;
        
        while (rs.next()) {
            
            login=true;
        }
        connection.close();
       return login;
       
    }

    public static void theaterdetails() throws SQLException      //theater details
    {
        String query="select theater_id,name,location from theater";
        Connection connection=databaseconnection.getConnection();
        java.sql.Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.println("Theater Id: "+rs.getInt(1)+"\n"+"Theater Name: "+rs.getString(2)+"\n"+"Theater Location: "+rs.getString(3));
            System.out.println("-----------------------");
        }
        connection.close();

    }


    public static void theaterandmoviedetails() throws SQLException    // show and movie and theater
    {
        String query="SELECT t.name AS theater_name, t.location, " +
                     "m.id AS movie_id, m.name AS movie_name,m.genre,m.language,m.date, " +
                     "s.show_id, s.show_time,s.fill_seat,s.free_seats " +
                     "FROM theater AS t " +
                     "JOIN Movie AS m ON m.theater_id = t.theater_id " +
                     "JOIN show_details AS s ON s.movie_id = m.id " +
                     "WHERE t.name = ?";
        
        //Scanner scanner=new Scanner(System.in);
        System.out.println("enter theater name");
        String theatername=App.scanner.nextLine();
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        p.setString(1, theatername);

        ResultSet rs=p.executeQuery();
        while (rs.next()) {
            
            String output="Theater Name: "+rs.getString(1)+"\n"+"Theater Location: "+rs.getString(2)
            +"\n"+"Movie Id: "+rs.getInt(3)+"\n"+"Movie Name: "+rs.getString(4)+"\n"+"Movie Genre: "+rs.getString(5)+"\n"+"Movie Language: "+rs.getString(6)+"\n"+"Movie Date: "+rs.getString(7)+"\n"
            +"Show Id: "+rs.getInt(8)+"\n"+"Show Time: "+rs.getString(9)+"\n"+"Fillead Seats: "+rs.getInt(10)+"\n"+"Free Seats: "+rs.getInt(11);
            System.out.println("---------------------------------------------------------");
            System.out.println(output);
            
        }
        connection.close();
        
    }


    public static void availablelist() throws SQLException      // available
    {
        String query="select m.id,m.name,m.genre,m.language,m.date, "+
        "s.show_id,s.show_time,s.fill_seat,s.free_seats,s.cost, "+
        "t.theater_id,t.name,t.location "+
        "from Movie as m "+
        "join show_details as s on s.movie_id=m.id "+
        "join theater as t on t.theater_id=m.theater_id ";
       

        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        
        ResultSet rs=p.executeQuery();

        while (rs.next()) {
            
            System.out.println("Movie Id | Movie Name | Movie Genre | Movie Language | Movie date | Show Id  | Show Time  | Filled Seats | Free Seats | Show Cost | Theater Id | Theater Name | Theater Location");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getDate(5)+
            " | "+rs.getInt(6)+" | "+rs.getString(7)+" | "+rs.getInt(8)+" | "+rs.getInt(9)+" | "+rs.getInt(10)+
            " | "+rs.getInt(11)+" | "+rs.getString(12)+" | "+rs.getString(13));
        }
        connection.close();
    }


    public static void booking() throws SQLException   // booking
    {
        System.out.println("enter user id");
        int id=App.scanner.nextInt();
        App.scanner.nextLine();

        System.out.println("enter user name");
        String name=App.scanner.nextLine();

        System.out.println("enter theater id");
        int theater_id=App.scanner.nextInt();
       
        System.out.println("enter movie id");
        int movie_id=App.scanner.nextInt();
        App.scanner.nextLine();

        System.out.println("enter movie name");
        String movie_name=App.scanner.nextLine();

        System.out.println("enter movie date");
        String movie_date=App.scanner.nextLine();

        System.out.println("enter show id");
        int show_id=App.scanner.nextInt();
        App.scanner.nextLine();

        System.out.println("enter show time");
        String show_time=App.scanner.nextLine();

        data(theater_id, movie_id, movie_name, movie_date, show_id, show_time); // data validation

        System.out.println("enter how many seats");
        int seats=App.scanner.nextInt();
        App.scanner.nextLine();
        
        int Amount=Amount(show_id);     // amount 
        int totalamount=seats*Amount;
        System.out.println("Payment amount is: "+totalamount);


        String paymentmessage=payment();     //payment
        
        if(paymentmessage.equals("payment successful"))
        {
            bookingconfirmation(id,name,theater_id,movie_id,movie_name,movie_date,show_id,show_time,seats,totalamount);  //booking confirmation
        }
        else
        {
            System.out.println("Payment is Fail. Booking Not Confirm");
        }

    } 


    public static String payment()  // payment
    {
       String message="";
       System.out.println("Payment Available Methods : Gpay , Paytm , Banktransfer");
       System.out.println("enter payment method");
       String method=App.scanner.nextLine();
       switch (method) {
        case "gpay":
            message="payment successful";
            break;
        case "paytm":
             //System.out.println("Payment Successful");
             message="payment successful";
             break;
        case "banktransfer":
            // System.out.println("Payment Successful");
            message="payment successful";
             break;
        default:
             System.out.println("Invalied Payment Method: "+method);
            break;
       }
       return message;
    }
    
    public static void bookingconfirmation(int id,String name,int theater_id,int movie_id,String movie_name,String movie_date,int show_id,String show_time,int seats,int totalamount) throws SQLException
    {

      String qurey="insert into booking(user_id,user_name,theater_id,movie_id,movie_name,movie_date,show_id,show_time,no_seats,payed_amount) values (?,?,?,?,?,?,?,?,?,?)";

      Connection connection=databaseconnection.getConnection();
      PreparedStatement p=connection.prepareStatement(qurey);
      p.setInt(1, id);
      p.setString(2, name);
      p.setInt(3, theater_id);
      p.setInt(4, movie_id);
      p.setString(5, movie_name);
      p.setString(6, movie_date);
      p.setInt(7, show_id);
      p.setString(8, show_time);
      p.setInt(9, seats);
      p.setInt(10, totalamount);

      int row=p.executeUpdate();

      if(row>0)
      {
        System.out.println("--------------------------");
        System.out.println("Booking confirmed!");
        System.out.println("User: " + name);
        System.out.println("Theater ID: " + theater_id);
        System.out.println("Movie: " + movie_name);
        System.out.println("Date: " + movie_date);
        System.out.println("Show Time: " + show_time);
        System.out.println("Seats Booked: " + seats);
        System.out.println("--------------------------");
      }
      else
      {
        System.out.println("Booking Failed. Please Try Again Later");
      }

      connection.close();
    }

    

    public static int Amount(int show_id) throws SQLException    // amount calculation 
    {   
        int Amount=0;
        String query1="select cost from show_details where show_id=?";
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query1);
        p.setInt(1, show_id);
        ResultSet rs=p.executeQuery();
        while (rs.next()) {
             Amount=rs.getInt("cost");
            
        }
        connection.close();
        return Amount;
    }

    public static void data(int theater_id,int movie_id,String movie_name,String movie_date,int show_id,String show_time) throws SQLException  // data validation
    {
        String query="select t.theater_id, "+
        "m.id,m.name,m.date, "+
        "s.show_id,s.show_time "+
        "from theater as t "+
        "join Movie as m on t.theater_id=m.theater_id "+
        "join show_details as s on m.id=s.movie_id "+
        "where t.theater_id=? and m.id=? and m.name=? and m.date=? and s.show_id=? and s.show_time=? ";

        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        boolean bookingdetails=false;
        p.setInt(1, theater_id);
        p.setInt(2, movie_id);
        p.setString(3, movie_name);
        p.setString(4, movie_date);
        p.setInt(5, show_id);
        p.setString(6, show_time);

        ResultSet rs=p.executeQuery();

        while (rs.next()) {
            
              bookingdetails=true;
        }
        if(!bookingdetails)
        {
            System.out.println("--------------------------------------");
            System.out.println("Wrong Details. Please Start From First");
            System.out.println("--------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println("enter goback options: booking , useroperation");
            System.out.println("----------------------------------------------");
            String goback=App.scanner.nextLine();
            if(goback.equals("booking"))
            {
            booking();
            }
            else if(goback.equals("useroperation"))
            {
               App.handleuseroperation();

            }
            else
            {
                System.out.println("enter valied gobackmethod: "+goback);
            }
        }
        connection.close();
    }


    public static void viewbookedshow() throws SQLException   //view booked shows
    {
        System.out.println("enter user id");
        int user_id=App.scanner.nextInt();
        String query="select * from booking where user_id=?";

        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        p.setInt(1, user_id);
        ResultSet rs=p.executeQuery();

        while (rs.next()) {
            System.out.println("Booking id: "+rs.getInt(1)+" | "+"user id: "+rs.getInt(2)+" | "+"user name: "+rs.getString(3)+" | "+"theater id: "+rs.getInt(4)+" | "+
            "movie id: "+rs.getInt(5)+" | "+"movie name: "+rs.getString(6)+" | "+"movie date: "+rs.getString(7)+" | "+"show id: "+rs.getInt(8)+" | "+"show time: "+rs.getString(9)
            +" | "+"number of seats: "+rs.getInt(10));
        }
        connection.close();
    }

    public static void cancel() throws SQLException  // ticket cancel
    {
        System.out.println("enter booking id");
        int book_id=App.scanner.nextInt();
        String query="delete from booking where booking_id=?";
        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        p.setInt(1, book_id);
        int row=p.executeUpdate();

        if(row>0)
        {
            System.out.println("Booking canceled");
        }
        else
        {
            System.out.println("Booking id is wrong");
        }
       connection.close();
    }

    public static void changepass() throws SQLException  // change password
    {
        System.out.println("enter new password");
        int pass=App.scanner.nextInt();
        System.out.println("enter user id");
        int id=App.scanner.nextInt();

        String query="update user set password=? where id=?";

        Connection connection=databaseconnection.getConnection();
        PreparedStatement p=connection.prepareStatement(query);
        p.setInt(1, pass);
        p.setInt(2, id);
        int row=p.executeUpdate();

        if(row>0)
        {
            System.out.println("Password Successfully Changed");
        }
        else{
            System.out.println("User id is Wrong");
        }
        connection.close();
    }
}

