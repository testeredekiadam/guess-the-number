package academy.learnprogramming;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;


public class NumberGeneratorImpl implements NumberGenerator {

	// == fields ==
	private final Random random = new Random();
	
	@Autowired
	@MaxNumber
	private int maxNumber;
	
	
	// == public methods ==
	@Override
	public int next() {
		return random.nextInt(maxNumber);
	}

	@Override
	public int getMaxNumber() {
		return maxNumber;
	}
	
}