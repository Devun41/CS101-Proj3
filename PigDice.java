/*
 * @author
 * <p> PigDice
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

// this class manages the state of the dice and the scoring
public class PigDice
{
	// keep track of total and round scores as well as the two dice.
	private int _totalScore = 0;
	private int _roundScore = 0;
	private Die _die1;
	private Die _die2;
	private int _tempScore=0;
	
	public PigDice()
	{
        // TODO
		_die1=new Die();
		_die2=new Die();
	}

	// accessor for total score
	// returns the current total integer score for a game of Pig. 
	public int currentTotal()
	{
		return _totalScore;
	}

	// accessor for this round score
	// returns the current integer score for a round
	public int currentRound()
	{
		return save();
	}

	// accessor to see if the user has rolled a single "1" and loses turn
	public boolean piggedOut()
	{
        // TODO
		//If either die rolls 1, you PigOut
		if(singleOneRolled()) {
			return true;
		}
		else {
			return false;
		}
	}

	// mutator that simulates rolling two dice and evaluating the resulting score
	public void rollDice()
	{
		// Roll the die
		_die1.roll();
		_die2.roll();
	}

	// accessor for a formatted string of what the last roll looked like
	// acquires a formatted string (consistent with the sample session output)
	//describing the values of the last dice roll. 
	public String lastRoll()
	{
		return "D1 (" + _die1.faceValue() + "), D2 (" + _die2.faceValue() + ")";
	}

	// computes the rolled score and adds to the current round score. 
	public int evaluate()
	{
        // TODO
		//temp int
	
		//check if doubleRolled
		if(doubleOnesRolled()==true) {
			_roundScore+=25;
		}
		//check if piggedOut
		else if(singleOneRolled()==true) {
			_roundScore=0;
		}
		//add all together if neither
		else {
			_roundScore+=(_die1.faceValue()+_die2.faceValue());
		}
		_tempScore=_roundScore;
		_roundScore=0;
		
		
		return _tempScore;
		
		
	}
	// returns true / false whether one of the two die resulted in a 1.
	private boolean singleOneRolled()
	{
        // TODO
		if(doubleOnesRolled()==false) {
			if(_die1.faceValue()==1||_die1.faceValue()==1) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
			}
	}
	//returns true / false whether both die rolled a 1.
	private boolean doubleOnesRolled()
	{
        // TODO
		if(_die1.faceValue()==1&&_die2.faceValue()==1) {
			return true;
		}
		else {
			return false;
		}
	}
	

	// mutator to end a round and keep the add this round to the total
	// also returns the total value of the round and resets the round total for next time
	//
	public int save()
	{
		
        // TODO
		//adds to total score
		_totalScore+=_tempScore;
		_tempScore=0;
		//return total value of the round
		return _totalScore;
		
	}
}
