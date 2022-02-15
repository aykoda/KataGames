package SeatPlacement;

import java.util.Random;

public class UsersTicketsImpl implements UsersTickets {
    public final int TICKETS_NUMBER = 3;
    private int ticketsNumber= 0;

    public UsersTicketsImpl(){

        setTicketsNumber();
    }

    public UsersTicketsImpl(int requstTicketsNumber){

        setTicketsNumber(requstTicketsNumber);
    }

    @Override
    public int getTicketsNumber() {
        return ticketsNumber;
    }

    @Override
    public void setTicketsNumber(int ticketsNumber) {
        this.ticketsNumber = (ticketsNumber < 1)? getTicketsNumberRandomly() : ticketsNumber;
    }
    @Override
    public void setTicketsNumber() {
        this.ticketsNumber =  getTicketsNumberRandomly();
    }


    private int getTicketsNumberRandomly() {
        return new Random().nextInt(TICKETS_NUMBER) +1;
    }
}
