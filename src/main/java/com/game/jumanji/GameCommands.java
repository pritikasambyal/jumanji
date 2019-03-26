package com.game.jumanji;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class GameCommands {

	boolean userReg = false;

	/*
	 * 'start' command to launch a new game.  The player 
	 * must use the start command to start a new game.  
	 * Example:
	 * 
	 * 		shell:> start my-name
	 */
    @ShellMethod("Start Game.")
    public String start(@ShellOption() String text) {
      userReg =true;
      return "Welcome to the Jumanji "+text +"!";
    }

    /*
     * 'roll' command to roll the dice.  Example:
     * 
     * 		shell:> roll
     */
    @ShellMethod("Roll Dice.")
    public String roll() {
      if(userReg) {
    	  return String.valueOf(1);
      } else {
    	  return "Please register the user first, use command: start <name>";
      }
    }
}
