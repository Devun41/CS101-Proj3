/*
* @author
* <p> Die
* <p> Project 3
* <p> 
* 
*/

import java.util.Random;

//
// class to manage the value of a single simulated die
//
public class Die
{
	private int _pips = 1;
	private final int _MAX_PIPS = 6;
	private Random _randNum;
	
	// constructor that will create a Random class and generate a random start value.
	public Die()
	{
		// TODO
		_randNum=new Random();
		_pips=_randNum.nextInt(_MAX_PIPS)+1;
	}

	//
	// constructor that will create a Random class, set the seed of the RNG,
	// and generate a random start value.
	//
	public Die(int seed)
	{
		// TODO
		_randNum=new Random(seed);
		_pips=_randNum.nextInt(_MAX_PIPS)+1;
	}
	
	//
	// accessor to return the current value of the die.
	//
	public int faceValue()
	{
		// TODO
		return _pips;
	}

	//
	// mutator to randomly change the value of the die.
	//
	public int roll()
	{
		// TODO
		_pips=_randNum.nextInt(_MAX_PIPS)+1;
		return _pips;
		
	}
}
