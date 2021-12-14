
package com.amg.ywaza3;

public class Matches {

    private String hometeam;
    private String awayteam;
    private int hometeamimageId;
    private int awayteamimageId;
    private int homescore;
    private int awayscore;

    public static final Matches[] matches = {
            new Matches("Chelsea","Manchester City",R.drawable.chelsea, R.drawable.city,2,0),
            new Matches("Liverpool","Manchester United",R.drawable.liverpool, R.drawable.united,2,3),
            new Matches("Arsenal","Tottenham",R.drawable.arsenal, R.drawable.tottenham,1,1),
            new Matches("Chelsea","Manchester City",R.drawable.chelsea, R.drawable.city,2,0),
            new Matches("Liverpool","Manchester United",R.drawable.liverpool, R.drawable.united,2,3),
            new Matches("Arsenal","Tottenham",R.drawable.arsenal, R.drawable.tottenham,1,1),
    };

    public Matches(String hometeam, String awayteam, int hometeamimageId, int awayteamimageId, int homescore, int awayscore)
    {
        this.hometeam = hometeam;
        this.awayteam = awayteam;
        this.hometeamimageId = hometeamimageId;
        this.awayteamimageId = awayteamimageId;
        this.homescore = homescore;
        this.awayscore = awayscore;
    }

    public String getHometeam() {
        return hometeam;
    }

    public String getAwayteam() {
        return awayteam;
    }

    public int getHometeamimageId() {
        return hometeamimageId;
    }

    public int getAwayteamimageId() {
        return awayteamimageId;
    }

    public int getHomescore() {
        return homescore;
    }

    public int getAwayscore() {
        return awayscore;
    }

    public static Matches[] getMatches() {
        return matches;
    }
}

