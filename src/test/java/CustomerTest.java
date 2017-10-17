import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void shouldPrintStatementForRentedMovies() {
        Movie terminator = new Movie("Terminator", Movie.REGULAR);
        Rental rentalForTerminator = new Rental(terminator, 3);
        Movie jungleBook = new Movie("Jungle Book", Movie.CHILDRENS);
        Rental rentalForJungleBook = new Rental(jungleBook, 2);
        Customer adam = new Customer("Adam");
        adam.addRental(rentalForTerminator);
        adam.addRental(rentalForJungleBook);
        String expectedStatement = "Rental Record for Adam\n" +
                "\tTerminator\t3.5\n" +
                "\tJungle Book\t1.5\n" +
                "Amount owed is 5.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expectedStatement, adam.statement());
    }
}
