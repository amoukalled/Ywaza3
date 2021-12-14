
package com.amg.ywaza3;

public class MatchesModel {

    private String homeTeamName;
    private String awayTeamName;

    private int homeTeamLogo;
    private int awayTeamLogo;

    private int homeScore;
    private int awayScore;

    private String date, stadium;

    public MatchesModel(String homeTeamName, String awayTeamName, int homeTeamID, int awayTeamID, int homeScore, int awayScore, String date, String stadium) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeTeamLogo = homeTeamID;
        this.awayTeamLogo = awayTeamID;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.date = date;
        this.stadium = stadium;
    }

    public void setHomeTeamID(int homeTeamID) {
        this.homeTeamLogo = homeTeamID;
    }

    public void setAwayTeamID(int awayTeamID) {
        this.awayTeamLogo = awayTeamID;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public int getHomeTeamID() {
        return homeTeamLogo;
    }

    public int getAwayTeamID() {
        return awayTeamLogo;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String getDate() {
        return date;
    }

    public String getStadium() {
        return stadium;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }
}

