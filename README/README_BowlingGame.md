<b>Bowling Game Kata</b><br>

Implementation: <br>
Modeling of class structure represented by UML and related testing constraints that will continue to be developed by the Test Driven Development approach - Red-Green-Refactor.
<br><br>
<b>Definitions and restrictions:</b><br><br>
The game consists of 10 frames.  In each frame the player has two opportunities for rolls to knock down 10 pins.  The number of rolls per frame may vary depending on the spare and strike cases in that frame.<br>
The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares, if any.<br>
A spare(/) is when the player knocks down all 10 pins in two tries(2 rolls).  The bonus for that frame is the number of pins knocked down by the next first roll.  <br>
A strike(X) is when the player knocks down all 10 pins on his first try (1 roll).  The bonus for that frame is the value of the next two rolles.<br>
Extreme case for the tenth frame: a player who rolls a spare or strike is allowed to roll the extra ONE ball(max. 3 rolls) to complete the frame.  However no more than three balls can be rolled in tenth frame.

<img width="50%" height="50%" src="https://user-images.githubusercontent.com/95845154/153743987-5abd01e3-e106-4dba-b03f-4358af0de30b.png">
