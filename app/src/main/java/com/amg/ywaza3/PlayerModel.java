package com.amg.ywaza3;

public class PlayerModel {

    String teamName, pName, pPosition;
    int pGoals, pAssists;

    public PlayerModel(String teamName, String pName, String pPosition, int pGoals, int pAssists) {
        this.teamName = teamName;
        this.pName = pName;
        this.pPosition = pPosition;
        this.pGoals = pGoals;
        this.pAssists = pAssists;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPosition() {
        return pPosition;
    }

    public void setpPosition(String pPosition) {
        this.pPosition = pPosition;
    }

    public int getpGoals() {
        return pGoals;
    }

    public void setpGoals(int pGoals) {
        this.pGoals = pGoals;
    }

    public int getpAssists() {
        return pAssists;
    }

    public void setpAssists(int pAssists) {
        this.pAssists = pAssists;
    }
}
