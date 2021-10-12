
/**
 * @author sagesilberman
 *
 */
public class DogTrack {

	private int trackSize; // describes the track size
	private int positionRover; // position of Rover
	private int positionSpot; // position of Spot
	private int positionFido; // position of Fido
	String trackDivider = ""; // builds track divider
	String track = ""; // builds track

	/**
	 * Constructs a DogTrack with a track size
	 * 
	 * @param ts the track size
	 */
	public DogTrack(int ts) {
		trackSize = ts;

	}

	/**
	 * Initializes the game by setting the variables to a starting point of 0
	 */
	private void initializeGame() {
		positionRover = 0;
		positionSpot = 0;
		positionFido = 0;
		for (int d = 0; d < trackSize; d++) {
			trackDivider += "-";
		}
	}

	/**
	 * Initializes the order the game will run
	 */
	public void playGame() {
		initializeGame();
		while (isOver() == false) {
			showTrack();
			moveDogs();
		}
		showWinners();
		isOver();
	}

	/**
	 * Returns <code>true</code> if the position of one of the dogs on 1 spot less
	 * than the track size
	 * 
	 * @return <code>true</code> if the position of one of the dogs on 1 spot less
	 *         than the track size; <code>false</code> otherwise isOver is false
	 * 
	 */
	private boolean isOver() {
		if (positionRover == trackSize - 1) {
			return true;
		} else if (positionFido == trackSize - 1) {
			return true;
		} else if (positionSpot == trackSize - 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns a single random number between 1 and 5
	 * 
	 * @return random number between 1 and 5
	 */
	private int spin() {
		double num = Math.random();
		if (num <= .2) {
			return (1);
		} else if (num <= .4) {
			return (2);
		} else if (num <= .6) {
			return (3);
		} else if (num <= .8) {
			return (4);
		} else {
			return (5);
		}

	}

	/**
	 * Simulates a round of DogTrack
	 */
	private void moveDogs() {
		moveRover();
		moveFido();
		moveSpot();
	}

	/**
	 * Simulates the movement of DogTrack for Rover
	 */
	private void moveRover() {
		positionRover = (positionRover + spin());
		if (positionRover >= 0) {
			if (positionRover == trackSize / 3) {
				positionRover = positionRover - spin();
			}

			else if (positionRover == 2 * trackSize / 3) {
				positionRover = positionRover - spin();
			}
		}
		while (positionSpot >= trackSize) {
			positionSpot = trackSize - 1;
		}
	}

	/**
	 * Simulates the movement of DogTrack for Fido
	 */
	private void moveFido() {
		positionFido = (positionFido + spin());
		if (positionFido >= 0) {
			if (positionFido == trackSize / 3) {
				positionFido = positionFido - spin();
			}

			else if (positionFido == 2 * trackSize / 3) {
				positionFido = positionFido - spin();
			}
		}
		while (positionFido >= trackSize) {
			positionFido = trackSize - 1;
		}

	}

	/**
	 * Simulates the movement of DogTrack for Spot
	 */
	private void moveSpot() {
		positionSpot = (positionSpot + spin());
		if (positionSpot >= 0) {
			if (positionSpot == trackSize / 3) {
				positionSpot = positionSpot - spin();
			}

			else if (positionSpot == 2 * trackSize / 3) {
				positionSpot = positionSpot - spin();
			}
		}
		while (positionSpot >= trackSize) {
			positionSpot = trackSize - 1;
		}

	}

	/**
	 * Prints out the position of player on the track for every move and divides the
	 * track per each round
	 */
	private void showTrack() {
		for (int i = 0; i < trackSize; i++) {
			if (i == positionRover) {
				track += "R";
			} else {
				track += "o";
			}
		}
		track += "\n";

		for (int i1 = 0; i1 < trackSize; i1++) {
			if (i1 == positionFido) {
				track += "F";
			} else {
				track += "o";
			}
		}
		track += "\n";

		for (int i2 = 0; i2 < trackSize; i2++) {
			if (i2 == positionSpot) {
				track += "S";
			} else {
				track += "o";
			}
		}
		System.out.println(track);
		track = "";
		System.out.println(trackDivider);

	}

	/**
	 * Prints out who wins and the track according to movements and rounds played
	 */
	public void showWinners() {
		if (positionRover >= trackSize) {
			positionRover = trackSize - 1;
		}
		if (positionSpot >= trackSize) {
			positionSpot = trackSize - 1;
		}
		if (positionFido >= trackSize) {
			positionFido = trackSize - 1;
		}
		showTrack();

		if (positionSpot >= trackSize - 1)
			System.out.println("Spot Wins!");
		if (positionRover >= trackSize - 1)
			System.out.println("Rover Wins!");
		if (positionFido >= trackSize - 1)
			System.out.println("Fido Wins!");
	}
}
