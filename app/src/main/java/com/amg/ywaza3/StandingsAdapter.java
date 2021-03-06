package com.amg.ywaza3;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.ViewHolder> {

    Context tContext;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView teamName, teamStanding;
        ImageView teamLogo;
        CardView cV;

        public ViewHolder(final View itemView) {
            super(itemView);
            teamName = (TextView) itemView.findViewById(R.id.show_name_in_standings_listview);
            teamStanding = (TextView) itemView.findViewById(R.id.show_ranking_in_standings_listview);
            teamLogo = (ImageView) itemView.findViewById(R.id.show_logo_in_standings_listview);
            cV = (CardView) itemView.findViewById(R.id.standings_cardview);
        }
    }

    private List<StandingModel> mStanding;

    public StandingsAdapter(List<StandingModel> standings, Context context) {
        mStanding = standings;
        tContext = context;
    }

    @Override
    public StandingsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.recycler_standings, parent, false);
        StandingsAdapter.ViewHolder viewHolder = new StandingsAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StandingsAdapter.ViewHolder viewHolder, int position) {
        StandingModel standingModel = mStanding.get(position);
        TextView mTeam = viewHolder.teamName;
        TextView mStandings = viewHolder.teamStanding;
        ImageView mLogo = viewHolder.teamLogo;
        mTeam.setText(standingModel.getTeamName());
        mStandings.setText(String.valueOf(standingModel.getTeamStanding()));
        mLogo.setImageResource(standingModel.getLogoID());

        viewHolder.cV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeamPlayersFragment teamPlayersFragment = new TeamPlayersFragment();
                FragmentTransaction ft = ((FragmentActivity) tContext).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container_homepage, teamPlayersFragment).commit();
                Bundle arguments = new Bundle();
                arguments.putString("team", standingModel.getTeamName());
                teamPlayersFragment.setArguments(arguments);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStanding.size();
    }
}
