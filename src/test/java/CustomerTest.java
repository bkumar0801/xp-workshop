import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void shouldPrintStatementForRegularMovieRentedForTwoDays() {
        Movie terminator = new Movie("Terminator", Movie.REGULAR);
        Rental rentalForTerminator = new Rental(terminator, 2);
        Customer adam = new Customer("Adam");
        adam.addRental(rentalForTerminator);
        String expectedStatement = "Rental Record for Adam\n" +
                "\tTerminator\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, adam.statement());
    }
    @Test
    public void shouldPrintStatementForRegularMovieRentedForMoreThanTwoDays() {
        Movie terminator = new Movie("Terminator", Movie.REGULAR);
        Rental rentalForTerminator = new Rental(terminator, 4);
        Customer adam = new Customer("Kevin");
        adam.addRental(rentalForTerminator);
        String expectedStatement = "Rental Record for Kevin\n" +
                "\tTerminator\t5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, adam.statement());
    }
    @Test
    public void shouldPrintStatementForChildrensMovieRentedForTwoDays() {
        Movie jungleBook = new Movie("Jungle Book", Movie.CHILDRENS);
        Rental rentalForJungleBook = new Rental(jungleBook, 2);
        Customer ryan = new Customer("Ryan");
        ryan.addRental(rentalForJungleBook);
        String expectedStatement = "Rental Record for Ryan\n" +
                "\tJungle Book\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, ryan.statement());
    }
    @Test
    public void shouldPrintStatementForChildrensMovieRentedForMoreThanThreDays() {
        Movie jungleBook = new Movie("Jungle Book", Movie.CHILDRENS);
        Rental rentalForJungleBook = new Rental(jungleBook, 4);
        Customer ryan = new Customer("Ryan");
        ryan.addRental(rentalForJungleBook);
        String expectedStatement = "Rental Record for Ryan\n" +
                "\tJungle Book\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, ryan.statement());
    }

    @Test
    public void shouldPrintStatementForNewReleaseMovieRented() {
        Movie newton = new Movie("Newton", Movie.NEW_RELEASE);
        Rental rentalForNewton = new Rental(newton, 4);
        Customer rahul = new Customer("Rahul");
        rahul.addRental(rentalForNewton);
        String expectedStatement = "Rental Record for Rahul\n" +
                "\tNewton\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expectedStatement, rahul.statement());
    }

    @Test
    public void shouldPrintStatementForMoreThanOneMoviesRented() {
        Movie newton = new Movie("Newton", Movie.NEW_RELEASE);
        Rental rentalForNewton = new Rental(newton, 1);
        Movie jungleBook = new Movie("Jungle Book", Movie.CHILDRENS);
        Rental rentalForJungleBook = new Rental(jungleBook, 4);
        Movie terminator = new Movie("Terminator", Movie.REGULAR);
        Rental rentalForTerminator = new Rental(terminator, 4);
        Customer rahul = new Customer("Rahul");
        rahul.addRental(rentalForJungleBook);
        rahul.addRental(rentalForNewton);
        rahul.addRental(rentalForTerminator);
        String expectedStatement = "Rental Record for Rahul\n" +
                "\tJungle Book\t3.0\n" +
                "\tNewton\t3.0\n" +
                "\tTerminator\t5.0\n" +
                "Amount owed is 11.0\n" +
                "You earned 3 frequent renter points";
        assertEquals(expectedStatement, rahul.statement());

    }

    @Test
    public void shouldPrintHtmlStatementForRentedMovies() {
        Movie newton = new Movie("Newton", Movie.NEW_RELEASE);
        Rental rentalForNewton = new Rental(newton, 1);
        Movie jungleBook = new Movie("Jungle Book", Movie.CHILDRENS);
        Rental rentalForJungleBook = new Rental(jungleBook, 4);
        Movie terminator = new Movie("Terminator", Movie.REGULAR);
        Rental rentalForTerminator = new Rental(terminator, 4);
        Customer rahul = new Customer("Rahul");
        rahul.addRental(rentalForJungleBook);
        rahul.addRental(rentalForNewton);
        rahul.addRental(rentalForTerminator);
        String expectedStatement = "<H1>Rentals for <EM>Rahul</EM></H1><P>\n" +
                "Jungle Book: 3.0<BR>\n" +
                "Newton: 3.0<BR>\n" +
                "Terminator: 5.0<BR>\n" +
                "<P>You owe <EM>11.0</EM><P>\n" +
                "On this rental you earned <EM>3</EM> frequent renter points<P>";
        assertEquals(expectedStatement, rahul.htmlStatement());
    }
}