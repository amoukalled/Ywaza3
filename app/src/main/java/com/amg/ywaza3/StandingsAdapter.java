package com.amg.ywaza3;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.ViewHolder> {

    Context tContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView teamName, teamStanding;
        ImageView teamLogo;

        public ViewHolder(final View itemView) {
            super(itemView);
            teamName = (TextView) itemView.findViewById(R.id.show_name_in_standings_listview);
            teamStanding = (TextView) itemView.findViewById(R.id.show_ranking_in_standings_listview);
            teamLogo = (ImageView) itemView.findViewById(R.id.show_logo_in_standings_listview);
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
    }

    @Override
    public int getItemCount() {
        return mStanding.size();
    }
}
