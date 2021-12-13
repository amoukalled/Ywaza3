package com.amg.ywaza3;

public class StandingModel {

    String teamName;
    int teamStanding, logoID;

    public StandingModel(String teamName, int teamStanding, int logoID) {
        this.teamName = teamName;
        this.teamStanding = teamStanding;
        this.logoID = logoID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamStanding() {
        return teamStanding;
    }

    public void setTeamStanding(int teamStanding) {
        this.teamStanding = teamStanding;
    }

    public int getLogoID() {
        return logoID;
    }

    public void setLogoID(int logoID) {
        this.logoID = logoID;
    }
}
