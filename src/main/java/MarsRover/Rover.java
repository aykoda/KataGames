package MarsRover;

import MarsRover.Coordinates;

import java.lang.reflect.Executable;

/*
Method receiveCommands should be used to transmit commands to the rover.
 */
public class Rover {

    private String commands;
    private Coordinates coordinates;
    private Obstacle roverObstacle;
    private Coordinates OBSTACLE_UPDATE;
    private boolean OBSTACLE_ADD;

    public Rover() {
    }

    public Rover(Coordinates coordinatesValue, String commands, Obstacle obstacle) {

        setObstacleUpdate(coordinatesValue);
        setCoordinates(coordinatesValue);
        setCommands(commands);

        roverObstacle = obstacle;
        setIsObstacleAdd(roverObstacle.isSetObstaclesListByValue(coordinatesValue));
    }

    public boolean getIsObstacleAdd() {
        return OBSTACLE_ADD;
    }

    public void setIsObstacleAdd(boolean isObstacleAdd) {
        OBSTACLE_ADD = isObstacleAdd;
    }

    public Coordinates getObstacleUpdate() {
        return OBSTACLE_UPDATE;
    }

    public void setObstacleUpdate(Coordinates obstacleUpdate) {
        OBSTACLE_UPDATE = obstacleUpdate;
    }

    public String commandsMove() {
        String resultPosition = "";

        if (getIsObstacleAdd()) {
            commandsMoveEX();
            resultPosition = getPosition();
            System.out.println(resultPosition);
        } else
            System.out.println("errrrr");

        return resultPosition;
    }

    public void commandsMoveEX() {

        for (char command : getCommands().toCharArray()) {
            singleCommandMove(command);
            //on obstacle stop moving
            //if (!singleCommandMove(command))
            //    break;
        }
        updateRoverObstacleList();
    }

    public boolean singleCommandMove(char command) {
        System.out.println("\n*** Command: " + command);

        switch (Character.toUpperCase(command)) {
            case 'M':
                return coordinates.setCoordinatesPerDirection();
            case 'L':
                coordinates.changeDirectionLeft();
                return true;
            case 'R':
                coordinates.changeDirectionRight();
                return true;
            default:
                break;
            //throw new Exception("Command " + command + " is unknown.");
        }
        return false;
    }

    public void updateRoverObstacleList() {
        //roverObstacle.deleteObstaclesList(OBSTACLE_UPDATE);
        //roverObstacle.setObstaclesList(getCoordinates());
        System.out.println("OLDobst: " + getObstacleUpdate());
        roverObstacle.updateObstacle(getObstacleUpdate(), getCoordinates());
    }

    public String getPosition() {

        return getCoordinates().toString();
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public void setCoordinates(Coordinates value) {

        coordinates = value;
    }

    public Coordinates getCoordinates() {

        return coordinates;
    }

    public Obstacle getRoverObstacle() {
        return roverObstacle;
    }

    public void setRoverObstacle(Obstacle roverObstacle) {
        this.roverObstacle = roverObstacle;
    }
}
