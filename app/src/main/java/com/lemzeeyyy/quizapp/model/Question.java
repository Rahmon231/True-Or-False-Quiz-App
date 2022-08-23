package com.lemzeeyyy.quizapp.model;

public class Question {
    int questionResId;
    boolean ansTrue;

    public Question(int questionResId, boolean ansTrue) {
        this.questionResId = questionResId;
        this.ansTrue = ansTrue;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public void setQuestionResId(int questionResId) {
        this.questionResId = questionResId;
    }

    public boolean getAnsTrue() {
        return ansTrue;
    }

    public void setAnsTrue(boolean ansTrue) {
        this.ansTrue = ansTrue;
    }
}
