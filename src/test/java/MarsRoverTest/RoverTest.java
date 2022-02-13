package MarsRoverTest;

import MarsRover.*;
import org.junit.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RoverTest {
    //#region Variables
    String resultPosition = "";

    Obstacle roverObstacle = new Obstacle();
    private static Obstacle obstacleKeep2 = new Obstacle();
    static Obstacle obstacleKeep = new Obstacle();

    private Rover rover;
    private static Rover roverKeep;
    //#endregion
    @Before
    public void beforeTest() {
         roverKeep = new Rover(new Coordinates(3, 3, 5, 5, Direction.NORTH), "", obstacleKeep2);
    }
    //#region RoversSection
    private static Stream<Arguments> parametersGenerator() {
        return Stream.of(
                Arguments.of(new Coordinates(1, 1, 5, 5, Direction.WEST),
                        "MMRMMRMMMLMMMLMMMMM", "1 5 W", true),
                Arguments.of(new Coordinates(2, 2, 10, 10, Direction.NORTH),
                        "MMRMMLMMML", "4 7 W", true),
                Arguments.of(new Coordinates(1, 2, 5, 10, Direction.SOUTH),
                        "MLLMMMMMMM", "1 8 N", true),
                Arguments.of(new Coordinates(3, 3, 10, 5, Direction.EAST),
                        "MMRLLMMRRLMRLRM", "6 4 S", true),
                Arguments.of(new Coordinates(2, 2, Direction.NORTH),
                        "MMLRMMLRMMMR", "2 9 E", true)
        );
    }
    //@Ignore
    @ParameterizedTest
    @MethodSource("parametersGenerator")
    public void should_Move_SingleRover_Cases(Coordinates prmCoordinates, String prmCommand, String prmExpected, Boolean prmIsTrue) {
        rover = new Rover(prmCoordinates, prmCommand, roverObstacle);
        resultPosition = rover.commandsMove();
        Assert.assertEquals(resultPosition.contentEquals(prmExpected), prmIsTrue);
    }
    //@Ignore
    @ParameterizedTest
    @MethodSource("parametersGenerator")
    public void should_Move_AllRoversSequentially(Coordinates prmCoordinates, String prmCommand, String prmExpected, Boolean prmIsTrue) {
        rover = new Rover(prmCoordinates, prmCommand, obstacleKeep);
        resultPosition = rover.commandsMove();
        Assert.assertEquals(resultPosition.contentEquals(prmExpected), prmIsTrue);
    }
    //#endregion
    //#region CommandsSection
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
    @ParameterizedTest
    @MethodSource("parametersGenerator2")
    public void should_RoverContinuedMove_NextCommandSet(String prmCommand, String prmExpected, Boolean prmIsTrue) {
        roverKeep.setCommands(prmCommand);
        String resultPosition = roverKeep.commandsMove();
        Assert.assertEquals(resultPosition.contentEquals(prmExpected), prmIsTrue);
    }
    //#endregion
}

