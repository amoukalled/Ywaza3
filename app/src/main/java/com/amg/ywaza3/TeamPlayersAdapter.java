package com.amg.ywaza3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeamPlayersAdapter extends RecyclerView.Adapter<TeamPlayersAdapter.ViewHolder> {

    Context tContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tName, pName, pPosition, pGoals, pAssists;

        public ViewHolder(final View itemView) {
            super(itemView);
            pName = (TextView) itemView.findViewById(R.id.textview_name);
            pPosition = (TextView) itemView.findViewById(R.id.textview_position);
            pGoals = (TextView) itemView.findViewById(R.id.textview_goals);
            pAssists = (TextView) itemView.findViewById(R.id.textview_assists);
        }
    }

    private List<PlayerModel> mPlayer;

    public TeamPlayersAdapter(List<PlayerModel> players, Context context) {
        mPlayer = players;
        tContext = context;
    }

    @Override
    public TeamPlayersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.recycler_team_players, parent, false);
        TeamPlayersAdapter.ViewHolder viewHolder = new TeamPlayersAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TeamPlayersAdapter.ViewHolder viewHolder, int position) {
        PlayerModel playerModel = mPlayer.get(position);

        TextView playerName = viewHolder.pName;
        TextView playerPosition = viewHolder.pPosition;
        TextView playerGoals = viewHolder.pGoals;
        TextView playerAssists = viewHolder.pAssists;

        playerName.setText(playerModel.getpName());
        playerPosition.setText(playerModel.getpPosition());
        playerGoals.setText(String.valueOf(playerModel.getpGoals()));
        playerAssists.setText(String.valueOf(playerModel.getpAssists()));

    }

    @Override
    public int getItemCount() {
        return mPlayer.size();
    }


}
