package cn.edu.syu.po;

public class User {
    private Integer userID;
    private String userName;
    private String userPwd;
    private String userBirthday;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }
    @Override
    public String toString() {
        return "User [id=" + userID + ", username=" + userName +
                ", userPwd=" + userPwd + ", birthday=" + userBirthday + "]";
    }
}
