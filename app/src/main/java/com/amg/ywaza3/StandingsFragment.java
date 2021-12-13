package com.amg.ywaza3;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StandingsFragment extends Fragment {

    RecyclerView recyclerView;
    TeamSQLiteOpenHelper sqLiteOpenHelper;
    List<StandingModel> standingList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();

        if (view != null) {
            sqLiteOpenHelper = new TeamSQLiteOpenHelper(getContext());
            recyclerView = (RecyclerView) view.findViewById(R.id.rv);

            Cursor data = sqLiteOpenHelper.getTeamStanding();
            int i = 0;
            if (data.getCount() != 0) {
                while (data.moveToNext()) {
                    StandingModel standings = new StandingModel(data.getString(0), data.getInt(1), data.getInt(2));
                    standingList.add(i, standings);
                    i++;
                }
                StandingsAdapter adapter = new StandingsAdapter(standingList, getContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager((new LinearLayoutManager(getContext())));
            } else {
                Toast.makeText(getContext(), "There is no data to show!", Toast.LENGTH_LONG).show();
            }

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_standings, container, false);
    }
}
