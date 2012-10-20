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
	doRow();
	while (confirmProceed()) {
	proceedNext();
	}
}


private boolean confirmProceed() {
	if (facingEast()) {
		leftIsClear();
	} else {
		rightIsClear();
	}
	return true;
}


private void doRow() {
	while (frontIsClear()) {
		if (facingEast()) {
			putBeeper();
			move();
			move();
		} else {
			move();
			putBeeper();
			move();
		}
	}
}

private void proceedNext() {
	if (facingEast()) {
		if (leftIsClear()) {
			turnLeft();
			move();
			turnLeft();
			doRow();
		}
	} else {
		if (rightIsClear()) {
			turnRight();
			move();
			turnRight();
			doRow();
		}	
	}	
}
}