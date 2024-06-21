package com.theater;

import java.util.ArrayList;
import java.util.List;

import com.movie.Movie;
import com.show.Show;

public class Theater {


    /*public static List<Theater> t=new ArrayList<>();

    public static void addtheater(Theater theater)
    {
        int theaterid=t.size()+1;
        theater.setTheater_id(theaterid);
        t.add(theater);
    }

    public static Theater getTheater(int theater_id)
    {
        for(Theater x:t)
        {
            if(x.getTheater_id()==theater_id)
            {
                return x;
            }
        }
        return null;
    }

    public static void deletetheater(int theater_id)
    {
        for(Theater x:t)
        {
            if(x.getTheater_id()==theater_id)
            {
                t.remove(x);
                break;
            }
        }
    }

    public static void printtheater()
    {
        for(Theater x:t)
        {
            x.display();
        }
    }*/







    

    int theater_id;
    String theater_name;
    String theater_location;
    Show show;
    Movie movie;
    public Theater(int theater_id, String theater_name, String theater_location, Show show,Movie movie) {
        this.theater_id = theater_id;
        this.theater_name = theater_name;
        this.theater_location = theater_location;
        this.show = show;
        this.movie=movie;
    }
    public int getTheater_id() {
        return theater_id;
    }
    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }
    public String getTheater_name() {
        return theater_name;
    }
    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }
    public String getTheater_location() {
        return theater_location;
    }
    public void setTheater_location(String theater_location) {
        this.theater_location = theater_location;
    }
    public Show getShow() {
        return show;
    }
    public void setShow(Show show) {
        this.show = show;
    }
    public Movie getMovie()
    {
        return movie;
    }
    public void setMovie(Movie movie)
    {
        this.movie=movie;
    }


    public void display()
    {
        System.out.println("Theater Id:"+theater_id);
        System.out.println("Theater Name:"+theater_name);
        System.out.println("Theater Location:"+theater_location);
        System.out.println("Show id:"+show.getShowid());
        System.out.println("Show Time:"+show.getTime());
        System.out.println("Show Type:"+show.getType());
        System.out.println("Movie Id:"+movie.getMovie_id());
        System.out.println("Movie Name:"+movie.getMovie_name());
        System.out.println("Movie Genre:"+movie.getMovie_genre());
        System.out.println("Movie Language:"+movie.getMovie_lang());
        System.out.println("Show Cost:"+show.getCost());

    }
    
}
