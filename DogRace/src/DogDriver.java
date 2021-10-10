import java.util.Scanner;

public class DogDriver {
	public static void main(String[] args) {
		System.out.println("Enter the size of the track (an int greater than 3):");
		Scanner scanner = new Scanner(System.in);
		int trackSize = scanner.nextInt();
		System.out.println("Track Size: " + trackSize);
		DogTrack dogTrack = new DogTrack(trackSize);
		dogTrack.playGame();
	}
}