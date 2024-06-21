package com.theater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.movie.Movie;
import com.show.Show;

public class Theaterservice {

    public static String theaterpath="theater.txt";

    public static void addtheater(Theater theater) throws IOException   // add
    {
        File file=new File(theaterpath);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter=new FileWriter(theaterpath,true);

        Show show=theater.getShow();
        Movie movie=theater.getMovie();
        fileWriter.write(theater.getTheater_id()+","+theater.getTheater_name()+","+theater.getTheater_location()+","+show.getShowid()+","+show.getTime()+","+show.getType()+","+
             movie.getMovie_id()+","+movie.getMovie_name()+","+movie.getMovie_genre()+","+movie.getMovie_lang()+","+show.getCost()+"\n");
        fileWriter.close();
    }

    public static Theater getTheater(int theater_id) throws IOException  // get
    {
        File file=new File(theaterpath);

        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        Theater theater=null;
        String line;
        while ((line=bufferedReader.readLine())!=null) {
            String[] arr=line.split(",");
            if(Integer.parseInt(arr[0])==theater_id)
            {
               
                long movieId = Long.parseLong(arr[6]);  // movie_id
                String movieName = arr[7];              // movie_name
                String movieGenre = arr[8];             // movie_genre
                String movieLang = arr[9];              // movie_lang
                int showCost = Integer.parseInt(arr[10]); // show_cost
                Movie movie = new Movie(movieId, movieName, movieGenre, movieLang);
                long showId = Long.parseLong(arr[3]);   // show_id
                String showTime = arr[4];               // show_time
                String showType = arr[5];               // show_type
                Show show = new Show(showId, showTime, showType, movie, showCost);
                theater = new Theater(Integer.parseInt(arr[0]), arr[1], arr[2], show,movie);  
              
            }
            
        }
        bufferedReader.close();
        return theater;

        
    }


    public static void deletetheater(int theater_id) throws IOException  /// delete
    {
        File file=new File(theaterpath);
        File filetemp=new File("theater_temp.txt");

        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filetemp));

        String line;
        Boolean theaterfound=false;

        while ((line=bufferedReader.readLine())!=null) {

            String[] arr=line.split(",");
            if(Integer.parseInt(arr[0])==theater_id)
            {
                theaterfound=true;
                continue;
            }
            bufferedWriter.write(line+System.lineSeparator());
        }

        if(!file.delete())
        {
            throw new IOException("Failed to delete the original file");
        }
        if (!filetemp.renameTo(file)) {
            throw new IOException("Failed to rename the temp file to original file name");
        }  
    }


    public static Theater modify(int theater_id,String modifyfield,String value) throws Exception
    {
        File file=new File(theaterpath);
        File filetemp=new File("modify.txt");

        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filetemp)))
            {
                String line;
                Theater theater=null;

                while ((line=bufferedReader.readLine())!=null) {

                    String arr[]=line.split(",");
                    if(Integer.parseInt(arr[0])==theater_id)
                    {
                        switch (modifyfield) {
                            case "name":
                                arr[1]=value;
                                break;
                            case "location":
                                arr[2]=value;
                                break;
                        
                            default:
                                throw new Exception("Invalied ModifyField"+modifyfield);
                        }
                        Movie movie =new Movie(Long.parseLong(arr[6]), arr[7], arr[8], arr[9]);
                        Show show=new Show(Long.parseLong(arr[3]), arr[4], arr[5], movie,Integer.parseInt(arr[10]));
                        theater=new Theater(Integer.parseInt(arr[0]),arr[1],arr[2],show,movie);
                    }
                    bufferedWriter.write(String.join(",", arr)+System.lineSeparator());
                    
                }
                if(!file.delete())
                {
                    throw new IOException("Failed to delete the original file");
                }
                if(!filetemp.renameTo(file))
                {
                    throw new IOException("Failed to rename the temp file to original file name");
                }
                return theater;
            }
    }

    public static void printtheater() throws IOException  // print
    {
        File file=new File(theaterpath);

        FileReader fileReader=new FileReader(file);

        int line;
        while ((line=fileReader.read())!=-1) {

            System.out.print((char)line);
        }
        fileReader.close();
    }
    
}
