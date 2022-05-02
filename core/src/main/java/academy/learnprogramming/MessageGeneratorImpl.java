package academy.learnprogramming;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * add a logger - X
 * add a field of type Game and autowire it - X
 * add a field guessCount (int) and initialize it to 10 for now (we will change this later) - X
 * add a @PostConstruct method and log value of game to confirm it was autowired e.g. not null - X
 * create a bean method in AppConfig -> MessageGenerator - X
 * In the main method get the MessageGenerator bean and call both methods
 * Check the console output and confirm that both methods are called
 */
public class MessageGeneratorImpl implements MessageGenerator{
	
	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	// == fields ==
	@Autowired
	private Game game;
	
	private int guessCount = 10;
	
	// == init ==
	@PostConstruct
	public void init() {
		log.debug("game value is {}", game);
	}
	
	// == public methods ==
	@Override
	public String getMainMessage() {
		return "Number is between " +
				game.getSmallest() +
				" and " +
				game.getBiggest() +
				". Can you guess it?";
	}

	@Override
	public String getResultMessage() {
		if(game.isGameWon()) {
			return "You guessed it! The number was " + game.getNumber();
		} else if(game.isGameLost()) {
			return "You lost. The number was " + game.getNumber();
		} else if (!game.isValidNumberRange()) {
			return "Invalid number range!";
		} else if (game.getRemainingGuesses() == game.getGuessCount()) {
			return "What is your first guess?";
		} else {
			String direction = "Lower";
			
			if(game.getGuess() < game.getNumber()) {
				direction = "Higher";
			}
			
			return direction + "! You have " + game.getRemainingGuesses() + " guess left";
		}
	}

}