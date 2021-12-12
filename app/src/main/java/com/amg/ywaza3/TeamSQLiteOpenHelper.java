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

        insertTeam(db, 1, "Chelsea", 1, R.drawable.chelsea);
        insertTeam(db, 1, "Manchester City", 2, R.drawable.city);
        insertTeam(db, 1, "Liverpool", 3, R.drawable.liverpool);
        insertTeam(db, 1, "Manchester United", 4, R.drawable.united);
        insertTeam(db, 1, "Arsenal", 5, R.drawable.arsenal);
        insertTeam(db, 1, "Tottenham", 6, R.drawable.tottenham);
        insertTeam(db, 2, "Real Madrid", 1, R.drawable.realmadrid);
        insertTeam(db, 2, "Atletico Madrid", 2, R.drawable.atmadrid);
        insertTeam(db, 2, "F.C. Barcelona", 3, R.drawable.barcelona);

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

        db.execSQL("CREATE TABLE LEAGUE(" +
                "L_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "L_LName TEXT," +
                "L_TeamID INTEGER);");

        db.execSQL("CREATE TABLE USER(" +
                "U_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "U_Email TEXT," +
                "U_Password TEXT," +
                "U_Username TEXT," +
                "U_FavTeam INTEGER," +
                "U_IMAGE_RESOURCE_ID INTEGER);");
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

}

