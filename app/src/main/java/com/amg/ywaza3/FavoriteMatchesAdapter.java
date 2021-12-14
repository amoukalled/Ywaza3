package com.amg.ywaza3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteMatchesAdapter extends RecyclerView.Adapter<FavoriteMatchesAdapter.ViewHolder> {

    Context tContext;
    private List<FavoriteMatchesModel> mMatches;

    @Override
    public FavoriteMatchesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.card_captioned_image, parent, false);
        FavoriteMatchesAdapter.ViewHolder viewHolder = new FavoriteMatchesAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    public FavoriteMatchesAdapter(List<FavoriteMatchesModel> matches, Context context) {
        mMatches = matches;
        tContext = context;
    }

    @Override
    public void onBindViewHolder(FavoriteMatchesAdapter.ViewHolder viewHolder, int position) {
        FavoriteMatchesModel favoriteMatchesModel = mMatches.get(position);
        ImageView homeTeamLogo = viewHolder.homeImage;
        ImageView awayTeamLogo = viewHolder.awayImage;
        TextView hTeamScore = viewHolder.homeTeamScore;
        TextView aTeamScore = viewHolder.awayTeamScore;
        TextView homeTeamName = viewHolder.homeTeam;
        TextView awayTeamName = viewHolder.awayTeam;
        TextView date = viewHolder.matchDate;


        homeTeamLogo.setImageResource(favoriteMatchesModel.getHomeTeamID());
        awayTeamLogo.setImageResource(favoriteMatchesModel.getAwayTeamID());
        hTeamScore.setText(String.valueOf(favoriteMatchesModel.getHomeScore()));
        aTeamScore.setText(String.valueOf(favoriteMatchesModel.getAwayScore()));
        homeTeamName.setText(favoriteMatchesModel.getHomeTeamName());
        awayTeamName.setText(favoriteMatchesModel.getAwayTeamName());
        date.setText(favoriteMatchesModel.getDate());
    }

    @Override
    public int getItemCount() {
        return mMatches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView favoriteTeamN, homeTeam, awayTeam, homeTeamScore, awayTeamScore, matchDate;
        ImageView favoriteTeamL, homeImage, awayImage;
        CardView cardView;

        public ViewHolder(final View itemView) {
            super(itemView);
            homeTeam = (TextView) itemView.findViewById(R.id.home_team_text_view);
            awayTeam = (TextView) itemView.findViewById(R.id.away_team_text_view);
            homeTeamScore = (TextView) itemView.findViewById(R.id.home_team_score_text_view);
            awayTeamScore = (TextView) itemView.findViewById(R.id.away_team_score_text_view);
            homeImage = (ImageView) itemView.findViewById(R.id.home_team_image_view);
            awayImage = (ImageView) itemView.findViewById(R.id.away_team_image_view);
            matchDate = (TextView) itemView.findViewById(R.id.date_textView);
            cardView = (CardView) itemView.findViewById(R.id.matches_card_view);
        }
    }
}
