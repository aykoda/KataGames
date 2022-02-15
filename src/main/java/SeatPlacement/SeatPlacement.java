package SeatPlacement;

public class SeatPlacement {
    public enum seatsOrdering{
        BY_LINEAR_SELECT,
        BY_CUSTOM_SELECT,
        BY_RANDOM_SELECT,
        BY_BEST_PRIORITY,
        BY_RESTRICTIONS;
    }
    private boolean isCapacityFull;
    public final seatsOrdering DEFAULT_ORDER = seatsOrdering.BY_LINEAR_SELECT;
    private seatsOrdering seatsOrder;
    private int[] nextEmptySeat = new int[2];

    AreaSeats AreaSeatsPlacement;
    UsersTickets UsersTickets;

    public SeatPlacement(AreaSeats AreaSeatsPlacement, UsersTickets UsersTickets){
      this.AreaSeatsPlacement = AreaSeatsPlacement;
      this.UsersTickets = UsersTickets;

      setSeatsOrder(DEFAULT_ORDER);
      setCapacityFull(IsCapacityFull());
    }

    public void EvaluateSeatPlacement(){//seatsOrdering orderingCase){
        if (getCapacityFull() ==false) { //setSeatsOrder(orderingCase);
            switch (getSeatsOrder()) {
                case BY_LINEAR_SELECT:
                    EvaluateLinearOrdering();
                    break;
                case BY_CUSTOM_SELECT:
                    break;
                case BY_RANDOM_SELECT:
                    break;
            }
        }
        else
            System.out.println("Area Full Capacity.");
            //throw new Exception("Area Full Capacity.");//System.out.println("");//new Exception();
    }
    private void EvaluateLinearOrdering(){

        System.out.println("---- Ticket number:"+UsersTickets.getTicketsNumber());
        int[] nextEmptySeat = new int[2];
        int r=getNextEmptySeat()[0];
        int c=getNextEmptySeat()[1];
        Integer areaSeats[][] = AreaSeatsPlacement.getAreaSeats();
        int i;
        for (i=0; i<UsersTickets.getTicketsNumber(); i++) {
            areaSeats[r][c] = 1;
            System.out.printf("Ticket:%s r:%s c:%s value:%s\n",i+1,r+1,c+1,areaSeats[r][c]);

            if (isLastSeatAtRow(c) == true) {
                if (isLastRow(r) == true) { //IsCapacityFull()
                    i++;
                    setCapacityFull(true);
                    break;
                }
                else {
                    r += 1;
                    c = 0;
                }
            }else
                c += 1;
        }
        AreaSeatsPlacement.setAllocatedSeats(i);
        AreaSeatsPlacement.setAreaSeats(areaSeats);
        setNextEmptySeat(new int[]{r,c});
    }
    public boolean getCapacityFull() {
        return isCapacityFull;
    }

    public void setCapacityFull(boolean capacityFull) {
        isCapacityFull = capacityFull;
    }

    public boolean IsCapacityFull(){
        int row =getNextEmptySeat()[0] + 1;
        int col =getNextEmptySeat()[1] + 1;
        return (row*col == AreaSeatsPlacement.getAreaCapacity())?
                true :false;
    }

    public int[] getNextEmptySeat() {
        return nextEmptySeat;
    }

    public void setNextEmptySeat(int[] nextEmptySeat) {
        this.nextEmptySeat = nextEmptySeat;
    }

    public boolean isLastSeatAtRow(int lastColumn){
        return (lastColumn == AreaSeatsPlacement.getColumnSeats()-1) ? true:false;
    }

    public boolean isLastRow(int lastRow){
        return (lastRow == AreaSeatsPlacement.getRowSeats()-1) ? true:false;
    }

    public seatsOrdering getSeatsOrder() {
        return seatsOrder;
    }

    public void setSeatsOrder(seatsOrdering seatsOrder) {
        this.seatsOrder = (seatsOrder==null)? DEFAULT_ORDER : seatsOrder;
    }
}
