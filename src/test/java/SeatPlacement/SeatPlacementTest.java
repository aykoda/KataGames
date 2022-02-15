package SeatPlacement;

import MarsRover.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class SeatPlacementTest {

    private AreaSeatsImpl AreaSeats;
    private UsersTicketsImpl usersTickets;
    private SeatPlacement seatPlacement;

    private static AreaSeats AreaSeatsKeep = new AreaSeatsImpl();
    private static UsersTickets usersTicketsKeep = new UsersTicketsImpl();
    private static SeatPlacement fullSeatPlacement = new SeatPlacement(AreaSeatsKeep, usersTicketsKeep);

    private int[] nextEmptySeat = new int[2];
    private SeatPlacement.seatsOrdering result, expect, order;
    private int expected=0;

    @Before
    public void beforeTest() {
        AreaSeats = new AreaSeatsImpl();
        usersTickets = new UsersTicketsImpl();
        seatPlacement = new SeatPlacement(AreaSeats, usersTickets);

        usersTickets.setTicketsNumber(2);
        seatPlacement.EvaluateSeatPlacement();
    }
    @Test
    public void should_getDefaultSeatsOrdering() {
        result = seatPlacement.getSeatsOrder();
        expect = seatPlacement.DEFAULT_ORDER;

        Assert.assertEquals(expect, result);
    }
    @Test
    public void should_getCustomSeatsOrdering() {
        expect = order.BY_BEST_PRIORITY;
        seatPlacement.setSeatsOrder(expect);
        result = seatPlacement.getSeatsOrder();

        Assert.assertEquals(expect, result);
    }
    @Test
    public void should_getNextEmptySeatPlace() {
        int[] nextSeatResult = {0,2};
        Assert.assertEquals(seatPlacement.getNextEmptySeat()[0], nextSeatResult[0]);
        Assert.assertEquals(seatPlacement.getNextEmptySeat()[1], nextSeatResult[1]);
    }
    @Test
    public void should_EvaluateSeatPlacementCustomized() {
        expected += usersTickets.getTicketsNumber();

        usersTickets.setTicketsNumber(4);
        seatPlacement.EvaluateSeatPlacement();
        expected += usersTickets.getTicketsNumber();

        usersTickets.setTicketsNumber(5);
        seatPlacement.EvaluateSeatPlacement();
        expected += usersTickets.getTicketsNumber();

        Assert.assertEquals(expected, AreaSeats.getAllocatedSeats());
    }
    @Test
    public void should_EvaluateSeatPlacementRandomly() {
        expected += usersTickets.getTicketsNumber();
        //random ticket number is picked default
        seatPlacement.EvaluateSeatPlacement();
        expected += usersTickets.getTicketsNumber();

        //new random ticket number is generated
        usersTickets.setTicketsNumber();
        seatPlacement.EvaluateSeatPlacement();
        expected += usersTickets.getTicketsNumber();

        Assert.assertEquals(expected, AreaSeats.getAllocatedSeats());
        //System.out.println(expected +" "+ AreaSeats.getAllocatedSeats());

    }
    private static Stream<Arguments> parametersCustomTicketNumbers() {
        return Stream.of(
                Arguments.of(4,4),
                Arguments.of(3,7),
                Arguments.of(7,14),
                Arguments.of(5,15),
                Arguments.of(3,15)
        );
    }
    //@Ignore
    @ParameterizedTest
    @MethodSource("parametersCustomTicketNumbers")
    public void should_AllocatedSeats_UntilFullCapacity(int prmTicketNumbers, int prmResult) {
        usersTicketsKeep.setTicketsNumber(prmTicketNumbers);
        fullSeatPlacement.EvaluateSeatPlacement();
        Assert.assertEquals(AreaSeatsKeep.getAllocatedSeats(), prmResult);
    }
}
