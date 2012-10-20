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
		checkOdd();
		if (beepersPresent()) {
			doOdd();
		} /*else {
			doEven();
		}*/
	}

	private void doOdd() {
		cleanRow();
		
		while (frontIsClear()) {
			putBeeper();
			if (frontIsClear()) {
				move();
				turnLeft();
				if (frontIsClear()) {
					move();
					putBeeper();
					turnRight();
				}
			}
		}
		turnLeft();
		while (frontIsClear()) {
			move();
		}
		}
	
	/*
	 * a fun��o de cleanRow serve para limpar a primeira linha novamente.
	 * no final o Karel tem que ficar novamente na casa 1-1
	 * virado para East, e todas as casas novamente vazias de beepers
	 */
	private void cleanRow() {
		turnAround();
		while (frontIsClear()) {
			move();
			if (beepersPresent()) {
				pickBeeper();
			}
		}
		turnAround();
	}



/*
 * esta fun��o apenas serve para confirmar se � par ou �mpar
 * uma vez que as formas de actua��o s�o ligeiramente diferentes
 * num caso e noutro
 * No final deste m�todo o Karel est� no canto East da rua 1, virado para East
 */
	private void checkOdd() {	
		while (facingEast()) {
			if (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
					putBeeper();
				}
			}
		}
	}

}
