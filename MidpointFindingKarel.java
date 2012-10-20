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
			crossOdd();
		} else {
			crossEven();
		}
		cleanBoard();
		finish();
	}

	private void finish() {
		while (noBeepersPresent()) {
			if (frontIsClear()) {
				move();
				if (beepersPresent()) {
					pickBeeper();
					/*goSouth();*/
				}
			}
			nextRow();	
		}
		
	}

	private void cleanBoard() {
		if (beepersPresent()) {
			pickBeeper();
		}
		while (frontIsClear()) {
			if (frontIsClear()) {
				move();
				if (beepersPresent()) {
					pickBeeper();
				}
			}
			nextRow();	
		}
		if (facingEast()) {
			turnAround();
		}
		if (facingSouth()) {
			turnRight();
		}
		if (facingNorth()) {
			turnRight();
		}
		if (facingWest()) {
			turnAround();
		}
	}

	private void nextRow() {
		if (frontIsBlocked()) {
			if (facingEast()) {
				turnLeft();
				if (frontIsClear()) {
					move();
					turnLeft();
					if (beepersPresent()) {
						pickBeeper();
					}
				}
			} else {
				turnRight();
				if (frontIsClear()) {
					move();
					turnRight();
					if (beepersPresent()) {
						pickBeeper();
					}
				}
			}
		}
		
	}

	/*
	 * Se o numero de casas for par, este método cria uma cruz
	 * com dois beepers numa das casas centrais
	 * termina com o Karel na casa 1-1 facing East
	 */
	private void crossEven() {
		cleanRow();
		putBeeper();
		while (frontIsClear()) {
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
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
		move();
		putBeeper();
		while (frontIsClear()) {
			if (frontIsClear()) {
				move();
				turnRight();
				if (frontIsClear()) {
					move();
					putBeeper();
					turnLeft();
				}
			}
		}
		turnRight();
		if (frontIsClear()) {
			move();
		}
		turnRight();
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
		


	/*
	 * Se o numero de casas for impar, este método cria uma cruz
	 * com dois beepers no centro
	 * termina com o Karel na casa 1-1 facing East
	 */
	private void crossOdd() {
		cleanRow();
		putBeeper();
		while (frontIsClear()) {
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
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
		putBeeper();
		while (frontIsClear()) {
			if (frontIsClear()) {
				move();
				turnRight();
				if (frontIsClear()) {
					move();
					putBeeper();
					turnLeft();
				}
			}
		}
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
	
	/*
	 * a função de cleanRow serve para limpar a primeira linha novamente.
	 * no final o Karel tem que ficar novamente na casa 1-1
	 * virado para East, e todas as casas novamente vazias de beepers
	 */
	private void cleanRow() {
		turnAround();
		if (beepersPresent()) {
			pickBeeper();
		}
		while (frontIsClear()) {
			move();
			if (beepersPresent()) {
				pickBeeper();
			}
		}
		turnAround();
	}



/*
 * esta função apenas serve para confirmar se é par ou ímpar
 * uma vez que as formas de actuação são ligeiramente diferentes
 * num caso e noutro
 * No final deste método o Karel está no canto East da rua 1, virado para East
 */
	private void checkOdd() {	
		while (frontIsClear()) {
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
