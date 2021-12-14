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
                "P_Position TEXT," +
                "P_Goals INTEGER," +
                "P_Assists INTEGER);");


        insertPlayer(db, 0, "Romely Lukaku", "FW", 3, 0);
        insertPlayer(db, 0, "Kai Havertz", "FW", 2, 1);
        insertPlayer(db, 0, "Mason Mount", "MF", 6, 4);
        insertPlayer(db, 0, "Marcos Alonso", "MF", 1, 2);
        insertPlayer(db, 0, "Jorginho", "MF", 4, 1);
        insertPlayer(db, 0, "Kovacic", "MF", 1, 5);
        insertPlayer(db, 0, "Reece James", "DF", 4, 4);
        insertPlayer(db, 0, "Cesar Azpilicueta", "DF", 0, 2);
        insertPlayer(db, 0, "Thiago Silva", "DF", 2, 0);
        insertPlayer(db, 0, "Antonio Rudiger", "DF", 2, 0);
        insertPlayer(db, 0, "Edouard Mendy", "GK", 0, 0);

        insertPlayer(db, 1, "Gabriel Jesus", "FW", 2, 6);
        insertPlayer(db, 1, "Raheem Sterling", "FW", 8, 4);
        insertPlayer(db, 1, "Jack Grealish", "MF", 1, 2);
        insertPlayer(db, 1, "Bernardo Silva", "MF", 7, 1);
        insertPlayer(db, 1, "Kevin DeBruyne", "MF", 2, 0);
        insertPlayer(db, 1, "Rodri", "MF", 2, 0);
        insertPlayer(db, 1, "Oleksandr Zinchenko", "DF", 0, 0);
        insertPlayer(db, 1, "Aymeric Laporte", "DF", 1, 0);
        insertPlayer(db, 1, "Ruben Dias", "DF", 1, 1);
        insertPlayer(db, 1, "Joao Cancelo", "DF", 0, 3);
        insertPlayer(db, 1, "Ederson", "GK", 0, 0);

        insertPlayer(db, 2, "Mohammed Salah", "FW", 14, 9);
        insertPlayer(db, 2, "Diogo Jota", "FW", 8, 1);
        insertPlayer(db, 2, "Sadio Mane", "FW", 7, 1);
        insertPlayer(db, 2, "Thiago Alcantara", "MF", 1, 1);
        insertPlayer(db, 2, "Fabinho", "MF", 1, 1);
        insertPlayer(db, 2, "Jordan Henderson", "MF", 2, 3);
        insertPlayer(db, 2, "Andrew Robertson", "DF", 0, 4);
        insertPlayer(db, 2, "Virgil Van Dijk", "DF", 1, 1);
        insertPlayer(db, 2, "Joel Matip", "DF", 0, 0);
        insertPlayer(db, 2, "Trent Alexander-Arnold", "DF", 1, 7);
        insertPlayer(db, 2, "Allison", "GK", 0, 0);

        insertPlayer(db, 3, "Marcus Rashford", "MF", 2, 1);
        insertPlayer(db, 3, "Cristiano Ronaldo", "FW", 7, 2);
        insertPlayer(db, 3, "Bruno Fernandes", "MF", 5, 3);
        insertPlayer(db, 3, "Jadon Sancho", "MF", 1, 0);
        insertPlayer(db, 3, "Fred", "MF", 2, 1);
        insertPlayer(db, 3, "Scott McTominay", "MF", 0, 0);
        insertPlayer(db, 3, "Alex Telles", "DF", 0, 0);
        insertPlayer(db, 3, "Harry Maguire", "DF", 0, 0);
        insertPlayer(db, 3, "Victor Lindelof", "DF", 0, 2);
        insertPlayer(db, 3, "Aaron Wan-Bissaka", "DF", 0, 0);
        insertPlayer(db, 3, "David De Gea", "GK", 0, 0);

        insertPlayer(db, 4, "Pierre-Emerick Aubameyang", "FW", 4, 1);
        insertPlayer(db, 4, "Martin Odergaard", "MF", 4, 0);
        insertPlayer(db, 4, "Emile Smith Rowe", "MF", 5, 2);
        insertPlayer(db, 4, "Mohamed Elneny", "MF", 0, 1);
        insertPlayer(db, 4, "Thomas Partey", "MF", 1, 0);
        insertPlayer(db, 4, "Gabriel Martinelli", "MF", 1, 2);
        insertPlayer(db, 4, "Nuno Tavares", "DF", 0, 1);
        insertPlayer(db, 4, "Gabriel Magalhaes", "DF", 2, 0);
        insertPlayer(db, 4, "Ben White", "DF", 0, 0);
        insertPlayer(db, 4, "Takehiro Tomiyasu", "DF", 0, 1);
        insertPlayer(db, 4, "Aaron Ramsdale", "GK", 0, 0);

        insertPlayer(db, 5, "Harry Kane", "FW", 1, 1);
        insertPlayer(db, 5, "Lucas Moura", "MF", 1, 1);
        insertPlayer(db, 5, "Heung-Min Son", "FW", 6, 2);
        insertPlayer(db, 5, "Japhet Tanganga", "DF", 0, 0);
        insertPlayer(db, 5, "Oliver Skipp", "MF", 0, 0);
        insertPlayer(db, 5, "Pierre-Emile Hojbjerg", "MF", 2, 1);
        insertPlayer(db, 5, "Sergio Reguilon", "DF", 1, 3);
        insertPlayer(db, 5, "Eric Dier", "DF", 0, 0);
        insertPlayer(db, 5, "Davinson Sanchez", "DF", 1, 0);
        insertPlayer(db, 5, "Ben Davies", "DF", 0, 1);
        insertPlayer(db, 5, "Hugo Llories", "GK", 0, 0);

        insertPlayer(db, 6, "Richarlison", "FW", 3, 2);
        insertPlayer(db, 6, "Demarai Grey", "FW", 5, 2);
        insertPlayer(db, 6, "Andre Gomes", "MF", 0, 1);
        insertPlayer(db, 6, "Abdoulaye Doucoure", "MF", 2, 4);
        insertPlayer(db, 6, "Andres Townsend", "MF", 3, 2);
        insertPlayer(db, 6, "Fabian Delph", "MF", 0, 0);
        insertPlayer(db, 6, "Ben Godfrey", "DF", 0, 0);
        insertPlayer(db, 6, "Michael Keane", "DF", 1, 2);
        insertPlayer(db, 6, "Mason Holgate", "DF", 0, 0);
        insertPlayer(db, 6, "Seamus Coleman", "DF", 0, 0);
        insertPlayer(db, 6, "Jordan Pickford", "GK", 0, 0);

        insertPlayer(db, 7, "Odsonne Edouard", "FW", 3, 0);
        insertPlayer(db, 7, "Jordan Ayew", "FW", 0, 2);
        insertPlayer(db, 7, "Wilfred Zaha", "FW", 4, 1);
        insertPlayer(db, 7, "Conor Gallagher", "MF", 6, 3);
        insertPlayer(db, 7, "Will Hughes", "MF", 0, 1);
        insertPlayer(db, 7, "Cheikhou Kouyate", "DF", 0, 1);
        insertPlayer(db, 7, "Joel Ward", "DF", 0, 0);
        insertPlayer(db, 7, "James Tomkins", "DF", 0, 1);
        insertPlayer(db, 7, "Marc Guiehi", "DF", 2, 0);
        insertPlayer(db, 7, "Tyrick Mitchell", "DF", 0, 1);
        insertPlayer(db, 7, "Vincente Guaita", "GK", 0, 0);

        insertPlayer(db, 8, "Daniel James", "FW", 1, 1);
        insertPlayer(db, 8, "Raphinha", "MF", 7, 1);
        insertPlayer(db, 8, "Tyler Roberts", "MF", 1, 1);
        insertPlayer(db, 8, "Jack Harrison", "MF", 0, 1);
        insertPlayer(db, 8, "Adam Forshaw", "MF", 0, 0);
        insertPlayer(db, 8, "Jamie Shackleton", "MF", 0, 0);
        insertPlayer(db, 8, "Junior Firpo", "DF", 0, 0);
        insertPlayer(db, 8, "Diego Llorente", "DF", 1, 1);
        insertPlayer(db, 8, "Luke Ayling", "DF", 1, 1);
        insertPlayer(db, 8, "Stuart Dallas", "DF", 0, 1);
        insertPlayer(db, 8, "Illan Meslier", "GK", 0, 0);

        insertPlayer(db, 9, "Jamie Vardy", "FW", 9, 1);
        insertPlayer(db, 9, "James Madison", "MF", 4, 3);
        insertPlayer(db, 9, "Kiernan Dewsbury-Hall", "MF", 0, 0);
        insertPlayer(db, 9, "Harvey Barnes", "MF", 2, 2);
        insertPlayer(db, 9, "Youri Tielemans", "MF", 5, 2);
        insertPlayer(db, 9, "Wilfred Ndidi", "MF", 0, 0);
        insertPlayer(db, 9, "Timothy Castagne", "DF", 0, 0);
        insertPlayer(db, 9, "Jonny Evans", "DF", 1, 1);
        insertPlayer(db, 9, "Caglar Soyuncu", "DF", 1, 0);
        insertPlayer(db, 9, "Luke Thomas", "DF", 0, 1);
        insertPlayer(db, 9, "Kasper Schmeichel", "GK", 0, 0);

        insertPlayer(db, 10, "Joelinton", "FW", 1, 1);
        insertPlayer(db, 10, "Callum Wilson", "FW", 6, 0);
        insertPlayer(db, 10, "Allan Saint-Maximin", "FW", 3, 3);
        insertPlayer(db, 10, "Joe Willock", "MF", 0, 0);
        insertPlayer(db, 10, "Jonjo Shelvey", "MF", 0, 0);
        insertPlayer(db, 10, "Miguel Almiron", "MF", 0, 0);
        insertPlayer(db, 10, "Jamal Lewis", "DF", 0, 0);
        insertPlayer(db, 10, "Jamaal Lascelles", "DF", 1, 0);
        insertPlayer(db, 10, "Fabian Schar", "DF", 0, 1);
        insertPlayer(db, 10, "Javier Manquillo", "DF", 1, 2);
        insertPlayer(db, 10, "Martin Dubravka", "GK", 0, 0);

        insertPlayer(db, 11, "Teemu Pukki", "FW", 5, 0);
        insertPlayer(db, 11, "Przemyslaw Placheta", "MF", 0, 0);
        insertPlayer(db, 11, "Josh Sargent", "FW", 0, 0);
        insertPlayer(db, 11, "Lukas Rupp", "MF", 0, 0);
        insertPlayer(db, 11, "Billy Gilmour", "MF", 0, 1);
        insertPlayer(db, 11, "Kenny McLean", "MF", 0, 0);
        insertPlayer(db, 11, "Max Aarons", "DF", 0, 1);
        insertPlayer(db, 11, "Grant Hanley", "DF", 1, 0);
        insertPlayer(db, 11, "Ozan Kabak", "DF", 0, 1);
        insertPlayer(db, 11, "Javier Manquillo", "DF", 1, 2);
        insertPlayer(db, 11, "Martin Dubravka", "GK", 0, 0);

        insertPlayer(db, 12, "Adam Armstrong", "FW", 2, 2);
        insertPlayer(db, 12, "Armando Broja", "FW", 3, 0);
        insertPlayer(db, 12, "Nathan Tella", "MF", 0, 0);
        insertPlayer(db, 12, "Ibrahim Diallo", "MF", 0, 1);
        insertPlayer(db, 12, "James Ward-Prowse", "MF", 2, 0);
        insertPlayer(db, 12, "Nathan Redmond", "MF", 0, 4);
        insertPlayer(db, 12, "Kyle Walker-Peters", "DF", 0, 0);
        insertPlayer(db, 12, "Jan Bednarek", "DF", 1, 0);
        insertPlayer(db, 12, "Jack Stephens", "DF", 0, 0);
        insertPlayer(db, 12, "Valentino Livramento", "DF", 1, 0);
        insertPlayer(db, 12, "Willy Caballero", "GK", 0, 0);

        insertPlayer(db, 13, "Emmanuel Dennis", "FW", 7, 5);
        insertPlayer(db, 13, "Joshua King", "FW", 5, 2);
        insertPlayer(db, 13, "Tom Cleverley", "MF", 0, 2);
        insertPlayer(db, 13, "Cucho Hernandez", "FW", 2, 1);
        insertPlayer(db, 13, "Moussa Sissoko", "MF", 0, 1);
        insertPlayer(db, 13, "Juraj Kucka", "MF", 1, 0);
        insertPlayer(db, 13, "Jeremy Ngakia", "DF", 0, 0);
        insertPlayer(db, 13, "Craig Cathcart", "DF", 0, 1);
        insertPlayer(db, 13, "William Troost-Ekong", "DF", 0, 0);
        insertPlayer(db, 13, "Kiko Femenia", "DF", 0, 2);
        insertPlayer(db, 13, "Daniel Bachmann", "GK", 0, 0);

        insertPlayer(db, 14, "Michail Antonio", "FW", 3, 2);
        insertPlayer(db, 14, "Pablo Fornals", "MF", 2, 1);
        insertPlayer(db, 14, "Said Benrahma", "MF", 3, 1);
        insertPlayer(db, 14, "Jarrod Bowen", "MF", 2, 1);
        insertPlayer(db, 14, "Tomas Soucek", "MF", 0, 1);
        insertPlayer(db, 14, "Declan Rice", "MF", 2, 1);
        insertPlayer(db, 14, "Aaron Cresswell", "DF", 0, 0);
        insertPlayer(db, 14, "Angelo Ogbonna", "DF", 0, 1);
        insertPlayer(db, 14, "Kurt Zouma", "DF", 0, 0);
        insertPlayer(db, 14, "Ben Johnson", "DF", 0, 2);
        insertPlayer(db, 14, "Lukasz Fabianski", "GK", 0, 0);

        insertPlayer(db, 15, "Raul Jimenez", "FW", 4, 3);
        insertPlayer(db, 15, "Daniel Podence", "MF", 2, 1);
        insertPlayer(db, 15, "Hee-Chan Hwang", "MF", 2, 1);
        insertPlayer(db, 15, "Rayan Ait Noura", "MF", 2, 0);
        insertPlayer(db, 15, "Joao Moutinho", "MF", 0, 0);
        insertPlayer(db, 15, "Ruben Neves", "MF", 0, 0);
        insertPlayer(db, 15, "Nelson Semedo", "DF", 0, 0);
        insertPlayer(db, 15, "Max Kilman", "DF", 0, 1);
        insertPlayer(db, 15, "Conor Coady", "DF", 0, 0);
        insertPlayer(db, 15, "Roman Saiss", "DF", 0, 2);
        insertPlayer(db, 15, "Jose Sa", "GK", 0, 0);

        insertPlayer(db, 16, "Ollie Watkins", "FW", 3, 1);
        insertPlayer(db, 16, "Danny Ings", "MF", 2, 4);
        insertPlayer(db, 16, "Emiliano Buendia", "MF", 2, 1);
        insertPlayer(db, 16, "Matty Cash", "MF", 2, 0);
        insertPlayer(db, 16, "John McGinn", "MF", 1, 0);
        insertPlayer(db, 16, "Douglas Luiz", "MF", 0, 1);
        insertPlayer(db, 16, "Matt Targett", "MF", 0, 1);
        insertPlayer(db, 16, "Ezri Konsa", "DF", 0, 1);
        insertPlayer(db, 16, "Axel Tuanzebe", "DF", 0, 0);
        insertPlayer(db, 16, "Tyrone Mings", "DF", 0, 2);
        insertPlayer(db, 16, "Emiliano Martinez", "GK", 0, 0);

        insertPlayer(db, 17, "Marcus Forss", "FW", 3, 1);
        insertPlayer(db, 17, "Ivan Toney", "FW", 2, 0);
        insertPlayer(db, 17, "R. Henry", "MF", 0, 1);
        insertPlayer(db, 17, "M. Jensen", "MF", 2, 0);
        insertPlayer(db, 17, "C. Norgaard", "MF", 1, 0);
        insertPlayer(db, 17, "F. Onyeka", "MF", 0, 1);
        insertPlayer(db, 17, "S. Canos", "MF", 0, 1);
        insertPlayer(db, 17, "Zanka", "DF", 0, 1);
        insertPlayer(db, 17, "Pontus Jansson", "DF", 0, 0);
        insertPlayer(db, 17, "Ethan Pinnock", "DF", 0, 2);
        insertPlayer(db, 17, "Alvaro Fernandez", "GK", 0, 0);

        insertPlayer(db, 18, "Leonardo Trossard", "FW", 3, 1);
        insertPlayer(db, 18, "Solly March", "MF", 2, 0);
        insertPlayer(db, 18, "Enock Mwepu", "MF", 0, 1);
        insertPlayer(db, 18, "Jakub Moder", "MF", 2, 0);
        insertPlayer(db, 18, "Yves Bissouma", "MF", 1, 0);
        insertPlayer(db, 18, "Pascal Grob", "MF", 0, 1);
        insertPlayer(db, 18, "Tariq Lamptey", "MF", 0, 1);
        insertPlayer(db, 18, "Joel Veltmen", "DF", 0, 1);
        insertPlayer(db, 18, "Dan Burn", "DF", 0, 0);
        insertPlayer(db, 18, "Marc Cucurella", "DF", 0, 2);
        insertPlayer(db, 18, "Robert Sanchez", "GK", 0, 0);

        insertPlayer(db, 19, "Jay Rodriguez", "FW", 3, 1);
        insertPlayer(db, 19, "Chris Wood", "FW", 3, 1);
        insertPlayer(db, 19, "Dwight McNeil", "MF", 2, 0);
        insertPlayer(db, 19, "Jack Cork", "MF", 0, 1);
        insertPlayer(db, 19, "Ashley Westwood", "MF", 2, 0);
        insertPlayer(db, 19, "Johann Guomundsson", "MF", 1, 0);
        insertPlayer(db, 19, "Mathew Lowton", "DF", 0, 1);
        insertPlayer(db, 19, "James Tarkowski", "DF", 0, 1);
        insertPlayer(db, 19, "Ben Mee", "DF", 0, 1);
        insertPlayer(db, 19, "Charlie Taylor", "DF", 0, 0);
        insertPlayer(db, 19, "Nick Pope", "GK", 0, 0);


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

    public static void insertPlayer(SQLiteDatabase db, int PTeamID, String PName, String PPos, int PGoals, int PAssists) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("P_TeamID", PTeamID);
        contentValues.put("P_Name", PName);
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

