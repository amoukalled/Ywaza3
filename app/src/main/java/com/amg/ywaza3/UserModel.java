package com.amg.ywaza3;

public class UserModel {

    String email, password, userName, favTeam;

    public UserModel() { }

    public UserModel(String email, String password, String userName, String favTeam) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.favTeam = favTeam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFavTeam() {
        return favTeam;
    }

    public void setFavTeam(String favTeam) {
        this.favTeam = favTeam;
    }
}
