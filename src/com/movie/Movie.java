package com.movie;



public class Movie {

    /*public static List<Movie> m=new ArrayList<>();
    public static long addUser(Movie movie)
    {
        long movie_id=m.size()+1;
        movie.setMovie_id(movie_id);
        m.add(movie);
        return movie_id;
    }

    public static Movie getMovie(long movie_id)
    {
        for(Movie x:m)
        {
            if(x.getMovie_id()==movie_id)
            {
                return x;
            }
        }
        return null;
    }
   

    public static void deletemovie(long movie_id)
    {
        Movie toremove=null;
        for(Movie x:m)
        {
            if(x.getMovie_id()==movie_id)
            {
                 toremove=x;
                 break;
            }
        }
        if(toremove!=null)
        {
            m.remove(toremove);
        }
    }
    
    public static Movie modify(long movie_id,String modifyfeild,String value)
    {
        for(Movie x:m)
        {
            if(x.getMovie_id()==movie_id)
            {
                switch (modifyfeild) {
                    case "name":
                           x.setMovie_name(value);
                        break;
                    case "genre":
                           x.setMovie_genre(value);
                           break;
                    case "lang":
                           x.setMovie_lang(value);
                           break;
                    default:
                    throw new IllegalArgumentException("Unknown field: " + modifyfeild);
                }   
            }
           return x;
        }
        return null;
    }

    public static void printUsers()
    {
        for(Movie x:m)
        {
            x.display();
        }
    }*/


    
    long movie_id;
    String movie_name;
    String movie_genre;
    String movie_lang;

   //String modifyfeild;

    
   
    public Movie(long movie_id, String movie_name, String movie_genre, String movie_lang) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_genre = movie_genre;
        this.movie_lang = movie_lang;
    }
    
    public void display()
    {
        System.out.println("Movie_ID: " + movie_id);
        System.out.println("Movie_Name: " + movie_name);
        System.out.println("Movie genre: " + movie_genre);
        System.out.println("Movie lang: " + movie_lang);
    }

    

    public long getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }
    public String getMovie_name() {
        return movie_name;
    }
    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }
    public String getMovie_genre() {
        return movie_genre;
    }
    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }
    public String getMovie_lang() {
        return movie_lang;
    }
    public void setMovie_lang(String movie_lang) {
        this.movie_lang = movie_lang;
    }
    
   
    
}
