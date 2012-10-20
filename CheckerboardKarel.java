/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		putBeeper();
		checkColumn();
		while (frontIsClear()) {
		fillRowEast();
		fillRowWest();
		}
	}

	private void checkColumn() {
		if (frontIsBlocked()) {
			turnLeft();
			while (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
					putBeeper();
				}
			}
		}
		
	}

	private void fillRowEast() {
		while (facingEast()) {
			if (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
					putBeeper();
				}
			}
		changeEast();
		}
	}
	
	private void fillRowWest () {	
		while (facingWest()) {
			if (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
					putBeeper();
				}
			}
		changeWest();
		}
	}

	private void changeWest() {
		if (frontIsBlocked()) {
			turnRight();
			if (noBeepersPresent()) {
				move();
				putBeeper();
				turnRight();
			} else {
				move();
				turnRight();
			}
		}	
		
	}

	private void changeEast() {
		if (frontIsBlocked()) {
			turnLeft();
			if (noBeepersPresent()) {
				move();
				putBeeper();
				turnLeft();
			} else {
				move();
				turnLeft();
			}
		}		
	}
	
	
}