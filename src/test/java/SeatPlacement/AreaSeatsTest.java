package SeatPlacement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AreaSeatsTest {
    private int rowSeats=15, columnSeats=10;
    private AreaSeatsImpl AreaSeats;
    private AreaSeatsImpl AreaSeatsCustom;

    @Before
    public void beforeTest() {
        AreaSeats = new AreaSeatsImpl();
        AreaSeatsCustom = new AreaSeatsImpl(rowSeats, columnSeats);
    }
    @Test
    public void should_getDefaultRowAndColumnSeats() {
        String result = AreaSeats.getRowSeats() + "-"+ AreaSeats.getColumnSeats();
        String expect = AreaSeats.MAX_ROW_SEATS + "-"+ AreaSeats.MAX_COLUMN_SEATS;

        Assert.assertEquals(expect, result);
    }
    @Test
    public void should_calculateDefaultAreaCapacity() {
        int result = AreaSeats.getAreaCapacity();
        int expect = AreaSeats.getRowSeats() * AreaSeats.getColumnSeats();

        Assert.assertEquals(expect, result);
    }
    @Test
    public void should_getCustomRowAndColumnSeats() {
        String result = AreaSeatsCustom.getRowSeats() + "-"+ AreaSeatsCustom.getColumnSeats();
        String expect = rowSeats + "-"+ columnSeats;

        Assert.assertEquals(expect, result);
    }
    @Test
    public void should_calculateCustomAreaCapacity() {
        int result = AreaSeatsCustom.getAreaCapacity();
        int expect = rowSeats * columnSeats;

        Assert.assertEquals(expect, result);
    }
}
