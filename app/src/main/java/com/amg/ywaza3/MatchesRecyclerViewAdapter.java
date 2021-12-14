package com.amg.ywaza3;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MatchesRecyclerViewAdapter extends RecyclerView.Adapter<MatchesRecyclerViewAdapter.ViewHolder> {

    private String[] hometeams;
    private String[] awayteams;
    private int[] homeimageId;
    private int[] awayimageId;
    private int[] homescores;
    private int[] awayscores;


    public MatchesRecyclerViewAdapter(String[] hometeams, String[] awayteams, int[] homeimageId, int[] awayimageId, int[] homescores, int[] awayscores) {
        this.hometeams = hometeams;
        this.awayteams = awayteams;
        this.homeimageId = homeimageId;
        this.awayimageId = awayimageId;
        this.homescores = homescores;
        this.awayscores = awayscores;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_captioned_image, viewGroup, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        CardView cardView = viewHolder.cardView;

        TextView hometeam = cardView.findViewById(R.id.home_team_text_view);
        hometeam.setText(hometeams[position]);

        TextView awayteam = cardView.findViewById(R.id.away_team_text_view);
        awayteam.setText(awayteams[position]);

        ImageView homeImage = cardView.findViewById(R.id.home_team_image_view);
        homeImage.setImageResource(homeimageId[position]);

        ImageView awayImage = cardView.findViewById(R.id.away_team_image_view);
        awayImage.setImageResource(awayimageId[position]);

        TextView homescore = cardView.findViewById(R.id.home_team_score_text_view);
        homescore.setText(String.valueOf(homescores[position]));

        TextView awayscore = cardView.findViewById(R.id.away_team_score_text_view);
        awayscore.setText(String.valueOf(awayscores[position]));

    }

    @Override
    public int getItemCount() {
        return hometeams.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cv) {
            super(cv);
            cardView = cv;

        }
    }
}
