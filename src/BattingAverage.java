import java.util.Scanner;

/**
 * 
 */

/**
 * @author Harley Quinn
 *	Purpose: Create an application that accepts user input of at-bat results for a baseball/softball player
 *	and calculates batting average and slugging percentage for them.
 */
public class BattingAverage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Batting Average and Slugging Percentage Calculator!");
		System.out.println();
		String contin = "y";
			
		while (contin.equalsIgnoreCase("Y")){
			
			int atBatTotal = 0;
			int sum = 0;
			double battingAverage = 0.000;
			double sluggingPercentage = 0.000;
			int bCount = 0;
			
			
			while (contin.equalsIgnoreCase("y")){
			sum = 0 ;
			bCount = 0;
				//ask the user for the number of at bats for their player
			System.out.println("Enter number of times at bat for your current player: ");
			
			atBatTotal = scanner.nextInt(); // **need to add validation for a number
				//creates an array to store the results of each at bat
			int [] atBatsResults = new int[atBatTotal];
				//choices for at bat results
			System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");
				//this for loop stores the user inputs for each at bat result in an array called atBatResults
			for (int i = 0; i < atBatTotal; i++) {
				System.out.println("Result for at-bat " + i + ": ");
				atBatsResults [i] = scanner.nextInt();	// **need to add validation for a number
				//if the user enters a number less than 0 or greater than 4, this while loop asks them for valid input
					while (atBatsResults [i] < 0 || atBatsResults [i] > 4) {
						System.out.println("That is not a valid option. Please enter an at-Bat result between 0 and 4");
						atBatsResults [i] = scanner.nextInt(); //**need to add validation for a number
					}
			
				sum = sum + atBatsResults[i]; //calculation for the sum of the # of bases earned
				if (atBatsResults[i] > 0)
					bCount ++;  			  //counts the number of at bats where bases were earned
			}
				
				battingAverage = (double) bCount / (double) atBatTotal; //calculates batting average; casts ints to doubles to retain accuracy
				System.out.println("Batting Average: ");
				System.out.printf("%.3f", battingAverage);				//keeps result to 3 decimal places
				System.out.println();
				
				sluggingPercentage = (double) sum / (double) atBatTotal; //calculates slugging percentage; casts ints to doubles to retain accuracy 
				System.out.println("Slugging Percentage: ");
				System.out.printf("%.3f", sluggingPercentage);			//keeps results to 3 decimal places
				System.out.println();
				
				System.out.println("Would you like to enter stats for another batter? (y/n) :"); //asks user if they'd like to input stats for another batter
				contin = scanner.next();
				
			}
				if (contin.equalsIgnoreCase("n")){						//if they don't want to enter more stats, end the application
					System.out.println("Enjoy the game!");
					
				}

			}
		scanner.close();	
		}
	
	
	}	

