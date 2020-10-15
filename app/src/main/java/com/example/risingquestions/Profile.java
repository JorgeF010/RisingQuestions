package com.example.risingquestions;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    private String name;
    private String username;
    private List<String> questions;

    public Profile(String name, String username) {
        this.name = name;
        this.username = username;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(String question) {
        this.questions.add(question);
    }

    public void removeQuestion(String question) {
        int i = 0;
        for (String q : questions) {
            if(question.equals(q)) {
                questions.remove(i);
            }
            i++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
