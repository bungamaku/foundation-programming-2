import movie.Movie;
import ticket.Ticket;
import theater.Theater;
import customer.Customer;
import java.util.ArrayList;
import java.util.Arrays;
//Please add more necessary import here
/**
 * @author Johanes Iman
 * @version 2.4
 * created for tutorial 6 DDP2
 * You don't need to change any code here except importing modules and when you want to work on the Bonus problem.
 * If you want to work on Bonus problem, just UNCOMMENT the section below AND on the TEST program.
 * Don't forget to put your works (Class for Movie, Ticket, Theater, and Customer )in each separate package.
 */
public class Lab6 {
    public static void main(String[] args) {
        //Create lists of movies
        Movie[] movies = createMovieList();
        Movie[] movies2 = {movies[0], movies[1]};

        //Create lists of tickets for each movie
        Ticket[] tickets1 = createTicket1(movies);
        Ticket[] tickets2 = createTicket2(movies);

        //Create theaters with name, initial cash balance, lists of tickets, and the movies available there
        Theater[] theaters = {new Theater("CGT Blitz", 0, new ArrayList<>(Arrays.asList(tickets1)), movies),
                             new Theater("CompFest XXI", 25000, new ArrayList<>(Arrays.asList(tickets2)), movies2)};

        //create customers with name, gender, and age
        Customer dekDepe = new Customer("Dek Depe","Perempuan",10);
        Customer sisDea = new Customer("Sis Dea","Perempuan",15);
        Customer kakPewe = new Customer("Kak Pewe","Laki-Laki",20);

        //Theater can print detailed information about itself, following the format as told in the problem description
        theaters[0].printInfo();
        theaters[1].printInfo();
        
        //Customer can order ticket by giving information about the theater, the movie title, the airtime (day), and the option "3 Dimensi" or "Biasa"
        Ticket tiketDekDepe1 = dekDepe.orderTicket(theaters[0], "Black Panther", "Senin", "3 Dimensi");
        Ticket tiketDekDepe2 = dekDepe.orderTicket(theaters[0], "The Greatest Showman", "Selasa", "3 Dimensi");
        
        //Customer can find movie in a theater by querying its movie title
        sisDea.findMovie(theaters[1], "Si Juki The Movie");
        sisDea.findMovie(theaters[1], "Dilan 1990");

        Ticket tiketSisDea1 = sisDea.orderTicket(theaters[1], "Dilan 1990", "Selasa", "Biasa");
        Ticket tiketSisDea2 = sisDea.orderTicket(theaters[1], "Dilan 1990", "Sabtu", "Biasa");
        Ticket tiketSisDea3 = sisDea.orderTicket(theaters[0], "Si Juki The Movie", "Jumat", "3 Dimensi");

        Ticket tiketPewe1 = kakPewe.orderTicket(theaters[0],"Si Juki The Movie", "Kamis", "Biasa");
        Ticket tiketPewe2 = kakPewe.orderTicket(theaters[1],"Black Panther", "Sabtu", "3 Dimensi");
        //This is a static method where Koh Mas can print the total revenue he earned from his theaters
        Theater.printTotalRevenueEarned(theaters);

        /*==========Codes for BONUS problem==========
        kakPewe.cancelTicket(theaters[0]);//Kak Pewe make refund to  CGT Blitz
        kakPewe.cancelTicket(theaters[1]);
        kakPewe.watchMovie(tiketPewe1);
        kakPewe.cancelTicket(theaters[0]);
        sisDea.cancelTicket(theaters[0]);

        Theater.printTotalRevenueEarned(theaters);//Bankrupt duh!
        */


    }
    //Create array of movie with information of each movie's title, parental rating, duration, genre, and the status whether its "Import" or "Lokal" movie
    public static Movie[] createMovieList() {
        Movie[] movies = {new Movie("Black Panther","Remaja",134,"Action/Adventure","Import"),
                new Movie("Dilan 1990","Remaja",110,"Romantis/Drama","Lokal"),
                new Movie("The Greatest Showman","Umum",106,"Drama/Musical","Import"),
                new Movie("Si Juki The Movie","Dewasa",100,"Jomblo","Lokal")};
        return movies;
    }
    //Create array of ticket with information of each ticket's movies, airtime, and the option whether it is in 3D (true) or not (false)  
    public static Ticket[] createTicket1(Movie[] movies) {
        Ticket[] tickets1 = {new Ticket(movies[0],"Senin",false), new Ticket(movies[0],"Selasa",true),new Ticket(movies[0],"Sabtu",true),
                new Ticket(movies[1],"Senin",true), new Ticket(movies[1],"Rabu",true),new Ticket(movies[1],"Minggu",true),
                new Ticket(movies[2],"Selasa",true), new Ticket(movies[2],"Jumat",true),new Ticket(movies[2],"Minggu",true),
                new Ticket(movies[3],"Kamis",false), new Ticket(movies[3],"Jumat",true),new Ticket(movies[3],"Sabtu",true)};
        return tickets1;
    }
    //Create array of ticket with information of each ticket's movies, airtime, and the option whether it is in 3D (true) or not (false)
    public static Ticket[] createTicket2(Movie[] movies) {
        Ticket[] tickets2 = {new Ticket(movies[0],"Senin",false), new Ticket(movies[0],"Selasa",true),new Ticket(movies[0],"Sabtu",true),
                new Ticket(movies[0],"Rabu",false), new Ticket(movies[0],"Kamis",false),new Ticket(movies[0],"Minggu",false),
                new Ticket(movies[1],"Senin",true), new Ticket(movies[1],"Jumat",false),new Ticket(movies[1],"Minggu",false),
                new Ticket(movies[1],"Senin",false), new Ticket(movies[1],"Sabtu",false),new Ticket(movies[1],"Minggu",true)};
        return tickets2;
    }
}
