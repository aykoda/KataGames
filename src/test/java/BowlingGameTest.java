

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    //@Test
    @ParameterizedTest
    @ValueSource(ints = {7,2,8,1,10,5,5,8,1,10,7,2})
    public void should_knocksDifferentPins(int knocked) {
        //Act
        game.roll(knocked);

        //mock
        /*
        when(mockGame.roll(any(Integer.class))).thenCallRealMethod();
        mockGame.roll(knocked);

        verify(mockGame, times(1)).score();
         */
    }

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

  /*  @Ignore
        @Test
       public void should_calculateScoreForAllZeros() {
            Game game = createNewGame();
            rollFor20(game, 0);
            //assertThat(game.score()).isEqualTo(0);
            assertEquals(game.score(),0);
        }

        @Test
        void should_calculate20_when_allRolls1() {
            Game game = createNewGame();
            rollFor20(game, 1);
            assertThat(game.score()).isEqualTo(20);
        }

        @Test
        void should_calculate80_when_allRolls4() {
            Game game = createNewGame();
            rollFor20(game, 4);
            assertThat(game.score()).isEqualTo(80);
        }

        @Test
        void should_calculateFinalScore_when_knocksDifferentPins() {
            Game game = createNewGame();
            game.roll(5);
            game.roll(5);
            game.roll(2);
            assertThat(game.score()).isEqualTo(14);
        }



        @Test
        void should_calculateFinalScore_when_spareAfterSpare() {
            Game game = createNewGame();
            game.roll(8);
            game.roll(2);
            game.roll(7);
            game.roll(3);
            game.roll(5);
            assertThat(game.score()).isEqualTo(37);
        }

        @Test
        void should_calculateFinalScore_when_itsTimeForStrike() {
            Game game = createNewGame();
            game.roll(10);
            game.roll(2);
            game.roll(7);
            game.roll(3);
            game.roll(5);
            assertThat(game.score()).isEqualTo(36);
        }

        @Test
        void should_calculateFinalScore_when_itsTimeForStrike2() {
            Game game = createNewGame();
            game.roll(2);
            game.roll(7);
            game.roll(10);
            game.roll(3);
            game.roll(5);
            assertThat(game.score()).isEqualTo(35);
        }

        @Test
        void should_calculateScoreOfSecondFrame_when_itsTimeForStrike() {
            Game game = createNewGame();
            game.roll(2);
            game.roll(7);
            game.roll(10);
            assertThat(game.getFrame(2).score()).isEqualTo(null);
        }

        @Test
        void should_calculateScoreOfSecondFrame_when_itsTimeForStrike2() {
            Game game = createNewGame();
            game.roll(2);
            game.roll(7);
            game.roll(10);
            game.roll(3);
            assertThat(game.getFrame(2).score()).isEqualTo(null);
        }

        @Test
        void should_calculateScoreOfSecondFrame_when_itsTimeForStrike3() {
            Game game = createNewGame();
            game.roll(2);
            game.roll(7);
            game.roll(10);
            game.roll(3);
            game.roll(5);
            assertThat(game.getFrame(2).score()).isEqualTo(18);
        }

 */

       /* private Game createNewGame() {
            return new Game();
        }

        private void rollFor20(Game game, int i2) {
            for (int i = 0; i < 20; i++) {
                game.roll(i2);
            }
        }*/
    }