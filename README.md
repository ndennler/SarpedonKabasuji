# SarpedonKabasuji

SETUP

To run this application:
* first install the latest version of eclipse for java for your operating system (https://www.eclipse.org/downloads/)
* clone this repository to a known location
* in eclipse, select File>import...
* select general>Existing Projects into Workspace
* for root directory, choose the folder that was cloned
* to play the game, run the file src/Main/PlayerApplication.java
* to build levels, run src/Main/BuilderApplication.java

SARPEDON KABASUJI

Builder Interface:

The builder allows you to create new levels, or edit pre-existing levels

Save will allow one to save a given level under a given Name 
DO NOT USE NAMES "LEVEL1" "LEVEL2" etc. will overwrite stored levels

Left Click undo button for undo, right click it to redo
NUMBER OF MOVES and TIME REMAINING CANNOT BE UNDONE

When entering values for number of moves and time remaining PRESS ENTER to store the value
The board size is given in number of squares on the board divided by six (this represents the number of game pieces that can fit on the board since each piece consists of 6 squares)

Clicking on a piece in the stock will add it to the bullpen
dragging a piece over the stock and clicking in white space in the stock will release it

Use the Radio buttons to pick desired action
Move Tiles -> Allows moving tiles on board to shape the board as desired. (Pieces cannot be moved with this selected)
Move Pieces -> Allows placing and removing pieces from the board and bullpen
Add Hint -> Allows adding a hint by dragging a piece over the board and clicking in the desired location.
Add Number -> allows the adding of a desired number in a desired color (selected using the combo box) to a tile by
				clicking on it. CHOOSE NUMBER 0 to remove a number from a space.
				
Player Interface: 
	WARNING: NEW GAME RESETS THE GAME and loads the first level
	Level Select allows one to enter a desired level from the current game
	
	In Game
	-Move pieces by clicking and dragging them
	-While holding a piece, click rotate or flip to rotate or flip the piece
	-The Star count, moves left, and time left update as the player progresses through the level
	-A screen will pop up with when a level ends (either completed or failed)
	-Press the return to menu button on this pop up to return to menu 
	IN SOME COMPUTERS THE WINDOW WILL NOT BE LARGE ENOUGH TO SEE THE RETURN TO MENU BUTTON 
	SCROLL OR EXPAND THE WINDOW DOWN TO SEE IT
	
	FOR RELEASE (also functions for other levels) if you wish to give up
	 hit the return to menu button this will save the amount of stars you have on a level
	 That is all.