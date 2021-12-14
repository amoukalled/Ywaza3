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

