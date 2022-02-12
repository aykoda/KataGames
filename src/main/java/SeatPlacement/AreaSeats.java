package SeatPlacement;

public class AreaSeats implements AreaSeatsImpl {

    public final int MAX_COLUMN_SEATS = 5, MAX_ROW_SEATS = 3;
    private int columnSeats = 0, rowSeats = 0;

    //private List<String[][]> areaSeats;// = new Integer[rowSeats][columnSeats];
    private Integer[][] areaSeats;

    public AreaSeats() {
        initAreaSeats();
    }
    public AreaSeats( int reqRowSeats, int reqColumnSeats){
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
    public int getEmptySeats(int byRow) {
        return 0;
    }
    @Override
    public int getAllocatedSeats(int byRow) {
        return 0;
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
}
