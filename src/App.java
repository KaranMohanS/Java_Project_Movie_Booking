import com.totaldetails;
import com.booking.Booking;
import com.booking.Bookingjdbcconnection;
import com.booking.Bookingservice;
import com.movie.Movie;
import com.movie.MovieService;
import com.movie.Moviejdbcservice;
import com.show.Show;
import com.show.Showservice;
import com.show.showjdbcservice;
import com.theater.Theater;
import com.theater.Theaterservice;
import com.theater.theaterjdbcservice;
import com.user.User;
import com.user.UserService;
import com.user.userjdbcservice;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Wellcome");

        // Create a new user
        User user1 = new User(1, "John Doe", "email@dsd.com" , "password");
        //User user2 = new User(2, "Karan" , "karean@fsdf", "password");
        //User user3=new User(3, "mohan", "mohan1702@gmail.com", "1234");
        System.out.println("-------------------------------------------------");
        //UserService.addUser(user1);
        //UserService.addUser(user3);
        //UserService.deleteUser(2);
        //UserService.printUsers();
        //System.out.println("-------------------------------------------------");
        //UserService.getUser(2).display();
       // UserService.modify(1, "pass", "6789").display();




        System.out.println("-------------------------------------------------");
        userjdbcservice.printusers();

        //userjdbcservice.adduser();
       // userjdbcservice.deleteUser();
        //userjdbcservice.updateuser();
       // userjdbcservice.getuser();
        //userjdbcservice.printusers();
        System.out.println("-------------------------------------------------");

       // Movie movie1=new Movie(101, "leo", "action", "tamil");           // movie
        //Movie movie2=new Movie(102,  "avengers", "action", "english");
        //\MovieService.addmovie(movie1);
        //MovieService.addmovie(movie2);
        //MovieService.printmovie();
        //MovieService.deletMovie(102);
       // MovieService.modify(102, "name", "avenger");
       // MovieService.modify(102, "lang", "english");
       // MovieService.printmovie();
       //MovieService.getmovie(102).display();
       
        
        System.out.println("-------------------------------------------------");
        //Moviejdbcservice.addmovie();
        //Moviejdbcservice.getmovie();
        //Moviejdbcservice.updatemovie();
        //Moviejdbcservice.deletemovie();
        Moviejdbcservice.printmovie();
        //Moviejdbcservice.totalmovie();
        
        System.out.println("-------------------------------------------------");

        //Show show1=new Show(1001,"10.00 AM", "action", movie1, 200);
        //Show show2=new Show(1002,"10.00 AM", "action", movie2, 300);
        //Show show3=new Show(333, "22", "comedy", movie1, 40);
        System.out.println("-------------------------------------------------");


        //Showservice.deleteshow(333);
        //Showservice.addshow(show3);
        //Showservice.addshow(show2);
        //Showservice.printshow();
        System.out.println("-------------------------------------------------");

        //Showservice.getshow(1002, 102).display();

       // Showservice.modify(1002, "cost", "350").display();

       //showjdbcservice.addshow();
       //showjdbcservice.deleteshow();
       //showjdbcservice.getshow();
       //showjdbcservice.updateshow();
       showjdbcservice.printshow();

        System.out.println("-------------------------------------------------");
       //showjdbcservice.totaldetails();
        //Show.addUser(show1);
        //Show.addUser(show2);
        //Show.printshow();
        ////Show.getshow(2).display();
        //Show.deleteshow(2);
        //Show.printshow();


        //Theater theater1=new Theater(123, "sivam", "abc street mettupalayam", show1,movie1);
        //Theater theater2=new Theater(124, "sri sakthi", "xyz street mettupalayam", show2,movie2);

        //Theater.addtheater(theater1);
        //Theater.addtheater(theater2);
        ////Theater.printtheater();
        //Theater.getTheater(2).display();
        //System.out.println("-------------------------------------------------");
        //Theater.deletetheater(2);
        //Theater.printtheater();


        //Theaterservice.addtheater(theater1);
       // Theaterservice.addtheater(theater2);
        //Theaterservice.deletetheater(124);
        //Theaterservice.printtheater();
        System.out.println("-------------------------------------------------");       
        //Theaterservice.getTheater(124).display();
        //theaterjdbcservice.addtheater();
        //theaterjdbcservice.updatetheater();
        //theaterjdbcservice.gettheater();
        //theaterjdbcservice.printtheater();
        //theaterjdbcservice.deletetheater();
        theaterjdbcservice.printtheater();
        System.out.println("-------------------------------------------------");   
        //theaterjdbcservice.totaldetails();    
        //Theaterservice.modify(123, "location", "abc street sirumugai").display();

        System.out.println("-------------------------------------------------");   
        System.out.println("-------------------------------------------------");   
        //totaldetails.total();

        System.out.println("-------------------------------------------------");   
        System.out.println("-------------------------------------------------");  
        
        //Booking booking=new Booking(1, user1, movie1, show1, theater1);
        //Bookingservice.addbooking(booking);
       // Bookingservice.printbooking();

        //Bookingjdbcconnection.addbook();
        Bookingjdbcconnection.printbook();
        //Bookingjdbcconnection.updatebook();
        //Bookingjdbcconnection.getbook();
        //Bookingjdbcconnection.delete();

        totaldetails.total();

        


        

        


    }
}
