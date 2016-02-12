import java.util.Scanner;

/**
 * 
 */

/**
 * @author Harley Quinn Purpose: Create an application that accepts user input
 *         of at-bat results for a group of baseball/softball players and calculates
 *         batting average and slugging percentage for each player.
 *
 */
public class Quinn_Hamilton_lab8 {

	/**
	 * 
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Batting Average and Slugging Percentage Calculator!");
		System.out.println();
		String contin = "y";

		while (contin.equalsIgnoreCase("Y")) { // as long as the user chooses y or Y when asked to continue, this while loop will start again
			
			// this section asks the user to enter the number of batters they'd like stats for 
			System.out.println("Enter the number of batters you'd like statistics calculated for: ");
			int noOfPlayers = getValidInteger(scanner); // checks to make sure input is an integer using the getValidInteger method
			int[][] stats = new int[noOfPlayers][];
			int atBats = 0;
			
			// this loop asks a user for each batter's number of at bats, stores that info as rows in an array [atBats]
			for (int row = 0; row < noOfPlayers; row++) {
				System.out.println("Enter number of times at bat for Batter " + row + ": ");
				atBats = getValidInteger(scanner);		//checks to make sure user input is an integer using the getValidInteger method
				stats[row] = new int[atBats];
			}
			int row = 0;
			int bCount = 0;
			int sum = 0;
			double battingAverage = 0.000;
			double sluggingPercentage = 0.000;
			
			// this for loop with a nested for loop collects user input for the results of each batter's at bat and stores that information in columns in our 2D array
			// this also checks to make sure user input is not only an integer but also makes sure that integer is between 0 and 4
			// a key for at bat result choices is also printed on the console to help the user
			for (row = 0; row < noOfPlayers; row++) {
				
				// this results the sum and counter each time the for loop repeats for each batter
				sum = 0;
				bCount = 0;

				System.out.println("Key for Batter " + row + " --> 0=out, 1=single, 2=double, 3=triple, 4=home run");
				
				// this inner for loop collects user input for at bat results and stores that info in columns in the array created above
				for (int column = 0; column < stats[row].length; column++) {

					System.out.println("Result for at-bat " + column + ": ");
					stats[row][column] = getValidIntegerInRange(0,4,scanner); 	//here the getValidIntegerInRange method is called to make sure user input is between 0 and 4
					sum = sum + stats[row][column]; 							//the sum of each batter's earned bases is calculated here
					if (stats[row][column] > 0) {
						bCount++;												//the number of non-zero at bats (or at bats when the batter didn't go out) is counted here
					}
				}
				// batting average is then calculated for each batter here and printed to the console
				// batting average is also limited to 3 decimal places when calculated
				battingAverage = (double) bCount / (double) stats[row].length;	

				System.out.println("Batter " + row + " Batting Average: ");		
				System.out.printf("%.3f", battingAverage);
				System.out.println();

				// slugging percentage is then calculated for each batter here and printed to the console
				// slugging percentage is also limited to 3 decimal places when calculated
				sluggingPercentage = (double) sum / (double) stats[row].length;
				System.out.println("Batter " + row + " Slugging Percentage: ");
				System.out.printf("%.3f", sluggingPercentage);
				System.out.println();

			}
			// asks user if they'd like to continue and enter another group of batters' stats
			System.out.println("Would you like to enter stats for another group of batters? (y/n): ");
			contin = scanner.next();

		}
		// if the user doesn't want to continue, the code below will run and the application will end
		if (contin.equalsIgnoreCase("n")) {
			System.out.println("Enjoy the game!");
		}
		scanner.close();
	}
	// this method checks user input from the scanner and makes sure it's an integer
	public static int getValidInteger(Scanner scanner) {
		// Loop while the input is not an integer!
		while (!scanner.hasNextInt()) {
			System.out.println("Please enter a valid integer!");

			scanner.nextLine(); // consume the new line
		
	}
		int number = scanner.nextInt();
		scanner.nextLine();
		return number ;
	}
	// this method checks get a valid integer from the getValidInteger method and makes sure that integer is also within a specified range
	public static int getValidIntegerInRange(int min, int max, Scanner scanner) {

		int number = getValidInteger(scanner);// get a valid number
		// loops when number is less than the min or greater than the max
		while (number > max || number < min) {
			System.out.println("Please enter a number between " + min + " and " + max);

			number = getValidInteger(scanner);// get a valid number
		}
		return number;
	}
}
