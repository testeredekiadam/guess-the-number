package academy.learnprogramming;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator{
	
	
	// == fields ==

	private Game game;
	
	
	// == constructors ==
	@Autowired
	public MessageGeneratorImpl(Game game) {
		this.game = game;
	}
	
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