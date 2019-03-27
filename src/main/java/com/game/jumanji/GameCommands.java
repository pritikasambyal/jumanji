package com.game.jumanji;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.game.jumanji.model.Category;
import com.game.jumanji.model.Player;
import com.game.jumanji.model.Question;
import com.game.jumanji.service.JumanjiService;

@ShellComponent
public class GameCommands {

	boolean userReg = false;

    JumanjiService jumanjiService;
	/*
	 * 'start' command to launch a new game. The player must use the start command
	 * to start a new game. Example:
	 * 
	 * shell:> start my-name
	 */
	@ShellMethod("Start Game.")
	public String start(@ShellOption(defaultValue = "Player1") String text) {
		userReg = true;
        jumanjiService = new JumanjiService(new Player("text"));
		return "Welcome to the Jumanji " + text + "!";
	}

	/*
	 * 'roll' command to roll the dice. Example:
	 * 
	 * shell:> roll
	 */
	@ShellMethod("Roll Dice.")
	public String roll() {
		if (userReg) {

			HashMap<Integer, List<Question>> questionaire = setUpQuestionare();
			int rolledValue = jumanjiService.randomGenerator();

			List<Question> questions = questionaire.get(rolledValue);
			Question question = questions.get(chooseQuestionNumber());

            jumanjiService.setQuestion(question);
			return "rolledValue is " + rolledValue + "\n" + question;

		} else {
			return "Please register the user first, use command: start <name>";
		}
	}
    @ShellMethod("answer with option no.")
    public String answer(@ShellOption String option){
        return jumanjiService.checkAnswer(option);
    }

    @ShellMethod("return score.")
    public Integer score(){
        return jumanjiService.getPlayerScore();
    }

    private  int chooseQuestionNumber() {
        Random random = new Random();
        int maxValue = 4;
        int minValue = 1;

        return random.nextInt(maxValue) + minValue;

    }
    
    private  HashMap<Integer, List<Question>> setUpQuestionare() {

        Question question1  = new Question(Category.COUNTRY,"WHICH CITY IS HOME TO NORTH AMERICA’S LARGEST MALL?", Arrays.asList("1. Edmonton, Alberta", "2. Toronto, Ontario", "3. Montreal, Quebec"), "1");
        Question question2 = new Question(Category.COUNTRY,"WHICH CANADIAN CHAIN FIRST OPENED IN HAMILTON IN 1964?", Arrays.asList("1. Tim Hortons", "2. Wendy", "3. Starbucks"),"1");
        Question question3 = new Question(Category.COUNTRY,"WHICH CITY HOSTS NORTH AMERICA’S LARGEST SINGLE DAY PARADE?", Arrays.asList("1. Toronto", "2. Vacouver", "3. Quebec City, Quebec"), "1");
        Question question4 = new Question(Category.COUNTRY,"WHAT IS CANADA’S NATIONAL SPORT?", Arrays.asList("1. Baseball", "2. Basketball", "3. Hockey"), "3");
        Question question5  = new Question(Category.COUNTRY,"WHICH CANADIAN CITY RANKS AS THE MOST EDUCATED IN THE COUNTRY?", Arrays.asList("1. Ottawa", "2. Toronto", "3. Montreal"), "1");
        Question question6 = new Question(Category.COUNTRY,"WHICH CITY WAS HOME TO THE FIRST NORTH AMERICAN YMCA?", Arrays.asList("1. Ottawa", "2. Toronto", "3. Montreal"), "3");
        Question question7 = new Question(Category.SPORTS,"How many minutes is a rugby match?", Arrays.asList("1. 60mins", "2. 80mins", "3. 90mins"), "2");
        Question question8 = new Question(Category.SPORTS,"In which country were the first Olympic Games held?", Arrays.asList("1. Greece", "2. China", "3. Russia"), "1");
        Question question9 = new Question(Category.SPORTS,"In which sport can you win the Davis Cup?", Arrays.asList("1. Tennis", "2. Baseball", "3. Billiards"), "1");
        Question question10 = new Question(Category.SPORTS,"How many players has a hockey team got on the ice?", Arrays.asList("1. 6", "2. 9", "3. 7"), "1");
        Question question11 = new Question(Category.SPORTS,"How long is an Olympic swimming pool?", Arrays.asList("1. 60m", "2. 50m", "3. 100m"), "2");
        Question question12 = new Question(Category.SPORTS,"In which country is the Interlagos F1-circuit?", Arrays.asList("1. Brazil", "2. France", "3. Spain"), "1");
        
        HashMap<Integer, List<Question>> questionaire = new HashMap<>();
        questionaire.put(1, Arrays.asList(question1,question2, question3, question4, question5, question6));
        questionaire.put(2, Arrays.asList(question7,question8, question9, question10, question11, question12));
        questionaire.put(3, Arrays.asList(question1,question2, question3, question4, question5, question6));
        questionaire.put(4, Arrays.asList(question7,question8, question9, question10, question11, question12));
        questionaire.put(5, Arrays.asList(question1,question2, question3, question4, question5, question6));
        questionaire.put(6, Arrays.asList(question7,question8, question9, question10, question11, question12));

        return questionaire;
    }

}
