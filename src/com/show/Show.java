package com.show;

//import java.util.ArrayList;
//import java.util.List;

import com.movie.Movie;

public class Show {

   /*  static List<Show> s=new ArrayList<>();

    public static void addUser(Show show)
    {
        long show_id=s.size()+1;
        show.setShowid(show_id);
        s.add(show);
    }


    public static Show getshow(long showid)
    {
        for(Show x:s)
        {
            if(x.getShowid()==showid)
            {
                return x;
            }
        }
        return null;
    }

    public static void deleteshow(long show_id)
    {
        
        for(Show x:s)
        {
            if(x.getShowid()==show_id)
            {
                s.remove(x);
                break;
            }
        }
       // return null;
    }

    public static void printshow()
    {
        for(Show x:s)
        {
           x.display();
        }
    }*/


    
    long showid;
    String time;
    String type;
    Movie movie;
    int cost;

    public Show(long showid, String time, String type, Movie movie, int cost) {
        this.showid = showid;
        this.time = time;
        this.type = type;
        this.movie = movie;
        this.cost = cost;
    }
    

    public void display()
    {
        System.out.println("Show ID: " + showid);
        System.out.println("Show Time: " + time);
        System.out.println("Show Type: " + type);
        System.out.println("Movie Id: " + movie.getMovie_id());
        System.out.println("Movie Name:"+movie.getMovie_name());
        System.out.println("Movie Genre:"+movie.getMovie_genre());
        System.out.println("Movie Language:"+movie.getMovie_lang());
        System.out.println("Show Cost:"+cost);
    }

    public long getShowid() {
        return showid;
    }

    public void setShowid(long showid) {
        this.showid = showid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }



}