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
			putNext();
		}
		if (leftIsClear()) {
			turnLeft();
			move();
			putBeeper();
		} else {
			if (rightIsClear()) {
				turnRight();
				move();
				putBeeper();

			}
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
			if (leftIsClear()) {
				turnLeft();
				move();
				if (leftIsClear()) {
				turnLeft();
				move();
				putBeeper();
				} else {
					if (frontIsClear()) {
						move();
						turnRight();
						putBeeper();
					}
				}
			}
			
		} else {
			if (rightIsClear()) {
				turnRight();
				move();
				if (rightIsClear()) {
				turnRight();
				move();
				putBeeper();
				}
			} else {
				if (frontIsClear()) {
				move();
				turnLeft();
				}
			}
		}

		
	}


	private void turnPut() {
		if (facingEast()) {
			if (leftIsClear()){
				turnLeft();
				move();
				turnLeft();
				putBeeper();
			}
		} else {
			if (rightIsClear()) {
				turnRight();
				move();
				turnRight();
				putBeeper();
				}
			}
	}
		

	}