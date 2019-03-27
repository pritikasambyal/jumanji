package com.game.jumanji.model;

import java.util.List;

public class Question {
    private Category category;
    private String question;
    private List<String> options;
    private String answer;


    public Question(Category category,  String question, List<String> options, String answer) {
        this.category = category;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return
                "Category - " + category.name() + "\n" +
                "Question - '" + question + '\'' + "\n" +
                "Options are \n " + options ;
    }
}
