package BowlingGameTest;

import BowlingGame.Bowling;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class BowlingGameTest {

    private Bowling game = new Bowling();
    private Bowling mockGame;
   // private int[] knockedDownPins = new int[21];

    @BeforeEach
    public void setup() {
        game = new Bowling();
        mockGame = mock(Bowling.class);
    }
/*
    //@Test
    @ParameterizedTest
    @ValueSource(ints = {7,2,8,1,10,5,5,8,1,10,7,2})
    @Ignore
    public void should_knocksDifferentPins(int knocked) {
        //Act
        game.roll(knocked);

        //mock
        /*
        when(mockGame.roll(any(Integer.class))).thenCallRealMethod();
        mockGame.roll(knocked);

        verify(mockGame, times(1)).score();
         */
        //assertEquals(game.score(),133);
    //}*/

    @Test
    public void should_calculateFinalScore_when_itsLastFrameSpareORStrake() {
        //Act
        game.roll(1);
        game.roll(4);
        game.roll(4);
        game.roll(5);
        game.roll(6);
        game.roll(4);
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(0);
        game.roll(1);
        game.roll(7);
        game.roll(3);
        game.roll(6);
        game.roll(4);
        game.roll(10);
        game.roll(10); //last frame STRIKE
        //last frame SPARE
        //game.roll(2);
        //game.roll(8);
        game.roll(6);

        //assert
        assertEquals(game.score(),133);
    }

    @Test
    public void should_calculateFinalScore_when_itsSpareAfterStrike() {

        game.roll(2);
        game.roll(7);
        game.roll(10);
        game.roll(5);
        game.roll(5);
        game.roll(6);
        game.roll(1);
        assertEquals(game.score(),52);
    }
    @Test
    public void should_calculateFinalScore_when_itsStrikeAfterSpare() {

        game.roll(2);
        game.roll(7);
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(6);
        game.roll(1);
        assertEquals(game.score(),53);
    }

    @Test
    public void should_calculateFinalScore_when_itsTimeForStrike() {

        game.roll(2);
        game.roll(7);
        game.roll(10);
        game.roll(3);
        game.roll(5);
        assertEquals(game.score(),35);
    }

    @Test
    public void should_calculateFinalScore_when_spareAfterSpare() {

        game.roll(8);
        game.roll(2);
        game.roll(7);
        game.roll(3);
        game.roll(5);
        game.roll(0);
        assertEquals(game.score(),37);
    }

}