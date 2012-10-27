/*
 * File: DefendingDemocracyKarel.java
 * -------------------------------
 * When you finish writing it, the DefendingDemocracyKarel should
 * confirm a ballot and clean all the chads from the areas of the
 * ballots where people want to cast a vote. For it to happen,
 * Karel has to cross the whole ballot. In each
 * space, if the middle section doesn't have a beeper that means
 * the voter wanted to cast a vote on that section. Hence Karel
 * must check the adjacent squares and make sure the ballot can be 
 * counted correctly. If there is a beeper there, the voter did not 
 * want to cast a vote on this area and Karel must leave it as it is.
 */

import stanford.karel.*;

public class DefendingDemocracyKarel extends SuperKarel {
	public void run() {
		while (frontIsClear()) {
			move();
			checkRectangle();
			move();
		}
	}

	/*
	 * pre-condition: Karel is facing East in the middle square of the rectangle
	 * post-condition: Karel is where he began checkRectangle
	 */
	private void checkRectangle() {
		if (noBeepersPresent()) {
			checkUp();
			checkDown();
		}
	/*
	 * pre-condition: Karel is facing East in the middle square of the rectangle
	 * post-condition: Karel is where he began checkDown	
	 */
	}
	private void checkDown() {
		turnRight();
		move();
		checkSquare();
		turnAround();
		move();
		turnRight();
	}


	/*
	 * pre-condition: Karel is facing East in the middle square of the rectangle
	 * post-condition: Karel is where he began checkUp
	 */
	private void checkUp() {
		turnLeft();
		move();
		checkSquare();
		turnAround();
		move();
		turnLeft();
	}

	/*
	 * confirms if there is a beeper / chad in the square
	 * and if there is, cleans it
	 */
	private void checkSquare() {
		while (beepersPresent()) {
			pickBeeper();
		}
	}
	
}
