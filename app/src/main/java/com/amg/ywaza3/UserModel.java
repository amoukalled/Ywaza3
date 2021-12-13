package com.amg.ywaza3;

public class UserModel {

    String email, userName, favTeam;

    public UserModel() {
    }

    public UserModel(String email, String userName, String favTeam) {
        this.email = email;
        this.userName = userName;
        this.favTeam = favTeam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
