package academy.learnprogramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import academy.learnprogramming.Game;
import academy.learnprogramming.GameImpl;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.MessageGeneratorImpl;
import academy.learnprogramming.NumberGenerator;
import academy.learnprogramming.NumberGeneratorImpl;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages="academy.learnprogramming")
public class AppConfig {
	// == bean methods ==
	@Bean
	public NumberGenerator numberGenerator() {
		return new NumberGeneratorImpl();
	}
	
	@Bean
	public Game game() {
		return new GameImpl();
	}
	
	@Bean
	public MessageGenerator messageGenerator() {
		return new MessageGeneratorImpl();
	}
}
