package cn.edu.syu.po;

import java.util.List;

public class QuestionAnswer {
    Question question;
    List<Answer> answerList;
    AnswerUser answerUser;

    public AnswerUser getAnswerUser() {
        return answerUser;
    }

    public void setAnswerUser(AnswerUser answerUser) {
        this.answerUser = answerUser;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
