/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run(){
		repairColumn();
		while (frontIsClear()) {
			moveToNext();
			repairColumn();
		}
	}
	
	private void repairColumn() {
		turnLeft();
		repairStone();
		while (frontIsClear()){
			move();
			repairStone();
		}
		turnAround();
		goBack();
		turnLeft();
	}
	
	private void moveToNext() {
		for (int i=0; i<4; i++)
			move();
	}
	
	private void repairStone() {
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
	private void goBack() {
		while (frontIsClear()) {
			move();
		}
	}
}
