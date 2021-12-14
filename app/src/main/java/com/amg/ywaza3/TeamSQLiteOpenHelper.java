package com.amg.ywaza3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TeamSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Ywaza3";
    private static final int DB_VERSION = 1;

    public TeamSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TEAMS(" +
                "T_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "T_LeagueID INTEGER," +
                "T_Name TEXT," +
                "T_Standing INTEGER," +
                "T_IMAGE_RESOURCE_ID INTEGER);");

        insertTeam(db, 1, "Chelsea", 3, R.drawable.chelsea);
        insertTeam(db, 1, "Manchester City", 1, R.drawable.city);
        insertTeam(db, 1, "Liverpool", 2, R.drawable.liverpool);
        insertTeam(db, 1, "Manchester United", 5, R.drawable.united);
        insertTeam(db, 1, "Arsenal", 6, R.drawable.arsenal);
        insertTeam(db, 1, "Tottenham", 7, R.drawable.tottenham);
        insertTeam(db, 1, "Everton", 14, R.drawable.everton);
        insertTeam(db, 1, "Crystal Palace", 12, R.drawable.crystalpalace);
        insertTeam(db, 1, "Leeds United", 15, R.drawable.leeds);
        insertTeam(db, 1, "Leicester City", 8, R.drawable.leicester);
        insertTeam(db, 1, "Newcastle United", 19, R.drawable.newcastle);
        insertTeam(db, 1, "Norwich City", 20, R.drawable.norwich);
        insertTeam(db, 1, "Southampton", 16, R.drawable.southampton);
        insertTeam(db, 1, "Watford", 17, R.drawable.watford);
        insertTeam(db, 1, "Westham United", 4, R.drawable.westham);
        insertTeam(db, 1, "Wolverhampton", 9, R.drawable.wolves);
        insertTeam(db, 1, "Aston Villa", 13, R.drawable.astonvilla);
        insertTeam(db, 1, "Brentford", 10, R.drawable.brentford);
        insertTeam(db, 1, "Brighton", 11, R.drawable.brighton);
        insertTeam(db, 1, "Burnley", 18, R.drawable.burnley);

        //Chelsea Matches
        insertMatch(db, 0, 14, 0, 3, 2, "December 4, 2021", "London Stadium");
        insertMatch(db, 1, 0, 8, 3, 2, "December 11, 2021", "Stamford Bridge");
        insertMatch(db, 2, 0, 6, 0, 0, "December 16, 2021", "Stamford Bridge");
        //Man City Matches
        insertMatch(db, 3, 13, 1, 1, 3, "December 4, 2021", "Vicarage Road");
        insertMatch(db, 4, 1, 15, 1, 0, "December 11, 2021", "Etihad Stadium");
        insertMatch(db, 5, 0, 6, 0, 0, "December 14, 2021", "Etihad Stadium");
        //Liverpool Matches
        insertMatch(db, 6, 15, 2, 0, 1, "December 4, 2021", "Molineux Stadium");
        insertMatch(db, 7, 2, 16, 1, 0, "December 11, 2021", "Anfield");
        insertMatch(db, 8, 2, 10, 0, 0, "December 16, 2021", "Anfield");
        //Man United Matches
        insertMatch(db, 9, 3, 7, 1, 0, "December 5, 2021", "Old Trafford");
        insertMatch(db, 10, 11, 3, 0, 1, "December 11, 2021", "Carrow Road");
        insertMatch(db, 11, 3, 18, 0, 0, "December 16, 2021", "Old Trafford");
        //Arsenal Matches
        insertMatch(db, 12, 6, 4, 2, 1, "December 6, 2021", "Goodison Park");
        insertMatch(db, 13, 4, 12, 3, 0, "December 11, 2021", "Emirates Stadium");
        insertMatch(db, 14, 4, 14, 0, 0, "December 15, 2021", "Emirates Stadium");
        //Tottenham Matches
        insertMatch(db, 15, 5, 17, 2, 0, "December 2, 2021", "Tottenham Hotspur Stadium");
        insertMatch(db, 16, 5, 11, 3, 0, "December 5, 2021", "Tottenham Hotspur Stadium");
        insertMatch(db, 17, 9, 5, 0, 0, "December 16, 2021", "King Power Stadium");
        //Everton Matches
        insertMatch(db, 18, 6, 4, 2, 1, "December 6, 2021", "Goodison Park");
        insertMatch(db, 19, 7, 6, 3, 1, "December 12, 2021", "Selhurst Park");
        insertMatch(db, 20, 0, 6, 0, 0, "December 16, 2021", "Stamford Bridge");
        //Crystal Palace Matches
        insertMatch(db, 21, 3, 7, 1, 0, "December 5, 2021", "Old Trafford");
        insertMatch(db, 22, 7, 6, 3, 1, "December 12, 2021", "Selhurst Park");
        insertMatch(db, 23, 7, 12, 0, 0, "December 16, 2021", "Selhurst Park");
        //Leeds United Matches
        insertMatch(db, 24, 8, 17, 2, 2, "December 5, 2021", "Elland Road");
        insertMatch(db, 25, 0, 8, 3, 2, "December 11, 2021", "Stamford Bridge");
        insertMatch(db, 26, 1, 8, 0, 0, "December 14, 2021", "Etihad Stadium");
        //Leicester City Matches
        insertMatch(db, 27, 16, 9, 2, 1, "December 5, 2021", "Villa Park");
        insertMatch(db, 28, 9, 10, 4, 0, "December 12, 2021", "King Power Stadium");
        insertMatch(db, 29, 9, 5, 0, 0, "December 16, 2021", "King Power Stadium");
        //Newcastle United Matches
        insertMatch(db, 30, 10, 19, 1, 0, "December 4, 2021", "St James Park");
        insertMatch(db, 31, 9, 10, 4, 0, "December 13, 2021", "King Power Stadium");
        insertMatch(db, 32, 2, 10, 0, 0, "December 16, 2021", "Anfield");
        //Norwich City Matches
        insertMatch(db, 33, 11, 3, 0, 1, "December 11, 2021", "Carrow Road");
        //Southampton Matches
        insertMatch(db, 35, 4, 12, 3, 0, "December 11, 2021", "Emirates Stadium");
        //Watford Matches
        insertMatch(db, 36, 17, 13, 2, 1, "December 10, 2021", "Brentford Community Stadium");
        //West Ham  Matches
        insertMatch(db, 37, 19, 14, 0, 0, "December 16, 2021", "Turf Moor");
        //Wolves  Matches
        insertMatch(db, 38, 15, 10, 0, 0, "December 16, 2021", "Anfield");
        //Aston Villa  Matches
        insertMatch(db, 39, 1, 16, 1, 0, "December 11, 2021", "Etihad Stadium");
        //Brentford Matches
        insertMatch(db, 40, 17, 13, 2, 1, "December 10, 2021", "Brentford Community Stadium");
        //Brighton Matches
        insertMatch(db, 41, 12, 18, 1, 1, "December 15, 2021", "St Mary's Stadium");
        //Burnley Matches
        insertMatch(db, 42, 19, 14, 0, 0, "December 12, 2021", "Turf Moor");



        db.execSQL("CREATE TABLE PLAYERS(" +
                "P_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "P_TeamID INTEGER," +
                "P_Name TEXT," +
                "P_ShirtNumber INTEGER," +
                "P_Position TEXT," +
                "P_Goals INTEGER," +
                "P_Assists INTEGER," +
                "P_IMAGE_RESOURCE_ID INTEGER);");

        db.execSQL("CREATE TABLE MATCHES(" +
                "M_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "M_HomeTeamID INTEGER," +
                "M_AwayTeamID INTEGER," +
                "M_HomeTeamScore INTEGER," +
                "M_AwayTeamScore INTEGER," +
                "M_DATE TEXT," +
                "M_STADIUM TEXT);");

        db.execSQL("CREATE TABLE BOOKINGS(" +
                "B_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "B_MatchID INTEGER," +
                "B_UserID INTEGER," +
                "B_TotalTickets INTEGER);");

        db.execSQL("CREATE TABLE VOTING(" +
                "V_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "V_MatchID INTEGER," +
                "V_UserID INTEGER," +
                "V_EventResult INTEGER);");
    }

    public static void insertTeam(SQLiteDatabase db, int LeagueID, String name, int Standing, int TimageID) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("T_LeagueID", LeagueID);
        contentValues.put("T_Name", name);
        contentValues.put("T_Standing", Standing);
        contentValues.put("T_IMAGE_RESOURCE_ID", TimageID);
        db.insert("TEAMS", null, contentValues);
    }

    public static void insertPlayer(SQLiteDatabase db, int PTeamID, String PName, int PSHNumber, int PPos, int PGoals, int PAssists) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("P_TeamID", PTeamID);
        contentValues.put("P_Name", PName);
        contentValues.put("P_ShirtNumber", PSHNumber);
        contentValues.put("P_Position", PPos);
        contentValues.put("P_Goals", PGoals);
        contentValues.put("P_Assists", PAssists);
        db.insert("PLAYER", null, contentValues);
    }
    public static void insertMatch(SQLiteDatabase db, int MatchID, int HomeTeamID, int AwayTeamID, int HomeScore, int AwayScore, String MDate, String MStadium) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("M_id", MatchID);
        contentValues.put("M_HomeTeamID", HomeTeamID);
        contentValues.put("M_AwayTeamID", AwayTeamID);
        contentValues.put("M_HomeTeamScore", HomeScore);
        contentValues.put("M_AwayTeamScore", AwayScore);
        contentValues.put("M_DATE", MDate);
        contentValues.put("M_STADIUM", MStadium);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor getTeamData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "SELECT T_Name, T_IMAGE_RESOURCE_ID FROM TEAMS";
        Cursor data = db.rawQuery(qry, null);
        return data;
    }

    public Cursor getTeamStanding() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "SELECT T_Name, T_Standing, T_IMAGE_RESOURCE_ID FROM TEAMS ORDER BY T_Standing";
        Cursor data = db.rawQuery(qry, null);
        return data;
    }

}

