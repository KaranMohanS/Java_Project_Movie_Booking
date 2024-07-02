package com.booking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

import com.movie.Movie;
import com.show.Show;
import com.theater.Theater;
import com.user.User;

public class Bookingservice {
    
    public static String path="booking.txt";

    public static void addbooking(Booking booking) throws IOException
    {
        File file=new File(path);
        FileWriter fw=new FileWriter(file,true);
        
        User user=booking.getUser();
        Movie movie=booking.getMovie();
        Show show=booking.getShow();
        Theater theater=booking.getTheater();
        fw.write(booking.getId()+","+user.getId()+","+user.getName()+","+user.getEmail()+","+movie.getMovie_id()+","+movie.getMovie_name()+","+movie.getMovie_genre()
        +","+movie.getMovie_lang()+","+show.getShowid()+","+show.getTime()+","+show.getCost()+","+theater.getTheater_id()+","+theater.getTheater_name()+","+theater.getTheater_location()+"\n");
        
        fw.close();

    }


    public static void printbooking() throws IOException   // print
    {
        File file=new File(path);
        FileReader fw=new FileReader(file);
        BufferedReader bf=new BufferedReader(fw);

        String line;
        while ((line=bf.readLine())!=null) {
           System.out.println(line);

        }
    }


    public static Booking get(int id) throws IOException
    {
        File file=new File(path);
        FileReader fw=new FileReader(file);
        BufferedReader bf=new BufferedReader(fw);

        Booking booking=null;
        String line;
        while ((line=bf.readLine())!=null) {
            String[] arr=line.split(",");
            if(Integer.parseInt(arr[0])==id)
            {
                User user=new User(Long.parseLong(arr[1]), arr[2], arr[3], arr[4]);
               booking=new Booking(Integer.parseInt(arr[0]), user, null, null, null);
            }
        }
    }
}
