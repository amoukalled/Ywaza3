package com.amg.ywaza3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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

        db.execSQL("CREATE TABLE MATCHES(" +
                "M_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "M_HomeTeamID INTEGER," +
                "M_AwayTeamID INTEGER," +
                "M_HomeTeamScore INTEGER," +
                "M_AwayTeamScore INTEGER," +
                "M_DATE TEXT," +
                "M_STADIUM TEXT);");

        db.execSQL("CREATE TABLE BOOKINGS(" +
                "B_id INTEGER PRIMARY KEY," +
                "B_MatchID INTEGER," +
                "B_TotalTickets INTEGER);");

        db.execSQL("CREATE TABLE VOTING(" +
                "V_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "V_MatchID INTEGER," +
                "V_UserID INTEGER," +
                "V_EventResult INTEGER);");

        db.execSQL("CREATE TABLE PLAYERS(" +
                "P_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "P_TeamID INTEGER," +
                "P_Name TEXT," +
                "P_Position TEXT," +
                "P_Goals INTEGER," +
                "P_Assists INTEGER);");

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
        insertMatch(db, 1, 15, 1, 3, 2, "December 4, 2021", "London Stadium");
        insertMatch(db, 2, 1, 9, 3, 2, "December 11, 2021", "Stamford Bridge");
        insertMatch(db, 3, 1, 7, 0, 0, "December 16, 2021", "Stamford Bridge");
        //Man City Matches
        insertMatch(db, 4, 14, 2, 1, 3, "December 4, 2021", "Vicarage Road");
        insertMatch(db, 5, 2, 16, 1, 0, "December 11, 2021", "Etihad Stadium");
        insertMatch(db, 6, 1, 7, 0, 0, "December 14, 2021", "Etihad Stadium");
        //Liverpool Matches
        insertMatch(db, 7, 16, 3, 0, 1, "December 4, 2021", "Molineux Stadium");
        insertMatch(db, 8, 3, 17, 1, 0, "December 11, 2021", "Anfield");
        insertMatch(db, 9, 3, 11, 0, 0, "December 16, 2021", "Anfield");
        //Man United Matches
        insertMatch(db, 10, 4, 8, 1, 0, "December 5, 2021", "Old Trafford");
        insertMatch(db, 11, 12, 4, 0, 1, "December 11, 2021", "Carrow Road");
        insertMatch(db, 12, 4, 19, 0, 0, "December 16, 2021", "Old Trafford");
        //Arsenal Matches
        insertMatch(db, 13, 7, 5, 2, 1, "December 6, 2021", "Goodison Park");
        insertMatch(db, 14, 5, 13, 3, 0, "December 11, 2021", "Emirates Stadium");
        insertMatch(db, 15, 5, 15, 0, 0, "December 15, 2021", "Emirates Stadium");
        //Tottenham Matches
        insertMatch(db, 16, 6, 18, 2, 0, "December 2, 2021", "Tottenham Hotspur Stadium");
        insertMatch(db, 17, 6, 12, 3, 0, "December 5, 2021", "Tottenham Hotspur Stadium");
        insertMatch(db, 18, 10, 6, 0, 0, "December 16, 2021", "King Power Stadium");
        //Everton Matches
        insertMatch(db, 19, 7, 5, 2, 1, "December 6, 2021", "Goodison Park");
        insertMatch(db, 20, 8, 7, 3, 1, "December 12, 2021", "Selhurst Park");
        insertMatch(db, 21, 1, 7, 0, 0, "December 16, 2021", "Stamford Bridge");
        //Crystal Palace Matches
        insertMatch(db, 22, 4, 8, 1, 0, "December 5, 2021", "Old Trafford");
        insertMatch(db, 23, 8, 7, 3, 1, "December 12, 2021", "Selhurst Park");
        insertMatch(db, 24, 8, 13, 0, 0, "December 16, 2021", "Selhurst Park");
        //Leeds United Matches
        insertMatch(db, 25, 9, 18, 2, 2, "December 5, 2021", "Elland Road");
        insertMatch(db, 26, 1, 9, 3, 2, "December 11, 2021", "Stamford Bridge");
        insertMatch(db, 27, 2, 9, 0, 0, "December 14, 2021", "Etihad Stadium");
        //Leicester City Matches
        insertMatch(db, 28, 17, 10, 2, 1, "December 5, 2021", "Villa Park");
        insertMatch(db, 29, 10, 11, 4, 0, "December 12, 2021", "King Power Stadium");
        insertMatch(db, 30, 10, 6, 0, 0, "December 16, 2021", "King Power Stadium");
        //Newcastle United Matches
        insertMatch(db, 31, 11, 20, 1, 0, "December 4, 2021", "St James Park");
        insertMatch(db, 32, 10, 11, 4, 0, "December 13, 2021", "King Power Stadium");
        insertMatch(db, 33, 3, 11, 0, 0, "December 16, 2021", "Anfield");
        //Norwich City Matches
        insertMatch(db, 34, 12, 4, 0, 1, "December 11, 2021", "Carrow Road");
        //Southampton Matches
        insertMatch(db, 35, 5, 13, 3, 0, "December 11, 2021", "Emirates Stadium");
        //Watford Matches
        insertMatch(db, 36, 18, 14, 2, 1, "December 10, 2021", "Brentford Community Stadium");
        //West Ham  Matches
        insertMatch(db, 37, 20, 15, 0, 0, "December 16, 2021", "Turf Moor");
        //Wolves  Matches
        insertMatch(db, 38, 16, 11, 0, 0, "December 16, 2021", "Anfield");
        //Aston Villa  Matches
        insertMatch(db, 39, 2, 17, 1, 0, "December 11, 2021", "Etihad Stadium");
        //Brentford Matches
        insertMatch(db, 40, 18, 14, 2, 1, "December 10, 2021", "Brentford Community Stadium");
        //Brighton Matches
        insertMatch(db, 41, 13, 19, 1, 1, "December 15, 2021", "St Mary's Stadium");
        //Burnley Matches
        insertMatch(db, 42, 20, 15, 0, 0, "December 12, 2021", "Turf Moor");

        insertBookings(db, 1, 56);
        insertBookings(db, 2, 100);
        insertBookings(db, 3, 100);
        insertBookings(db, 4, 100);
        insertBookings(db, 5, 100);
        insertBookings(db, 6, 100);
        insertBookings(db, 7, 100);
        insertBookings(db, 8, 100);
        insertBookings(db, 10, 100);
        insertBookings(db, 11, 100);
        insertBookings(db, 12, 100);
        insertBookings(db, 13, 100);
        insertBookings(db, 14, 100);
        insertBookings(db, 15, 100);
        insertBookings(db, 16, 100);
        insertBookings(db, 17, 100);
        insertBookings(db, 18, 100);
        insertBookings(db, 19, 100);
        insertBookings(db, 20, 100);
        insertBookings(db, 21, 100);
        insertBookings(db, 22, 100);
        insertBookings(db, 23, 100);
        insertBookings(db, 24, 100);
        insertBookings(db, 25, 100);
        insertBookings(db, 26, 100);
        insertBookings(db, 27, 100);
        insertBookings(db, 28, 100);
        insertBookings(db, 29, 100);
        insertBookings(db, 30, 100);
        insertBookings(db, 31, 100);
        insertBookings(db, 32, 100);
        insertBookings(db, 33, 100);
        insertBookings(db, 34, 100);
        insertBookings(db, 35, 100);
        insertBookings(db, 36, 100);
        insertBookings(db, 37, 100);
        insertBookings(db, 38, 100);
        insertBookings(db, 39, 100);
        insertBookings(db, 40, 100);
        insertBookings(db, 41, 100);
        insertBookings(db, 42, 100);


        insertPlayer(db, 1, "Romely Lukaku", "FW", 3, 0);
        insertPlayer(db, 1, "Kai Havertz", "FW", 2, 1);
        insertPlayer(db, 1, "Mason Mount", "MF", 6, 4);
        insertPlayer(db, 1, "Marcos Alonso", "MF", 1, 2);
        insertPlayer(db, 1, "Jorginho", "MF", 4, 1);
        insertPlayer(db, 1, "Kovacic", "MF", 1, 5);
        insertPlayer(db, 1, "Reece James", "DF", 4, 4);
        insertPlayer(db, 1, "Cesar Azpilicueta", "DF", 0, 2);
        insertPlayer(db, 1, "Thiago Silva", "DF", 2, 0);
        insertPlayer(db, 1, "Antonio Rudiger", "DF", 2, 0);
        insertPlayer(db, 1, "Edouard Mendy", "GK", 0, 0);

        insertPlayer(db, 2, "Gabriel Jesus", "FW", 2, 6);
        insertPlayer(db, 2, "Raheem Sterling", "FW", 8, 4);
        insertPlayer(db, 2, "Jack Grealish", "MF", 1, 2);
        insertPlayer(db, 2, "Bernardo Silva", "MF", 7, 1);
        insertPlayer(db, 2, "Kevin DeBruyne", "MF", 2, 0);
        insertPlayer(db, 2, "Rodri", "MF", 2, 0);
        insertPlayer(db, 2, "Oleksandr Zinchenko", "DF", 0, 0);
        insertPlayer(db, 2, "Aymeric Laporte", "DF", 1, 0);
        insertPlayer(db, 2, "Ruben Dias", "DF", 1, 1);
        insertPlayer(db, 2, "Joao Cancelo", "DF", 0, 3);
        insertPlayer(db, 2, "Ederson", "GK", 0, 0);

        insertPlayer(db, 3, "Mohammed Salah", "FW", 14, 9);
        insertPlayer(db, 3, "Diogo Jota", "FW", 8, 1);
        insertPlayer(db, 3, "Sadio Mane", "FW", 7, 1);
        insertPlayer(db, 3, "Thiago Alcantara", "MF", 1, 1);
        insertPlayer(db, 3, "Fabinho", "MF", 1, 1);
        insertPlayer(db, 3, "Jordan Henderson", "MF", 2, 3);
        insertPlayer(db, 3, "Andrew Robertson", "DF", 0, 4);
        insertPlayer(db, 3, "Virgil Van Dijk", "DF", 1, 1);
        insertPlayer(db, 3, "Joel Matip", "DF", 0, 0);
        insertPlayer(db, 3, "Trent Alexander-Arnold", "DF", 1, 7);
        insertPlayer(db, 3, "Allison", "GK", 0, 0);

        insertPlayer(db, 4, "Marcus Rashford", "MF", 2, 1);
        insertPlayer(db, 4, "Cristiano Ronaldo", "FW", 7, 2);
        insertPlayer(db, 4, "Bruno Fernandes", "MF", 5, 3);
        insertPlayer(db, 4, "Jadon Sancho", "MF", 1, 0);
        insertPlayer(db, 4, "Fred", "MF", 2, 1);
        insertPlayer(db, 4, "Scott McTominay", "MF", 0, 0);
        insertPlayer(db, 4, "Alex Telles", "DF", 0, 0);
        insertPlayer(db, 4, "Harry Maguire", "DF", 0, 0);
        insertPlayer(db, 4, "Victor Lindelof", "DF", 0, 2);
        insertPlayer(db, 4, "Aaron Wan-Bissaka", "DF", 0, 0);
        insertPlayer(db, 4, "David De Gea", "GK", 0, 0);

        insertPlayer(db, 5, "Pierre-Emerick Aubameyang", "FW", 4, 1);
        insertPlayer(db, 5, "Martin Odergaard", "MF", 4, 0);
        insertPlayer(db, 5, "Emile Smith Rowe", "MF", 5, 2);
        insertPlayer(db, 5, "Mohamed Elneny", "MF", 0, 1);
        insertPlayer(db, 5, "Thomas Partey", "MF", 1, 0);
        insertPlayer(db, 5, "Gabriel Martinelli", "MF", 1, 2);
        insertPlayer(db, 5, "Nuno Tavares", "DF", 0, 1);
        insertPlayer(db, 5, "Gabriel Magalhaes", "DF", 2, 0);
        insertPlayer(db, 5, "Ben White", "DF", 0, 0);
        insertPlayer(db, 5, "Takehiro Tomiyasu", "DF", 0, 1);
        insertPlayer(db, 5, "Aaron Ramsdale", "GK", 0, 0);

        insertPlayer(db, 6, "Harry Kane", "FW", 1, 1);
        insertPlayer(db, 6, "Lucas Moura", "MF", 1, 1);
        insertPlayer(db, 6, "Heung-Min Son", "FW", 6, 2);
        insertPlayer(db, 6, "Japhet Tanganga", "DF", 0, 0);
        insertPlayer(db, 6, "Oliver Skipp", "MF", 0, 0);
        insertPlayer(db, 6, "Pierre-Emile Hojbjerg", "MF", 2, 1);
        insertPlayer(db, 6, "Sergio Reguilon", "DF", 1, 3);
        insertPlayer(db, 6, "Eric Dier", "DF", 0, 0);
        insertPlayer(db, 6, "Davinson Sanchez", "DF", 1, 0);
        insertPlayer(db, 6, "Ben Davies", "DF", 0, 1);
        insertPlayer(db, 6, "Hugo Llories", "GK", 0, 0);

        insertPlayer(db, 7, "Richarlison", "FW", 3, 2);
        insertPlayer(db, 7, "Demarai Grey", "FW", 5, 2);
        insertPlayer(db, 7, "Andre Gomes", "MF", 0, 1);
        insertPlayer(db, 7, "Abdoulaye Doucoure", "MF", 2, 4);
        insertPlayer(db, 7, "Andres Townsend", "MF", 3, 2);
        insertPlayer(db, 7, "Fabian Delph", "MF", 0, 0);
        insertPlayer(db, 7, "Ben Godfrey", "DF", 0, 0);
        insertPlayer(db, 7, "Michael Keane", "DF", 1, 2);
        insertPlayer(db, 7, "Mason Holgate", "DF", 0, 0);
        insertPlayer(db, 7, "Seamus Coleman", "DF", 0, 0);
        insertPlayer(db, 7, "Jordan Pickford", "GK", 0, 0);

        insertPlayer(db, 8, "Odsonne Edouard", "FW", 3, 0);
        insertPlayer(db, 8, "Jordan Ayew", "FW", 0, 2);
        insertPlayer(db, 8, "Wilfred Zaha", "FW", 4, 1);
        insertPlayer(db, 8, "Conor Gallagher", "MF", 6, 3);
        insertPlayer(db, 8, "Will Hughes", "MF", 0, 1);
        insertPlayer(db, 8, "Cheikhou Kouyate", "DF", 0, 1);
        insertPlayer(db, 8, "Joel Ward", "DF", 0, 0);
        insertPlayer(db, 8, "James Tomkins", "DF", 0, 1);
        insertPlayer(db, 8, "Marc Guiehi", "DF", 2, 0);
        insertPlayer(db, 8, "Tyrick Mitchell", "DF", 0, 1);
        insertPlayer(db, 8, "Vincente Guaita", "GK", 0, 0);

        insertPlayer(db, 9, "Daniel James", "FW", 1, 1);
        insertPlayer(db, 9, "Raphinha", "MF", 7, 1);
        insertPlayer(db, 9, "Tyler Roberts", "MF", 1, 1);
        insertPlayer(db, 9, "Jack Harrison", "MF", 0, 1);
        insertPlayer(db, 9, "Adam Forshaw", "MF", 0, 0);
        insertPlayer(db, 9, "Jamie Shackleton", "MF", 0, 0);
        insertPlayer(db, 9, "Junior Firpo", "DF", 0, 0);
        insertPlayer(db, 9, "Diego Llorente", "DF", 1, 1);
        insertPlayer(db, 9, "Luke Ayling", "DF", 1, 1);
        insertPlayer(db, 9, "Stuart Dallas", "DF", 0, 1);
        insertPlayer(db, 9, "Illan Meslier", "GK", 0, 0);

        insertPlayer(db, 10, "Jamie Vardy", "FW", 9, 1);
        insertPlayer(db, 10, "James Madison", "MF", 4, 3);
        insertPlayer(db, 10, "Kiernan Dewsbury-Hall", "MF", 0, 0);
        insertPlayer(db, 10, "Harvey Barnes", "MF", 2, 2);
        insertPlayer(db, 10, "Youri Tielemans", "MF", 5, 2);
        insertPlayer(db, 10, "Wilfred Ndidi", "MF", 0, 0);
        insertPlayer(db, 10, "Timothy Castagne", "DF", 0, 0);
        insertPlayer(db, 10, "Jonny Evans", "DF", 1, 1);
        insertPlayer(db, 10, "Caglar Soyuncu", "DF", 1, 0);
        insertPlayer(db, 10, "Luke Thomas", "DF", 0, 1);
        insertPlayer(db, 10, "Kasper Schmeichel", "GK", 0, 0);

        insertPlayer(db, 11, "Joelinton", "FW", 1, 1);
        insertPlayer(db, 11, "Callum Wilson", "FW", 6, 0);
        insertPlayer(db, 11, "Allan Saint-Maximin", "FW", 3, 3);
        insertPlayer(db, 11, "Joe Willock", "MF", 0, 0);
        insertPlayer(db, 11, "Jonjo Shelvey", "MF", 0, 0);
        insertPlayer(db, 11, "Miguel Almiron", "MF", 0, 0);
        insertPlayer(db, 11, "Jamal Lewis", "DF", 0, 0);
        insertPlayer(db, 11, "Jamaal Lascelles", "DF", 1, 0);
        insertPlayer(db, 11, "Fabian Schar", "DF", 0, 1);
        insertPlayer(db, 11, "Javier Manquillo", "DF", 1, 2);
        insertPlayer(db, 11, "Martin Dubravka", "GK", 0, 0);

        insertPlayer(db, 12, "Teemu Pukki", "FW", 5, 0);
        insertPlayer(db, 12, "Przemyslaw Placheta", "MF", 0, 0);
        insertPlayer(db, 12, "Josh Sargent", "FW", 0, 0);
        insertPlayer(db, 12, "Lukas Rupp", "MF", 0, 0);
        insertPlayer(db, 12, "Billy Gilmour", "MF", 0, 1);
        insertPlayer(db, 12, "Kenny McLean", "MF", 0, 0);
        insertPlayer(db, 12, "Max Aarons", "DF", 0, 1);
        insertPlayer(db, 12, "Grant Hanley", "DF", 1, 0);
        insertPlayer(db, 12, "Ozan Kabak", "DF", 0, 1);
        insertPlayer(db, 12, "Javier Manquillo", "DF", 1, 2);
        insertPlayer(db, 12, "Martin Dubravka", "GK", 0, 0);

        insertPlayer(db, 13, "Adam Armstrong", "FW", 2, 2);
        insertPlayer(db, 13, "Armando Broja", "FW", 3, 0);
        insertPlayer(db, 13, "Nathan Tella", "MF", 0, 0);
        insertPlayer(db, 13, "Ibrahim Diallo", "MF", 0, 1);
        insertPlayer(db, 13, "James Ward-Prowse", "MF", 2, 0);
        insertPlayer(db, 13, "Nathan Redmond", "MF", 0, 4);
        insertPlayer(db, 13, "Kyle Walker-Peters", "DF", 0, 0);
        insertPlayer(db, 13, "Jan Bednarek", "DF", 1, 0);
        insertPlayer(db, 13, "Jack Stephens", "DF", 0, 0);
        insertPlayer(db, 13, "Valentino Livramento", "DF", 1, 0);
        insertPlayer(db, 13, "Willy Caballero", "GK", 0, 0);

        insertPlayer(db, 14, "Emmanuel Dennis", "FW", 7, 5);
        insertPlayer(db, 14, "Joshua King", "FW", 5, 2);
        insertPlayer(db, 14, "Tom Cleverley", "MF", 0, 2);
        insertPlayer(db, 14, "Cucho Hernandez", "FW", 2, 1);
        insertPlayer(db, 14, "Moussa Sissoko", "MF", 0, 1);
        insertPlayer(db, 14, "Juraj Kucka", "MF", 1, 0);
        insertPlayer(db, 14, "Jeremy Ngakia", "DF", 0, 0);
        insertPlayer(db, 14, "Craig Cathcart", "DF", 0, 1);
        insertPlayer(db, 14, "William Troost-Ekong", "DF", 0, 0);
        insertPlayer(db, 14, "Kiko Femenia", "DF", 0, 2);
        insertPlayer(db, 14, "Daniel Bachmann", "GK", 0, 0);

        insertPlayer(db, 15, "Michail Antonio", "FW", 3, 2);
        insertPlayer(db, 15, "Pablo Fornals", "MF", 2, 1);
        insertPlayer(db, 15, "Said Benrahma", "MF", 3, 1);
        insertPlayer(db, 15, "Jarrod Bowen", "MF", 2, 1);
        insertPlayer(db, 15, "Tomas Soucek", "MF", 0, 1);
        insertPlayer(db, 15, "Declan Rice", "MF", 2, 1);
        insertPlayer(db, 15, "Aaron Cresswell", "DF", 0, 0);
        insertPlayer(db, 15, "Angelo Ogbonna", "DF", 0, 1);
        insertPlayer(db, 15, "Kurt Zouma", "DF", 0, 0);
        insertPlayer(db, 15, "Ben Johnson", "DF", 0, 2);
        insertPlayer(db, 15, "Lukasz Fabianski", "GK", 0, 0);

        insertPlayer(db, 16, "Raul Jimenez", "FW", 4, 3);
        insertPlayer(db, 16, "Daniel Podence", "MF", 2, 1);
        insertPlayer(db, 16, "Hee-Chan Hwang", "MF", 2, 1);
        insertPlayer(db, 16, "Rayan Ait Noura", "MF", 2, 0);
        insertPlayer(db, 16, "Joao Moutinho", "MF", 0, 0);
        insertPlayer(db, 16, "Ruben Neves", "MF", 0, 0);
        insertPlayer(db, 16, "Nelson Semedo", "DF", 0, 0);
        insertPlayer(db, 16, "Max Kilman", "DF", 0, 1);
        insertPlayer(db, 16, "Conor Coady", "DF", 0, 0);
        insertPlayer(db, 16, "Roman Saiss", "DF", 0, 2);
        insertPlayer(db, 16, "Jose Sa", "GK", 0, 0);

        insertPlayer(db, 17, "Ollie Watkins", "FW", 3, 1);
        insertPlayer(db, 17, "Danny Ings", "MF", 2, 4);
        insertPlayer(db, 17, "Emiliano Buendia", "MF", 2, 1);
        insertPlayer(db, 17, "Matty Cash", "MF", 2, 0);
        insertPlayer(db, 17, "John McGinn", "MF", 1, 0);
        insertPlayer(db, 17, "Douglas Luiz", "MF", 0, 1);
        insertPlayer(db, 17, "Matt Targett", "MF", 0, 1);
        insertPlayer(db, 17, "Ezri Konsa", "DF", 0, 1);
        insertPlayer(db, 17, "Axel Tuanzebe", "DF", 0, 0);
        insertPlayer(db, 17, "Tyrone Mings", "DF", 0, 2);
        insertPlayer(db, 17, "Emiliano Martinez", "GK", 0, 0);

        insertPlayer(db, 18, "Marcus Forss", "FW", 3, 1);
        insertPlayer(db, 18, "Ivan Toney", "FW", 2, 0);
        insertPlayer(db, 18, "R. Henry", "MF", 0, 1);
        insertPlayer(db, 18, "M. Jensen", "MF", 2, 0);
        insertPlayer(db, 18, "C. Norgaard", "MF", 1, 0);
        insertPlayer(db, 18, "F. Onyeka", "MF", 0, 1);
        insertPlayer(db, 18, "S. Canos", "MF", 0, 1);
        insertPlayer(db, 18, "Zanka", "DF", 0, 1);
        insertPlayer(db, 18, "Pontus Jansson", "DF", 0, 0);
        insertPlayer(db, 18, "Ethan Pinnock", "DF", 0, 2);
        insertPlayer(db, 18, "Alvaro Fernandez", "GK", 0, 0);

        insertPlayer(db, 19, "Leonardo Trossard", "FW", 3, 1);
        insertPlayer(db, 19, "Solly March", "MF", 2, 0);
        insertPlayer(db, 19, "Enock Mwepu", "MF", 0, 1);
        insertPlayer(db, 19, "Jakub Moder", "MF", 2, 0);
        insertPlayer(db, 19, "Yves Bissouma", "MF", 1, 0);
        insertPlayer(db, 19, "Pascal Grob", "MF", 0, 1);
        insertPlayer(db, 19, "Tariq Lamptey", "MF", 0, 1);
        insertPlayer(db, 19, "Joel Veltmen", "DF", 0, 1);
        insertPlayer(db, 19, "Dan Burn", "DF", 0, 0);
        insertPlayer(db, 19, "Marc Cucurella", "DF", 0, 2);
        insertPlayer(db, 19, "Robert Sanchez", "GK", 0, 0);

        insertPlayer(db, 20, "Jay Rodriguez", "FW", 3, 1);
        insertPlayer(db, 20, "Chris Wood", "FW", 3, 1);
        insertPlayer(db, 20, "Dwight McNeil", "MF", 2, 0);
        insertPlayer(db, 20, "Jack Cork", "MF", 0, 1);
        insertPlayer(db, 20, "Ashley Westwood", "MF", 2, 0);
        insertPlayer(db, 20, "Johann Guomundsson", "MF", 1, 0);
        insertPlayer(db, 20, "Mathew Lowton", "DF", 0, 1);
        insertPlayer(db, 20, "James Tarkowski", "DF", 0, 1);
        insertPlayer(db, 20, "Ben Mee", "DF", 0, 1);
        insertPlayer(db, 20, "Charlie Taylor", "DF", 0, 0);
        insertPlayer(db, 20, "Nick Pope", "GK", 0, 0);

    }

    public static void insertTeam(SQLiteDatabase db, int LeagueID, String name, int Standing, int TimageID) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("T_LeagueID", LeagueID);
        contentValues.put("T_Name", name);
        contentValues.put("T_Standing", Standing);
        contentValues.put("T_IMAGE_RESOURCE_ID", TimageID);
        db.insert("TEAMS", null, contentValues);
    }

    public static void insertPlayer(SQLiteDatabase db, int PTeamID, String PName, String PPos, int PGoals, int PAssists) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("P_TeamID", PTeamID);
        contentValues.put("P_Name", PName);
        contentValues.put("P_Position", PPos);
        contentValues.put("P_Goals", PGoals);
        contentValues.put("P_Assists", PAssists);
        db.insert("PLAYERS", null, contentValues);
    }

    public static void insertBookings(SQLiteDatabase db, int MatchID, int TotalTickets) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("B_MatchID", MatchID);
        contentValues.put("B_TotalTickets", TotalTickets);
        db.insert("BOOKINGS", null, contentValues);
    }

    public static void insertMatch(SQLiteDatabase db, int matchID, int HomeTeamID, int AwayTeamID, int HomeScore, int AwayScore, String MDate, String MStadium) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("M_id", matchID);
        contentValues.put("M_HomeTeamID", HomeTeamID);
        contentValues.put("M_AwayTeamID", AwayTeamID);
        contentValues.put("M_HomeTeamScore", HomeScore);
        contentValues.put("M_AwayTeamScore", AwayScore);
        contentValues.put("M_DATE", MDate);
        contentValues.put("M_STADIUM", MStadium);
        db.insert("MATCHES", null, contentValues);
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

    public Cursor getMatchesTemporary() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "SELECT t1.T_Name, t2.T_Name, t1.T_IMAGE_RESOURCE_ID, t2.T_IMAGE_RESOURCE_ID, m.M_HomeTeamScore, m.M_AwayTeamScore, m.M_DATE, m.M_STADIUM FROM MATCHES m, TEAMS t1, TEAMS t2 WHERE m.M_HomeTeamID = t1.T_id AND m.M_AwayTeamID = t2.T_id";
        Cursor data = db.rawQuery(qry, null);
        return data;
    }


    public Cursor getTeamPlayers(String teamName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT t.T_Name, p.P_Name, p.P_Position, p.P_Goals, p.P_Assists FROM PLAYERS p, TEAMS t WHERE t.T_id = p.P_TeamID AND t.T_Name= ?", new String[]{teamName});
        return cursor;
    }

    public Cursor getSpecificMatch(String teamname1, String teamname2) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT t1.T_Name, t2.T_Name, t1.T_IMAGE_RESOURCE_ID, t2.T_IMAGE_RESOURCE_ID, m.M_HomeTeamScore, m.M_AwayTeamScore, m.M_DATE, m.M_STADIUM FROM MATCHES m, TEAMS t1, TEAMS t2 WHERE t1.T_Name = ?  AND t2.T_Name = ?", new String[]{teamname1, teamname2});
        return cursor;
    }

    public Cursor getSpecificTeamID(String teamname1, String teamname2) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT t1.T_id, t2.T_id FROM TEAMS t1, TEAMS t2 WHERE t1.T_Name = ? AND t2.T_Name = ?", new String[]{teamname1, teamname2});
        return cursor;
    }

}

