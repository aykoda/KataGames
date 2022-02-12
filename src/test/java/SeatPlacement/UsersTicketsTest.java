package SeatPlacement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UsersTicketsTest {

    private int ticketsNumber=5;
    private UsersTickets usersTickets;
    private UsersTickets usersTicketsCustom;

    @Before
    public void beforeTest() {
        usersTickets = new UsersTickets();
        usersTicketsCustom = new UsersTickets(ticketsNumber);
    }

    @Test
    public void should_getDefaultTıcketsNumber() {
        int result = usersTickets.getTicketsNumber();

        Assert.assertEquals(usersTickets.TICKETS_NUMBER, result);
    }

    @Test
    public void should_getCustomerTıcketsNumber() {
        int result = usersTicketsCustom.getTicketsNumber();

        Assert.assertEquals(ticketsNumber, result);
    }

    @Test
    public void should_getRandomTıcketsNumber() {
        int result = usersTicketsCustom.getTicketsNumberRandomly();

        Assert.assertEquals(usersTicketsCustom.getTicketsNumber(), result);
    }
}
