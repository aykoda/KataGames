package MarsRover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Obstacle {
    Coordinates obstacle;
    private List<Coordinates> obstaclesList = new ArrayList<Coordinates>();

    public Obstacle() {}

    public Obstacle(Coordinates coordinatesValue) {
        coordinatesValue.setDirection(Direction.CENTER);
        isSetObstaclesListByValue(coordinatesValue);
    }

    public boolean isObstacleCoordinates(Coordinates newObstacle) {
        //System.out.println("obst list "+getObstaclesList());
        for (Coordinates obstacle : getObstaclesList()) {

            if ((obstacle.getX() == newObstacle.getX()) && (obstacle.getY() == newObstacle.getY())) {
                System.out.println("Coordinates EXIST ERR! Set a NEW X,Y for Obstacle: " + newObstacle);
                //throw new Exception("Coordinates EXIST ERR");
                return true;
            }
        }
        return false;
    }

    public boolean isSetObstaclesListByValue(Coordinates newObstacle) {

        if (isObstacleCoordinates(newObstacle) == false) {
            getObstaclesList().add(newObstacle);
            return true;
        }
        return false;
    }

    public void setRandomObstacle(int maxX, int maxY, int count) {
        int randomX = 0, randomY = 0;
        Coordinates newObstacle;

        while ((count -= 1) != -1) {
            newObstacle = new Coordinates();

            randomX = (randomX = new Random().nextInt(maxX + 1)) == 0 ? 1 : randomX;
            randomY = (randomY = new Random().nextInt(maxY + 1)) == 0 ? 1 : randomY;

            newObstacle.setX(randomX);
            newObstacle.setY(randomY);
            newObstacle.setDirection(Direction.CENTER);
            isSetObstaclesListByValue(newObstacle);
            System.out.println("Random Obstacle: " + newObstacle);
        }
    }

    public List<Coordinates> getObstaclesList() {
        return obstaclesList;
    }

    public void setObstaclesList(List<Coordinates> listCoordinates) {

        for (Coordinates obstacle : listCoordinates) {
            isSetObstaclesListByValue(obstacle);
        }
    }

    public void updateObstacle(Coordinates oldObstacle, Coordinates updObstacle) {

        obstaclesList.set(obstaclesList.indexOf(oldObstacle), updObstacle);
    }

    public Coordinates getObstaclesListByValue(Coordinates obstacle) {
        return obstaclesList.get(obstaclesList.indexOf(obstacle));
    }

    private Coordinates getObstacle() {
        return obstacle;
    }

    private void setObstacle(Coordinates obstacle) {
        this.obstacle = obstacle;
    }

    public void deleteObstacle(Coordinates obstacle) {
        obstaclesList.remove(obstacle);
    }
}
