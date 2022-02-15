package SeatPlacement;

public class AreaSeatsImpl implements AreaSeats {

    public final int MAX_COLUMN_SEATS = 5, MAX_ROW_SEATS = 3;
    private int columnSeats = 0;
    private int rowSeats = 0;
    private int allocatedSeats;
    private Integer[][] areaSeats;

    public AreaSeatsImpl() {
        initAreaSeats();
    }
    public AreaSeatsImpl( int reqRowSeats, int reqColumnSeats){
        columnSeats = reqColumnSeats;
        rowSeats = reqRowSeats;
        initAreaSeats();
    }
    private void initAreaSeats(){
        if (getColumnSeats() == 0 || getRowSeats()== 0){
            setColumnSeats(MAX_COLUMN_SEATS);
            setRowSeats(MAX_ROW_SEATS);
        }

        areaSeats= new Integer[getRowSeats()][getColumnSeats()];

        //areaSeats = new ArrayList<String[][]>();
        //areaSeats.add(seats);
    }

    @Override
    public int getAreaCapacity() {
        return getColumnSeats() * getRowSeats();
    }

    @Override
    public int getColumnSeats() {
        return columnSeats;
    }

    @Override
    public void setColumnSeats(int columnSeats) {
        this.columnSeats = columnSeats;
    }

    @Override
    public int getRowSeats() {
        return rowSeats;
    }

    @Override
    public void setRowSeats(int rowSeats) {
        this.rowSeats = rowSeats;
    }

    @Override
    public Integer[][] getAreaSeats() {
        return areaSeats;
    }

    @Override
    public void setAreaSeats(Integer[][] areaSeats) {
        this.areaSeats = areaSeats;
    }
    @Override
    public int getAllocatedSeats() {
        return allocatedSeats;
    }
    @Override
    public void setAllocatedSeats(int allocatedSeats) {
        this.allocatedSeats = getAllocatedSeats() + allocatedSeats;
    }
}
