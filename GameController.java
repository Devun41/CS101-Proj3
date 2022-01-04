/*
 * @author
 * <p> GameController
 * <p> Project 3
 * <p> 
 */
 
//
// The rules to the dice game Pig
//
// Number of Players: 2 + 
// Game Duration: 30 mins
// Players Aged: 6 +
//
// You will need: 2 dice and paper to score on.
//
// To Play: The players take turns to roll both dice, 
// they can roll as many times as they want in one turn.
//
// A player scores the sum of the two dice thrown and 
// gradually reaches a higher score as they continue to roll.
//
// If a single number 1 is thrown on either die, the score 
// for that whole turn is lost. However a double 1 counts as 25.
// The first player to 100 wins unless a player scores more 
// subsequently in the same round. This means that everyone in 
// the game must have the same number of turns.
//

import java.util.Scanner;

public class GameController
{
	int maxScore=0;
	// central method to start and manage game play
	public void play()
	{
        // TODO
		Scanner scan=new Scanner(System.in);
		
		//Create two players
		PigDice player1=new PigDice();
		PigDice player2=new PigDice();
		//ask maxScore
		System.out.println("Enter what you want to play to: ");
		getInitialMax(scan);
		//loop till there is a winner 
		do {
						//Check if either player has maxScore
			if(player1.currentTotal()<=maxScore||player2.currentTotal()<=maxScore) {
				//roll for first player till enters N(no) aka player 1 turn
				takeTurn(scan,player1);
				//roll for second player
				takeTurn(scan,player2);
			}
			else {
				if(player1.currentTotal()>=maxScore) {
					System.out.println("Player 1 is the winner!");
					
				}
				else if(player2.currentTotal()>=maxScore) {
					System.out.println("Player 2 is the winner!");
				}
			}
		}
		while(yesResponse(scan));
		
		
		
		
	}

	//
	// Returns the initial max score (loops until a value between 1 <= score <= 100 is entered) 
	//
	private int getInitialMax(Scanner scan)
	{
        // TODO
		
		String scoreString = scan.nextLine();
		maxScore = Integer.parseInt( scoreString ) ;
		
		 
		 return maxScore;
		
	}
	
	// method for managing a single session of rolling dice
	//
	private void takeTurn(Scanner scan, PigDice pd)
	{
		
		boolean keepRolling = true;

		do
		{
			// Roll the dice
			pd.rollDice();

			// Report the result
			System.out.println(pd.lastRoll() + " scored " + pd.evaluate() + " points.");

			// Did the player pig out?
			if (pd.piggedOut())
			{	
				System.out.println("You pigged out this turn.");
			}
			else
			{
				//
				// Roll again; see if the user wants to roll again to add to total or pass and keep current points
				//
				System.out.println("Your current roll is " + pd.currentRound() + " points. Keep rolling? Respond (Y/N) only.");
				
				if (!yesResponse(scan))
				{
					keepRolling = false;
					int roundScore = pd.save();
					System.out.printf("Your total for the round was %d and your total score is %d.\r\n", roundScore, pd.currentTotal());
				}
			} 

		} while (!pd.piggedOut() && keepRolling);
	}
	
	//
	// Returns true if the user enters a 'y' or 'Y'
	//
	final String _YES = "Y";
	public boolean yesResponse(Scanner scan)
	{
		return scan.nextLine().substring(0, 1).toUpperCase().equals(_YES);
	}
}
