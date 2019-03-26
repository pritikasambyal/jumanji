package com.game.jumanji;

import com.game.jumanji.model.Question;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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

          HashMap<Integer, List<Question>> questionaire = setUpQuestionare();
          Random random = new Random();
          int maxValue = 6;
          int minValue = 1;

          int rolledValue = random.nextInt(maxValue) + minValue;

          List<Question> questions = questionaire.get(rolledValue);
          Question question = questions.get(chooseQuestionNumber());

          return "rolledValue is " + rolledValue + "\n Question - " + question.toString();

      } else {
    	  return "Please register the user first, use command: start <name>";
      }
    }

    private static int chooseQuestionNumber() {
        return 0;

    }

    private static HashMap<Integer, List<Question>> setUpQuestionare() {

        Question question1  = new Question("WHICH CITY IS HOME TO NORTH AMERICA’S LARGEST MALL?", Arrays.asList("1. Edmonton, Alberta", "2. Toronto, Ontario", "3. Montreal, Quebec"), "1.Edmonton, Alberta");
        Question question2 = new Question("WHICH CANADIAN CHAIN FIRST OPENED IN HAMILTON IN 1964?", Arrays.asList("1. Tim Hortons", "2. Wendy", "3. Starbucks"),"1. Tim Hortons");
        Question question3 = new Question("WHICH CITY HOSTS NORTH AMERICA’S LARGEST SINGLE DAY PARADE?", Arrays.asList("1. Toronto", "2. Vacouver", "3. Quebec City, Quebec"), "1. Toronto");
        Question question4 = new Question("WHAT IS CANADA’S NATIONAL SPORT?", Arrays.asList("1. Baseball", "2. Basketball", "3. Hockey"), "3. Hockey");
        Question question5  = new Question("WHICH CANADIAN CITY RANKS AS THE MOST EDUCATED IN THE COUNTRY?", Arrays.asList("1. Ottawa", "2. Toronto", "3. Montreal"), "1. Ottawa");
        Question question6 = new Question("WHICH CITY WAS HOME TO THE FIRST NORTH AMERICAN YMCA?", Arrays.asList("1. Ottawa", "2. Toronto", "3. Montreal"), "3. Montreal");

        HashMap<Integer, List<Question>> questionaire = new HashMap<>();
        questionaire.put(1, Arrays.asList(question1));
        questionaire.put(2, Arrays.asList(question2));
        questionaire.put(3, Arrays.asList(question3));
        questionaire.put(4, Arrays.asList(question4));
        questionaire.put(5, Arrays.asList(question5));
        questionaire.put(6, Arrays.asList(question6));

        return questionaire;
    }

}
