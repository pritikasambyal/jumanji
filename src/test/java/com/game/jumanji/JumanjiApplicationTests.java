package com.game.jumanji;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JumanjiApplicationTests {

	@Test
	public void testStart() {
		GameCommands gc = new GameCommands();
		String result = gc.start("abc");
		assertEquals("Welcome to the Jumanji abc!", result);
	}

	@Test
	public void testRollDice() {
		int maxValue = 6;
		int minValue = 1;
		GameCommands gc = new GameCommands();
		int rolledNumber = gc.randomGenerator();
		assertTrue("Error, random is too high", maxValue >= Integer.valueOf(rolledNumber));
		assertTrue("Error, random is too low", minValue <= Integer.valueOf(rolledNumber));
	}

}
