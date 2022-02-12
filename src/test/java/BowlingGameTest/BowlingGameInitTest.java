package BowlingGameTest;

import BowlingGame.Bowling;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;

public class BowlingGameInitTest {

    private Bowling game;//= new Bowling();

    @BeforeEach
    public void setup() {
        game = new Bowling();
    }

    @Test
    public void should_Test_MaxRollsConstrains() {
        //Act
        int result= game.getRolls().length;

        //assert
        assertEquals(21,result);
    }

    @Test
    public void should_Test_KnockedDownPinsInFrameConstrains() {
        //Act
        game.roll(2);
        game.roll(9);
        int isTrueResult= game.sumKnockedDownPinsInFrame(0);

        //assert
        assertEquals(10,isTrueResult);
    }

    @Test
    public void should_Test_isStrike() {
        //Act
        game.roll(2);
        game.roll(8);
        Boolean isTrueResult= game.isStrike(0);

        //assert
        assertEquals(true,isTrueResult);
    }

    @Test
    public void should_Test_isSpare() {
        //Act
        game.roll(10);
        Boolean isTrueResult= game.isSpare(0);

        //assert
        assertEquals(true,isTrueResult);
    }

       @Test
    public void should_calculateFinalScore_when_ZeroRolls() {

        game.roll(0);
        game.roll(0);
        game.roll(0);
        assertEquals(game.score(),0);
    }

}