package com.game.jumanji;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.jumanji.model.Player;
import com.game.jumanji.service.JumanjiService;

public class JumanjiApplicationTests {

	@Test
	public void testStart() {
		GameCommands gc = new GameCommands();
		String result = gc.start("abc");
		assertEquals("Welcome to the Jumanji abc!", result);
	}

	@Test
	public void testRollDice() {
		GameCommands gc = new GameCommands();
		JumanjiService jumanjiService = new JumanjiService(new Player("abc"));

		gc.start("abc");
		String result = gc.roll();

		assert result.contains("rolledValue is");
	}

	@Test
	public void testGuide() {
		// setup
		GameCommands gc = new GameCommands();
		// run
		String actual = gc.guide();
		// assert
		assert actual.startsWith("\nCommands");
	}
}
