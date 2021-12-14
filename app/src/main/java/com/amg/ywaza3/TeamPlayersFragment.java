package com.amg.ywaza3;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TeamPlayersFragment extends Fragment {

    String team;

    RecyclerView recyclerView;
    TeamSQLiteOpenHelper sqLiteOpenHelper;
    List<PlayerModel> playerList = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        team = getArguments().getString("team", "");
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if (view != null) {

            sqLiteOpenHelper = new TeamSQLiteOpenHelper(getContext());
            recyclerView = (RecyclerView) view.findViewById(R.id.rv);

            Cursor data = sqLiteOpenHelper.getTeamPlayers(team);
            int i = 0;
            if (data.getCount() != 0) {
                while (data.moveToNext()) {
                    PlayerModel teams = new PlayerModel(data.getString(0), data.getString(1), data.getString(2), data.getInt(3), data.getInt(4));
                    playerList.add(i, teams);
                    i++;
                }
                TeamPlayersAdapter adapter = new TeamPlayersAdapter(playerList, getContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager((new LinearLayoutManager(getContext())));
            } else {
                Toast.makeText(getContext(), "There is no data to show!", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_players, container, false);
    }
}