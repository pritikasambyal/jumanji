package com.game.jumanji.service;

import com.game.jumanji.model.Player;
import com.game.jumanji.model.Question;
import com.game.jumanji.session.PlayerSession;

import java.util.Random;

public class JumanjiService {

    private Question question;
    private PlayerSession playerSession;

    public JumanjiService(Player player) {
        playerSession = new PlayerSession(player);
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    public   String checkAnswer(String ansOption) {

        Boolean result= question.getAnswer().equals(ansOption);

        if (result){
            playerSession.getCurrentPlayer().incrmentScore();
            return "Correct";
        }else {
            return "Wrong Amnswer." + "\n" + "The correct answer is :: " + question.getAnswer();
        }

    }

    public Integer getPlayerScore() {
        return playerSession.getCurrentPlayer().getScore();
    }

    public int randomGenerator() {
        Random random = new Random();
        int maxValue = 6;
        int minValue = 1;

        int rolledValue = random.nextInt(maxValue) + minValue;
        return rolledValue;
    }
}
