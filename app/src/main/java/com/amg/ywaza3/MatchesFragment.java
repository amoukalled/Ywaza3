package com.amg.ywaza3;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amg.ywaza3.placeholder.PlaceholderContent;

public class MatchesFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView matchesRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_matches_list, container, false);

        String[] HomeTeamName = new String[Matches.matches.length];
        for (int i = 0; i < HomeTeamName.length; i++) {
            HomeTeamName[i] = Matches.matches[i].getHometeam();
        }

        String[] AwayTeamName = new String[Matches.matches.length];
        for (int i = 0; i < HomeTeamName.length; i++) {
            AwayTeamName[i] = Matches.matches[i].getAwayteam();
        }

        int[] HomeImage = new int[Matches.matches.length];
        for (int i = 0; i < HomeImage.length; i++) {
            HomeImage[i] = Matches.matches[i].getHometeamimageId();
        }

        int[] AwayImage = new int[Matches.matches.length];
        for (int i = 0; i < AwayImage.length; i++) {
            AwayImage[i] = Matches.matches[i].getAwayteamimageId();
        }

        int[] HomeScore = new int[Matches.matches.length];
        for (int i = 0; i < HomeScore.length; i++) {
            HomeScore[i] = Matches.matches[i].getHomescore();
        }

        int[] AwayScore = new int[Matches.matches.length];
        for (int i = 0; i < AwayScore.length; i++) {
            AwayScore[i] = Matches.matches[i].getAwayscore();
        }


        MatchesRecyclerViewAdapter matchesRecyclerViewAdapter = new MatchesRecyclerViewAdapter(HomeTeamName, AwayTeamName, HomeImage, AwayImage,HomeScore,AwayScore);
        matchesRecycler.setAdapter(matchesRecyclerViewAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        matchesRecycler.setLayoutManager(layoutManager);

        return matchesRecycler;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
    }
}