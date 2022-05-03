package academy.learnprogramming;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NumberGeneratorImpl implements NumberGenerator {

	// == fields ==
	private final Random random = new Random();

	private final int maxNumber;
	
	private final int minNumber;
	
	
	// == constructor ==
	@Autowired
	public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
		super();
		this.maxNumber = maxNumber;
		this.minNumber = minNumber;
	}
	
	// == public methods ==
	@Override
	public int next() {
		return random.nextInt(getMaxNumber() - getMinNumber()) + getMinNumber();
	}

	

	@Override
	public int getMaxNumber() {
		return maxNumber;
	}

	@Override
	public int getMinNumber() {
		return minNumber;
	}
	
	
	
}