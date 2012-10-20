/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		putBeeper();
		while (confirmProceed()) {
			putNext();
		}
		comeBack();
	}


	private void comeBack() {
		turnRight();
		while (frontIsClear()) {
			move();
		}
		
	}


	private boolean confirmProceed() {

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
