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
	while (confirmProceed()) {
		putNext();
	}
}


private boolean confirmProceed() {
	if (facingEast()) {
		leftIsBlocked();
	} else {
		rightIsBlocked();
	}
	return false;
}


private void putNext() {
	if (frontIsClear()) {
		move();
		if (frontIsClear()) {
			move();
			putBeeper();
		} else {
			turnPut();
		}
	} else {
		turnMovePut();
		}
	}


private void turnMovePut() {
	if (facingEast()) {
		turnLeft();
		if (frontIsClear()) {
			move();
			if (leftIsClear()) {
			turnLeft();
			move();
			} else {
			move();
			turnRight();
			}
		}
		putBeeper();
		
	} else {
		turnRight();
		if (frontIsClear()) {
			move();
			if (rightIsClear()) {
			turnRight();
			move();
			} else {
			move();
			turnLeft();
			}
		}
		putBeeper();
		}
	
}


private void turnPut() {
	if (facingEast()) {
		turnLeft();
		if (frontIsClear()){
			move();
			turnLeft();
			putBeeper();
		}
	} else {
			turnRight();
			if (frontIsClear()) {
				move();
				turnRight();
				putBeeper();
			}
		}
}
	

}