# KataGames
<b>Mars Rover Kata</b><br>

Definitions and restrictions of the game:<br>
• Define a Obstacle's Fixed-point (X,Y) and Direction (C-centered) <br>
• Define the direction a Rover is facing (N,S,E,W) and starting points (X,Y)<br>
• Define each Rover's MAX movement coordinates:<br>
  o by defining these, the coordinates limit of the movement is realized<br>
  o by defining different MAX values for each Rover, the positions of all Rover Square movement will be placed in the Circle location<br>
  o as undefined, unlimited Circle motion position is represented<br>
• Identify valid aspects of the rover:<br>
  o North: the rover faces the top of the screen (Λ).<br>
  o East: rover looks right ( >)<br>
  o South: rover looks down (V)<br>
  o West: rover faces left (<)<br>
• Identifying character commands performed by each of the rover<br>
  o execution of commands that move the rover forward (M)<br>
  o execution of commands that turn the rover left/right (Left/Right).<br>
• Wrapping from one edge of the grid to the other, executing all commands in one iteration. It is possible to perform repeated command of different sequences to simulate continuous motion<br>
• Applying obstacle detection to the next coordinates before each move. If it encounters an obstacle in an executing command, the rover will move to the last possible point and report the obstacle coordinates.<br>

 <img width="50%" height="50%" src="https://user-images.githubusercontent.com/95845154/152498799-d3d62384-c1c5-41de-b51f-86f52d58f0bb.png">


