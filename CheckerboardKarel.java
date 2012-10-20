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
		while (frontIsClear()) {
			rowEast();
/*			rowWest();*/
/*			changeRow();*/
		}
/*		teste();
*/		
			}


	private void rowEast() {
		while (facingEast()) {
			/*if (frontIsClear()) {*/
				move();
				if (frontIsClear()) {
					move();
					putBeeper();
				}
			}
		}
		/*changeRowEast();*/
		turnLeft();

	}


	private void changeRowEast() {
		if (beepersPresent()) {
			turnLeft();
			if (frontIsClear()) {
				move();
				turnLeft();
			}
		} else {
			turnLeft();
			if(frontIsClear()) {
				move();
				putBeeper();
				turnLeft();
			}
		}
	}
		
	


/*	private void teste() {
		if (leftIsClear()) {
			turnLeft();
			move();
			putBeeper();
		} else {
			if (rightIsClear()) {
				turnRight();
				move();
				putBeeper();
			} else {
				turnAround();
				move();
				putBeeper();
			}
		}
	}
*/

	
}