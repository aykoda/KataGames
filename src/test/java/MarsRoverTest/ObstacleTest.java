package MarsRoverTest;

import MarsRover.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ObstacleTest {
    //#region VariablesDefinition
    private Coordinates surfaceSquare, surfaceCircle;
    private List<Coordinates> obstacleList = new ArrayList<Coordinates>();

    private Obstacle roverSet = new Obstacle();
    private static Obstacle obstacleSet;

    private List<Rover> rovers;
    //#endregion
    @Before
    public void beforeTest() {
        //#region Coordinates
        surfaceSquare = new Coordinates(3, 3, 5, 5, Direction.NORTH);
        surfaceCircle = new Coordinates(2, 2, Direction.NORTH);
        //#endregion
        //#region ObstacleList
        obstacleList = Arrays.asList(
                new Coordinates(3, 4, Direction.CENTER),
                new Coordinates(1, 1, Direction.CENTER),
                new Coordinates(1, 2, Direction.CENTER),
                new Coordinates(1, 3, Direction.CENTER));
        obstacleSet = new Obstacle(new Coordinates(4, 4, Direction.CENTER));
        obstacleSet.setObstaclesList(obstacleList);
        obstacleSet.isSetObstaclesListByValue(new Coordinates(2, 2, Direction.CENTER));

        rovers = Arrays.asList(
                new Rover(surfaceSquare, "MMLRMM", roverSet),
                new Rover(surfaceCircle, "MRLMLRMM", roverSet));
        //#endregion
    }
    //#region InitTestSection
    @Test
    public void A_should_SetInit_ObstacleList() {
        assertThat(obstacleSet.getObstaclesList().size()).isEqualTo(6);
    }
    @Test
    public void B_should_NotAddToList_ExistObstacle() {
        boolean result = obstacleSet.isSetObstaclesListByValue(new Coordinates(2, 2, Direction.CENTER));
        Assert.assertEquals(false, result);
    }
    @Test
    public void C_should_AddToList_RandomObstacles() {
        obstacleSet.setRandomObstacle(5, 5, 2);
        assertThat(obstacleSet.getObstaclesList().size()).isNotEqualTo(5);
    }
    @Test
    public void D_should_SetInit_RoverObstacleList() {
        assertThat(roverSet.getObstaclesList().size()).isEqualTo(2);
    }
    @Test
    public void E_should_NotAddToObstacleList_RoverExistCoordinates() {
        boolean result = roverSet.isSetObstaclesListByValue(surfaceSquare);
        Assert.assertEquals(false, result);
    }
    @Test
    public void F_should_Merge_AD_ObstacleAndRoverList() {
        obstacleSet.setObstaclesList(roverSet.getObstaclesList());
        assertThat(obstacleSet.getObstaclesList().size()).isEqualTo(7);
    }
    //#endregion

}

