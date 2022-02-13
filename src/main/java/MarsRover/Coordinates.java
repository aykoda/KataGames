package MarsRover;

public class Coordinates {
    private int x;
    private int y;
    private int maxX;
    private int maxY;
    private Direction direction;
    private Obstacle obstacle = new Obstacle();
    private boolean IS_CIRCLE;

    public Coordinates() {}

    public Coordinates(int xValue, int yValue, int maxX, int maxY, Direction directionValue) {
        setMaxX(maxX);
        setMaxY(maxY);
        setInits(xValue, yValue, directionValue, false);
    }

    public Coordinates(int xValue, int yValue, Direction directionValue) {
        setInits(xValue, yValue, directionValue, true);
    }

    private void setInits(int xValue, int yValue, Direction directionValue, boolean isCircle) {
        setX(xValue);
        setY(yValue);
        setDirection(directionValue);
        setIsCircle(isCircle);
    }

    private boolean isCoordinatesLimit(boolean setByX, boolean byAdd, int nextPoint) {
        //System.out.println("-------IsCircle: "+ getIsCircle());
        int limitPoint = 0, maxLimit = 0;
        //--------- MIN limit kontrol
        int minLimit = (nextPoint == 1) ? 0 : 1;
        if (nextPoint == 0) nextPoint = 1;

        //--------- MAX limit kontrol
        int maxPoint = (setByX) ? getMaxX() : getMaxY();
        maxLimit = (nextPoint == maxPoint) ? maxPoint + 1 : maxPoint;
        if (nextPoint == maxPoint + 1) nextPoint = maxPoint;

        limitPoint = (byAdd) ? maxLimit : minLimit;

        if (nextPoint == limitPoint)
            return true;
        return false;
/* Reforming code up
        if (setByX) {
            maxLimit = (nextPoint==getMaxX())? getMaxX()+1:getMaxX();
            if (maxLimit==(getMaxX()+1)) nextPoint = getMaxX();
            limitPoint = (byAdd) ? maxLimit : minLimit;
        }
        else{
            maxLimit = (nextPoint==getMaxY())? getMaxY()+1:getMaxY();
            if (maxLimit==(getMaxY()+1)) nextPoint = getMaxY();
            limitPoint = (byAdd)? maxLimit : minLimit;
        }
*/
    }

    public boolean isObstacleCoordinates(boolean setByX, int nextPoint) {
        int x = (setByX == true) ?  nextPoint: getX();
        int y = (setByX == false) ? nextPoint : getY();

        //System.out.println("isObstacleCoordinates X Y "+x +"  "+y);
        return obstacle.isObstacleCoordinates(new Coordinates(x, y, getDirection()));
    }

    private boolean isLimitOrObstacle(boolean setByX, boolean byAdd, int nextPoint) {

        boolean isObstacle = true, isLimit = true;

        isLimit = (getIsCircle() == false) ? isCoordinatesLimit(setByX, byAdd, nextPoint) : false;
        if (isLimit == true)
            System.out.printf("No move. It is a Limit at X:%s Y:%s   NEXT:%s.\n", getX(), getY(), nextPoint);

        if (isObstacle = isObstacleCoordinates(setByX, nextPoint))
            System.out.printf("No move. It is Obstacle at X:%s Y:%s    NEXT:%s.\n", getX(), getY(), nextPoint);

        return (isLimit || isObstacle) == true;
    }

    public boolean calculateCoordinates() {
        int xNextPoint = getX();
        int yNextPoint = getY();

        int nextPoint = 0;
        boolean isControlByX = false, isControlByAdd = false;

        switch (getDirection()) {
            case EAST:
                //if (!isCoordinatesLimit(getX(), getMaxX()))
                //if(!isCoordinatesObstacle(xLocation + 1,getY()))
                //    setX(xLocation + 1);
                isControlByX = (isControlByAdd = true);
                nextPoint = (xNextPoint += 1);
                break;
            case WEST:
                //if (!isCoordinatesLimit(getX(), 0))
                //if(!isCoordinatesObstacle(xLocation - 1,getY()))
                //setX(xLocation - 1);
                isControlByX = !(isControlByAdd = false);
                nextPoint = (xNextPoint -= 1);
                break;
            case NORTH:
                /*if (!isCoordinatesLimit(getY(), getMaxY()))
                    if(!isCoordinatesObstacle(getX(), yLocation + 1))
                        setY(yLocation + 1);*/
                isControlByX = !(isControlByAdd = true);
                nextPoint = (yNextPoint += 1);
                break;
            case SOUTH:
                //if (!isCoordinatesLimit(getY(), 0))
                //if(!isCoordinatesObstacle(getX(), yLocation - 1))
                //    setY(yLocation - 1);
                isControlByX = (isControlByAdd = false);
                nextPoint = (yNextPoint -= 1);
                break;        }
        if (isLimitOrObstacle(isControlByX, isControlByAdd, nextPoint) == false) {

            System.out.printf("Old X:%s Y:%s \n", getX(), getY());
            setX(xNextPoint);
            setY(yNextPoint);
            System.out.printf("New X:%s Y:%s \n", getX(), getY());
            return true;
        } else {
            return false;
        }
    }

    public void changeDirectionLeft() {

        System.out.println("Old Direction: " + getDirection());

        switch (getDirection()) {
            case NORTH:
                setDirection(Direction.WEST);
                break;
            case EAST:
                setDirection(Direction.NORTH);
                break;
            case SOUTH:
                setDirection(Direction.EAST);
                break;
            case WEST:
                setDirection(Direction.SOUTH);
                break;
        }
        System.out.println("New Direction: " + getDirection());
    }

    public void changeDirectionRight() {
        System.out.println("Old Direction: " + getDirection().getShortName());

        switch (getDirection()) {
            case NORTH:
                setDirection(Direction.EAST);
                break;
            case EAST:
                setDirection(Direction.SOUTH);
                break;
            case SOUTH:
                setDirection(Direction.WEST);
                break;
            case WEST:
                setDirection(Direction.NORTH);
                break;
        }
        System.out.println("New Direction: " + getDirection().getShortName());
    }

    @Override
    public String toString() {

        return getX() + " " + getY() + " " + getDirection().getShortName();
    }

    public boolean setCoordinatesPerDirection() {

        return calculateCoordinates();
    }

    public void setDirection(Direction value) {
        direction = value;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setX(int value) {
        x = value;
    }

    public int getX() {
        return x;
    }

    public void setY(int value) {
        y = value;
    }

    public int getY() {
        return y;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public boolean getIsCircle() {
        return IS_CIRCLE;
    }

    public void setIsCircle(boolean isCircle) {
        IS_CIRCLE = isCircle;
    }
}
