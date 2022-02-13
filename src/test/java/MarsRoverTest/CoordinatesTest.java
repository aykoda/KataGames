package MarsRoverTest;

import MarsRover.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CoordinatesTest {
    //#region VariablesDefinition
    private  int x;
    private static int moveX,moveY;
    private Coordinates surface = new Coordinates(2,3,Direction.EAST);
    private static Coordinates surfaceKeep;
    //#endregion
    @Before
    public void beforeTest() {
        surfaceKeep = new Coordinates(5,5,Direction.EAST);
        moveX = surfaceKeep.getX();
        moveY = surfaceKeep.getY();
    }
    //#region InitTestSection
    @Test
    public void should_ChangeDirectionLeft() {
        surface.changeDirectionLeft();
        Assert.assertEquals(Direction.NORTH, surface.getDirection());
    }
    @Test
    public void should_ChangeDirectionRight() {
        surface.changeDirectionRight();
        Assert.assertEquals(Direction.SOUTH, surface.getDirection());
    }
    @Test
    public void should_calculateCoordinates() {
        x =  surface.getX();
        surface.calculateCoordinates();
        Assert.assertEquals(surface.getX(), x+1);
    }

    //#endregion
    //#region DirectionsChanges
    private static Stream<Arguments> parametersTurnLeft() {
        return Stream.of(
                Arguments.of(Direction.NORTH, true),
                Arguments.of(Direction.WEST, true),
                Arguments.of(Direction.SOUTH, true),
                Arguments.of(Direction.EAST, true)
        );
    }
    //@Ignore
    @ParameterizedTest
    @MethodSource("parametersTurnLeft")
    public void shouldTest_AllDirections_TurnLeft(Direction prmDirection, Boolean prmIsTrue) {
        // turn to left 360 degree
        surfaceKeep.changeDirectionLeft();
        Assert.assertEquals(prmDirection,surfaceKeep.getDirection());
    }
    private static Stream<Arguments> parametersTurnRight() {
        return Stream.of(
                Arguments.of(Direction.SOUTH, true),
                Arguments.of(Direction.WEST, true),
                Arguments.of(Direction.NORTH, true),
                Arguments.of(Direction.EAST, true)
        );
    }
    //@Ignore
    @ParameterizedTest
    @MethodSource("parametersTurnRight")
    public void shouldTest_AllDirections_TurnRight(Direction prmDirection, Boolean prmIsTrue) {
        // turn to right 360 degree
        surfaceKeep.changeDirectionRight();
        Assert.assertEquals(prmDirection,surfaceKeep.getDirection());
    }
    //#endregion
    //#region MoveDetermination
    private static Stream<Arguments> parametersMove() {
        return Stream.of(
                Arguments.of(Direction.SOUTH, moveX, moveY-=1),
                Arguments.of(Direction.WEST, moveX-=1, moveY),
                Arguments.of(Direction.NORTH, moveX, moveY+=1),
                Arguments.of(Direction.EAST, moveX+=1, moveY)
        );
    }
    // @Ignore
    @ParameterizedTest
    @MethodSource("parametersMove")
    public void shouldCalculate_Coordinates_ByEachDirection(Direction prmDirection, int prmX, int prmY) {
        // calculate X and Y. By turn to right 360 degree it is tests each Direction's coordinates
        surfaceKeep.changeDirectionRight();
        surfaceKeep.calculateCoordinates();
        Assert.assertEquals(surfaceKeep.getX(), prmX);
        Assert.assertEquals(surfaceKeep.getY(), prmY);
    }
    //#endregion
}

