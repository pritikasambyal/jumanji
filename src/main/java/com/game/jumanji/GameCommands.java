package com.game.jumanji;

import com.game.jumanji.model.Category;
import com.game.jumanji.model.Player;
import com.game.jumanji.model.Question;
import com.game.jumanji.service.JumanjiService;
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
        try {
            return jumanjiService.checkAnswer(option);
        } catch (Exception ex) {
            return "\nOops, something went wrong!\n" + guide();
        }
    }

    @ShellMethod("return score.")
    public String score(){
        try {
            return String.valueOf(jumanjiService.getPlayerScore());
        } catch (Exception ex) {
            return "\nOops, something went wrong!\n" + guide();
        }
    }

    @ShellMethod("guide")
    public String guide() {
        return
                "\n"
            +   "Commands:\n"
            +   "   start <player-name>     # start a new game\n"
            +   "   roll                    # roll the dice toget your next question\n"
            +   "   answer <choice>         # answer the current question\n"
            +   "   score                   # show your current score\n"
            +   "   exit                    # exit the game\n"
            +   "\n"
            +   "Example game:\n"
            +   "   shell:>start john\n"
            +   "    Welcome to the Jumanji john!\n"
            +   "   shell:>roll\n"
            +   "    rolledValue is 5\n"
            +   "    Category - COUNTRY\n"
            +   "    Question - 'WHICH CITY IS HOME TO NORTH AMERICA’S LARGEST MALL?'\n"
            +   "    Options are\n"
            +   "     [1. Edmonton, Alberta, 2. Toronto, Ontario, 3. Montreal, Quebec]\n"
            +   "   shell:>answer 2\n"
            +   "    Wrong Amnswer.\n"
            +   "    The correct answer is :: 1\n"
            +   "   shell:>roll\n"
            +   "    rolledValue is 3\n"
            +   "    Category - COUNTRY\n"
            +   "    Question - 'WHICH CITY IS HOME TO NORTH AMERICA’S LARGEST MALL?'\n"
            +   "    Options are\n"
            +   "     [1. Edmonton, Alberta, 2. Toronto, Ontario, 3. Montreal, Quebec]\n"
            +   "   shell:>answer 1\n"
            +   "    Correct\n"
            +   "   shell:>exit\n"
            ;
    }

    private  int chooseQuestionNumber() {
        return 0;

    }
    private  HashMap<Integer, List<Question>> setUpQuestionare() {

        Question question1  = new Question(Category.COUNTRY,"WHICH CITY IS HOME TO NORTH AMERICA’S LARGEST MALL?", Arrays.asList("1. Edmonton, Alberta", "2. Toronto, Ontario", "3. Montreal, Quebec"), "1");
        Question question2 = new Question(Category.COUNTRY,"WHICH CANADIAN CHAIN FIRST OPENED IN HAMILTON IN 1964?", Arrays.asList("1. Tim Hortons", "2. Wendy", "3. Starbucks"),"1");
        Question question3 = new Question(Category.COUNTRY,"WHICH CITY HOSTS NORTH AMERICA’S LARGEST SINGLE DAY PARADE?", Arrays.asList("1. Toronto", "2. Vacouver", "3. Quebec City, Quebec"), "1");
        Question question4 = new Question(Category.COUNTRY,"WHAT IS CANADA’S NATIONAL SPORT?", Arrays.asList("1. Baseball", "2. Basketball", "3. Hockey"), "3");
        Question question5  = new Question(Category.COUNTRY,"WHICH CANADIAN CITY RANKS AS THE MOST EDUCATED IN THE COUNTRY?", Arrays.asList("1. Ottawa", "2. Toronto", "3. Montreal"), "1");
        Question question6 = new Question(Category.COUNTRY,"WHICH CITY WAS HOME TO THE FIRST NORTH AMERICAN YMCA?", Arrays.asList("1. Ottawa", "2. Toronto", "3. Montreal"), "3");

        HashMap<Integer, List<Question>> questionaire = new HashMap<>();
        questionaire.put(1, Arrays.asList(question1,question2, question3, question4, question5, question6));
        questionaire.put(2, Arrays.asList(question1,question2, question3, question4, question5, question6));
        questionaire.put(3, Arrays.asList(question1,question2, question3, question4, question5, question6));
        questionaire.put(4, Arrays.asList(question1,question2, question3, question4, question5, question6));
        questionaire.put(5, Arrays.asList(question1,question2, question3, question4, question5, question6));
        questionaire.put(6, Arrays.asList(question1,question2, question3, question4, question5, question6));

        return questionaire;
    }

}
