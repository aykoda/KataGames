package SeatPlacement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SeatPlacementTest {

    private AreaSeats AreaSeats;
    private UsersTickets usersTickets;
    private SeatPlacement seatPlacement;
    Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

    @Before
    public void beforeTest() {

        AreaSeats = new AreaSeats();
        usersTickets = new UsersTickets();
        seatPlacement = new SeatPlacement(AreaSeats, usersTickets);

        hmap.put(0, 0);
        seatPlacement.setNextEmptySeatPlace(hmap);
    }
    @Test
    public void should_getDefaultSeatsOrdering() {
        SeatPlacement.seatsOrdering result = seatPlacement.getSeatsOrder();
        SeatPlacement.seatsOrdering expect = seatPlacement.DEFAULT_ORDER;

        Assert.assertEquals(expect, result);
    }

    @Test
    public void should_getNextEmptySeatPlace() {
        Map<Integer, Integer> result = seatPlacement.getNextEmptySeatPlace();
        Map<Integer, Integer> expect = hmap;

        Assert.assertEquals(expect, result);
    }
}
