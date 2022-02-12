package SeatPlacement;

public interface AreaSeatsImpl {
    int getEmptySeats(int byRow);

    int getAllocatedSeats(int byRow);

    int getAreaCapacity();

    int getColumnSeats();

    void setColumnSeats(int columnSeats);

    int getRowSeats();

    void setRowSeats(int rowSeats);
}
