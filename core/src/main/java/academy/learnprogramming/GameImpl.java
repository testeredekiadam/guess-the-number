package academy.learnprogramming;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Component
@Getter
@Slf4j
public class GameImpl implements Game {
	
	// == fields ==
	@Getter(AccessLevel.NONE)
	private NumberGenerator numberGenerator;
	
	private int guessCount;
	private int number;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;
	
	@Setter
	private int guess;
	
	/* Constructor Based Dependency Injection  */
	
	// == constructors ==
	
	@Autowired
	public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
		this.numberGenerator = numberGenerator;
		this.guessCount = guessCount;
	}


	

	
	// == init ==
	@PostConstruct
	@Override
	public void reset() {
		smallest = numberGenerator.getMinNumber();
		guess = 0;
		remainingGuesses = guessCount;
		biggest = numberGenerator.getMaxNumber();
		number = numberGenerator.next();
		log.debug("the number is {}", number);
	}
	

	@PreDestroy
	public void preDestroy() {
		log.info("in Game preDestroy()");
	}
	// == public methods ==
	
	public void setNumberGenerator(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}
	
	@Override
	public void check() {
		checkValidNumberRange();
		
		if(validNumberRange) {
			if(guess>number) {
				biggest = guess - 1;
			}
			
			if(guess < number) {
				smallest = guess + 1;
			}
		}
		
		remainingGuesses--;
	}

	@Override
	public boolean isGameWon() {
		return guess == number;
	}

	@Override
	public boolean isGameLost() {
		return !isGameWon() && remainingGuesses <= 0;
	}
	
	
	// == private methods ==
	
	private void checkValidNumberRange() {
		validNumberRange = (guess >= smallest) && (guess <= biggest);
	}
	
}
