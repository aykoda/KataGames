package SeatPlacement;

import java.util.Map;

public class SeatPlacement {

    public enum seatsOrdering{
        BY_LINEAR_SELECT,
        BY_CUSTOM_SELECT,
        BY_RANDOM_SELECT,
        BY_BEST_PRIORITY,
        BY_RESTRICTIONS;
    }

    public final seatsOrdering DEFAULT_ORDER = seatsOrdering.BY_LINEAR_SELECT;
    private seatsOrdering seatsOrder;
    private Map<Integer,Integer> nextEmptySeatPlace;

    AreaSeatsImpl AreaSeatsPlacement;
    UsersTicketsImpl UsersTickets;

    public SeatPlacement(){}

    public SeatPlacement(AreaSeatsImpl AreaSeatsPlacement, UsersTicketsImpl UsersTickets){
      this.AreaSeatsPlacement = AreaSeatsPlacement;
      this.UsersTickets = UsersTickets;

      setSeatsOrder(DEFAULT_ORDER);
    }

    public void EvaluateSeatPlacement(seatsOrdering orderingCase){
        setSeatsOrder(orderingCase);
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
    private void EvaluateLinearOrdering(){

    }


    public Map<Integer,Integer> getNextEmptySeatPlace() {
        return nextEmptySeatPlace;
    }

    public void setNextEmptySeatPlace(Map<Integer,Integer> nextSeatPlace) {
        this.nextEmptySeatPlace = nextSeatPlace;
    }

    public int isLastRowSeats(){
        int nextColumn=0;
        return nextColumn;
    }

    public seatsOrdering getSeatsOrder() {
        return seatsOrder;
    }

    public void setSeatsOrder(seatsOrdering seatsOrder) {
        this.seatsOrder = (seatsOrder==null)? DEFAULT_ORDER : seatsOrder;
    }
}
