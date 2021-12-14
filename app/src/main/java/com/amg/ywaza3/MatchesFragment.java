package com.amg.ywaza3;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MatchesFragment extends Fragment {

    RecyclerView recyclerView;
    TeamSQLiteOpenHelper sqLiteOpenHelper;
    List<MatchesModel> matchesList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();

        if (view != null) {
            sqLiteOpenHelper = new TeamSQLiteOpenHelper(getContext());
            recyclerView = (RecyclerView) view.findViewById(R.id.matches_recycler);

            Cursor data = sqLiteOpenHelper.getMatchesTemporary();
            int i = 0;
            if (data.getCount() != 0) {
                while (data.moveToNext()) {
                    MatchesModel matches = new MatchesModel(data.getString(0), data.getString(1), data.getInt(2), data.getInt(3), data.getInt(4), data.getInt(5), data.getString(6), data.getString(7));
                    matchesList.add(i, matches);
                    i++;
                }
                MatchesRecyclerViewAdapter adapter = new MatchesRecyclerViewAdapter(matchesList, getContext());
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
        return inflater.inflate(R.layout.fragment_matches_list, container, false);
    }
}
