package com.amg.ywaza3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FavouriteTeamActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TeamSQLiteOpenHelper sqLiteOpenHelper;
    List<TeamModel> teamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_team);

        sqLiteOpenHelper = new TeamSQLiteOpenHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv);

        Cursor data = sqLiteOpenHelper.getTeamData();
        int i = 0;
        if (data.getCount() != 0) {
            while (data.moveToNext()) {
                TeamModel teams = new TeamModel(data.getString(0));
                teamList.add(i, teams);
                i++;
            }
            FavouriteTeamAdapter adapter = new FavouriteTeamAdapter(teamList, getApplicationContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        } else {
            Toast.makeText(FavouriteTeamActivity.this, "There is no data to show!", Toast.LENGTH_LONG).show();
        }


    }
}