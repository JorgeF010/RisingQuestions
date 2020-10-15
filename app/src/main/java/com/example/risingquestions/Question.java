package com.example.risingquestions;

public class Question {

    private String question;
    private int upVotes;
    private int downVotes;

    public Question(String question, int upVotes, int downVotes) {
        this.question = question;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }
}
