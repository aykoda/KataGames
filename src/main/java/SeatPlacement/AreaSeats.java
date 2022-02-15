package SeatPlacement;

public interface AreaSeats {
    void setAllocatedSeats(int allocatedSeats);

    int getAllocatedSeats();

    int getAreaCapacity();

    int getColumnSeats();

    void setColumnSeats(int columnSeats);

    int getRowSeats();

    void setRowSeats(int rowSeats);

    Integer[][] getAreaSeats();

    void setAreaSeats(Integer[][] areaSeats);
}
