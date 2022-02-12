package SeatPlacement;

public class UsersTickets implements UsersTicketsImpl {
    public final int TICKETS_NUMBER = 3;
    private int ticketsNumber = 0;

    public UsersTickets(){
        setTicketsNumber(0);
    }

    public UsersTickets(int requstTicketsNumber){
        setTicketsNumber(requstTicketsNumber);
    }

    @Override
    public int getTicketsNumber() {
        return ticketsNumber;
    }

    @Override
    public void setTicketsNumber(int ticketsNumber) {
        this.ticketsNumber = ticketsNumber == 0 ? TICKETS_NUMBER : ticketsNumber;
    }

    @Override
    public int getTicketsNumberRandomly() {
        return ticketsNumber;
    }
}
