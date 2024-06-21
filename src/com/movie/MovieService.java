package com.movie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MovieService {
    
    static String filepath="movie.txt";                      /// addmovie
    public static void addmovie(Movie movie) throws IOException
    {
        File file=new File(filepath);
        FileWriter filewWriter=new FileWriter(file,true);

        filewWriter.write(movie.getMovie_id()+","+movie.getMovie_name()+","+movie.getMovie_genre()+","+movie.getMovie_lang()+"\n");
       // filewWriter.flush();
        filewWriter.close();
        //return movie.getMovie_id();
    }
    

    public static Movie getmovie(long movie_id) throws NumberFormatException, IOException
    {
        File file=new File(filepath);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        
        Movie movie=null;
        String line;

        while ((line=bufferedReader.readLine())!=null) {
            String[] arr=line.split(",");
            if(Long.parseLong(arr[0])==movie_id)
            {
                movie=new Movie(Long.parseLong(arr[0]),arr[1],arr[2],arr[3]); 
                break;
            }   
        }
        return movie;
    }

    public static Movie modify(long movie_id,String modifyfeild,String modifyfeildvalue) throws Exception
    {
        File file=new File(filepath);
        File filetemp= new File("modify.txt");

        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filetemp)))
        {
        Movie modifymovie=null;
        String line;
        while ((line=bufferedReader.readLine())!=null) {

            String[] arr=line.split(",");
            if(Long.parseLong(arr[0])==movie_id)
            {
                switch (modifyfeild) {
                    case "name":
                        arr[1] = modifyfeildvalue;
                        break;
                    case "genre":
                        arr[2] = modifyfeildvalue;
                        break;
                    case "lang":
                        arr[3] = modifyfeildvalue;
                        break;
                    default:
                        throw new Exception("Invalid field: " + modifyfeild);
                }
                modifymovie=new Movie(Long.parseLong(arr[0]), arr[1], arr[2], arr[3]);
            }
            bufferedWriter.write(String.join(",", arr)+System.lineSeparator());
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete the original file");
        }
        if (!filetemp.renameTo(file)) {
            throw new IOException("Failed to rename the temp file to original file name");
        }
        return modifymovie;
        
    }
    }


                                                               // delete movie
    public static boolean deletMovie(long movie_id) throws IOException
    {
        File file=new File(filepath);
        File filetemp=new File("movie_temp.txt");
        
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filetemp));

        boolean moviefound=false;
        String line;

        while((line=bufferedReader.readLine())!=null)
        {
            String[] arr=line.split(",");
            if(Long.parseLong(arr[0])==movie_id)
            {
                  moviefound=true;
                  continue;
            }
            bufferedWriter.write(line+System.lineSeparator());
        }
        bufferedReader.close();
        bufferedWriter.close();
        if(!file.delete())
        {
            throw new IOException("Failed to delete the original file");
        }
        if (!filetemp.renameTo(file)) {
            throw new IOException("Failed to rename the temp file to original file name");
        }
       return moviefound;
    }

    public static void printmovie() throws IOException
    {
        File file=new File(filepath);
        FileReader fileReader=new FileReader(file);
        int line;
        while((line=fileReader.read())!=-1)
        {
            System.out.print((char) line);
        }
        fileReader.close();
    }
}
