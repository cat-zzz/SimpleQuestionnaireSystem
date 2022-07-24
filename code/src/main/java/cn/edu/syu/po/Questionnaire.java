package cn.edu.syu.po;

public class Questionnaire {
    private int questionnaireID;
    private int userID;
    private String questionnaireTitle;
    private String questionnaireDesc;
    private String questionnaireCreateTime;

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public void setQuestionnaireID(int questionnaireID) {
        this.questionnaireID = questionnaireID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    public String getQuestionnaireDesc() {
        return questionnaireDesc;
    }

    public void setQuestionnaireDesc(String questionnaireDesc) {
        this.questionnaireDesc = questionnaireDesc;
    }

    public String getQuestionnaireCreateTime() {
        return questionnaireCreateTime;
    }

    public void setQuestionnaireCreateTime(String questionnaireCreateTime) {
        this.questionnaireCreateTime = questionnaireCreateTime;
    }
}
