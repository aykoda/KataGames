package SeatPlacement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UsersTicketsTest {

    private int ticketsNumber=5;
    private UsersTicketsImpl usersTickets;
    private UsersTicketsImpl usersTicketsCustom;

    @Before
    public void beforeTest() {
        usersTickets = new UsersTicketsImpl();
        usersTicketsCustom = new UsersTicketsImpl(ticketsNumber);
    }

    @Test
    public void should_getCustomerTicketsNumber() {
        int result = usersTicketsCustom.getTicketsNumber();

        Assert.assertEquals(ticketsNumber, result);
    }

    @Test
    public void should_getRandomTicketsNumber() {
        usersTicketsCustom.setTicketsNumber();
        int result = usersTicketsCustom.getTicketsNumber();

        Assert.assertEquals(usersTicketsCustom.getTicketsNumber(), result);
    }
}
