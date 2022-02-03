import MarsRover.*;
import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    String resultPosition = "";
    private String command;
    private Coordinates surfaceSquare;
    private Coordinates surfaceCircle;

    Obstacle roverObstacle = new Obstacle();
    private Obstacle roverSet = new Obstacle();
    private static Obstacle obstacleKeep2;//= new Obstacle();
    static Obstacle obstacleKeep = new Obstacle();

    private Rover rover = new Rover();
    private static Rover roverKeep;

    private Obstacle obstacleSet;
    private List<Coordinates> obstacleList = new ArrayList<Coordinates>();
    private List<Rover> roverList;
    private List<String> commandList;

    @Before
    public void beforeTest() {
        command = "MMRMMRMMMLMMMLMMMMM";
        commandList = Arrays.asList(command, new String("MMRMMR"), new String("MLMMMLMMMMM"));

        surfaceSquare = new Coordinates(3, 3, 5, 5, Direction.NORTH);
        surfaceCircle = new Coordinates(2, 2, Direction.NORTH);
        rover = new Rover(surfaceSquare, command, roverSet);
        roverList = Arrays.asList(rover, new Rover(surfaceCircle, commandList.get(1), roverSet));

        obstacleList = Arrays.asList(
                new Coordinates(1, 2, Direction.CENTER),
                new Coordinates(1, 3, Direction.CENTER),
                new Coordinates(1, 4, Direction.CENTER),
                new Coordinates(1, 5, Direction.CENTER));
        obstacleSet = new Obstacle(new Coordinates(4, 4, Direction.CENTER));
        obstacleSet.setObstaclesList(obstacleList);
        obstacleSet.isSetObstaclesListByValue(new Coordinates(2, 2, Direction.CENTER));

        obstacleKeep2 = new Obstacle();
        roverKeep = new Rover(new Coordinates(3, 3, 5, 5, Direction.NORTH), "", obstacleKeep2);
    }

    @Test
    public void A_should_SetInit_ObstacleList() {

        System.out.println(obstacleSet.getObstaclesList());
        assertThat(obstacleSet.getObstaclesList().size()).isEqualTo(6);
    }

    @Test
    public void B_should_NotAddToList_ExistObstacle() {

        boolean result = obstacleSet.isSetObstaclesListByValue(new Coordinates(2, 2, Direction.CENTER));

        Assert.assertEquals(false, result);
        System.out.println(obstacleSet.getObstaclesList());
    }


    @Test
    public void C_should_AddToList_RandomObstacles() {

        obstacleSet.setRandomObstacle(5, 5, 2);
        assertThat(obstacleSet.getObstaclesList().size()).isNotEqualTo(5);
        System.out.println(obstacleSet.getObstaclesList());
    }

    @Test
    public void D_should_SetInit_RoverList() {

        System.out.println(roverSet.getObstaclesList());
        assertThat(roverSet.getObstaclesList().size()).isEqualTo(2);
    }

    @Test
    public void E_should_NotAddToList_RoverExistCoordinates() {

        boolean result = roverSet.isSetObstaclesListByValue(surfaceSquare);

        Assert.assertEquals(false, result);
        System.out.println(roverSet.getObstaclesList());
    }

    @Test
    public void F_should_Merge_AD_RoverAndObstacleList() {

        System.out.println("Obstacle list: " + obstacleSet.getObstaclesList());
        System.out.println("Rover list: " + roverSet.getObstaclesList());
        obstacleSet.setObstaclesList(roverSet.getObstaclesList());

        assertThat(obstacleSet.getObstaclesList().size()).isEqualTo(7);
        System.out.println("Obstacle+Rover : " + obstacleSet.getObstaclesList());
    }

    private static Stream<Arguments> parametersGenerator() {
        return Stream.of(
                Arguments.of(new Coordinates(1, 1, 5, 5, Direction.NORTH),
                        "MMRMMRMMMLMMMLMMMMM", "5 5 N", true),
                Arguments.of(new Coordinates(2, 2, 5, 5, Direction.NORTH),
                        "MMRMMLMMML", "4 5 W", true),
                Arguments.of(new Coordinates(2, 2, Direction.NORTH),
                        "MMRMMLMMML", "4 7 W", true),
                Arguments.of(new Coordinates(1, 2, 5, 5, Direction.NORTH),
                        "LMLMLMLMM", "2 3 N", true),
                Arguments.of(new Coordinates(3, 3, 5, 5, Direction.EAST),
                        "MMRMMRMRRM", "5 1 E", true)
        );
    }

    //@Ignore
    @ParameterizedTest
    @MethodSource("parametersGenerator")
    public void should_Move_SingleRover_Cases(Coordinates prmCoordinates, String prmCommand, String prmExpected, Boolean prmIsTrue) {

        rover = new Rover(prmCoordinates, prmCommand, roverObstacle);
        System.out.println("---Rover : " + rover.getCoordinates());
        System.out.printf("ALL OBSTACLES %s\n", roverObstacle.getObstaclesList());

        resultPosition = rover.commandsMove();
        Assert.assertEquals(resultPosition.contentEquals(prmExpected), prmIsTrue);
    }

    //@Ignore
    @ParameterizedTest
    @MethodSource("parametersGenerator")
    public void should_Move_SimultaneousRovers_ToBeObstacles(Coordinates prmCoordinates, String prmCommand, String prmExpected, Boolean prmIsTrue) {

        //obstacle2.setRandomObstacle(2,2,2);
        rover = new Rover(prmCoordinates, prmCommand, obstacleKeep);
        System.out.println("---Rover : " + rover.getCoordinates());
        System.out.printf("ALL OBSTACLES %s\n", obstacleKeep.getObstaclesList());

        resultPosition = rover.commandsMove();
        Assert.assertEquals(resultPosition.contentEquals(prmExpected), prmIsTrue);
    }

    private static Stream<Arguments> parametersGenerator2() {
        return Stream.of(
                Arguments.of("MMRMMRMMMLMMMLMMMMM","5 5 N", true),
                Arguments.of("MMLMMR", "3 5 N", true),
                Arguments.of("MMMMMMMLMMMMM", "1 5 W", true),
                Arguments.of("MLLMMR", "3 5 S", true),
                Arguments.of("MMLRMMRMM", "1 1 W", true)
        );
    }

    // @Ignore
    //@After
    @ParameterizedTest
    @MethodSource("parametersGenerator2")
    public void should_ContinuedMove_NextCommands(String prmCommand, String prmExpected, Boolean prmIsTrue) {

        System.out.println(roverKeep.getCommands() + "---Rover NEXT Move: " + roverKeep.getCoordinates());
        System.out.printf(prmCommand + " " + roverKeep.getRoverObstacle().getObstaclesList() + " ALL OBSTACLES %s\n", obstacleKeep2.getObstaclesList());
        roverKeep.setCommands(prmCommand);
        String resultPosition = roverKeep.commandsMove();

        Assert.assertEquals(resultPosition.contentEquals(prmExpected), prmIsTrue);
    }
}

