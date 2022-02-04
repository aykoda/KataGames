# KataGames
Mars Rover Kata

Definitions and restrictions of the game:\n
• Define a Obstacle's Fixed-point (X,Y) and Direction (C-centered) 
• Define the direction a Rover is facing (N,S,E,W) and starting points (X,Y)
• Define each Rover's MAX movement coordinates:
  o by defining these, the coordinates limit of the movement is realized
  o by defining different MAX values for each Rover, the positions of all Rover Square movement will be placed in the Circle location
  o as undefined, unlimited Circle motion position is represented
• Identify valid aspects of the rover:
  o North: the rover faces the top of the screen (Λ).
  o East: rover looks right ( >)
  o South: rover looks down (V)
  o West: rover faces left (<)
• Identifying character commands performed by each of the rover
  o execution of commands that move the rover forward (M)
  o execution of commands that turn the rover left/right (Left/Right).
• Wrapping from one edge of the grid to the other, executing all commands in one iteration. It is possible to perform repeated command of different sequences to simulate continuous motion
• Applying obstacle detection to the next coordinates before each move. If it encounters an obstacle in an executing command, the rover will move to the last possible point and report the obstacle coordinates.
