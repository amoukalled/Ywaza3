package com.amg.ywaza3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class SpecificMatchAdapter extends RecyclerView.Adapter<SpecificMatchAdapter.ViewHolder> {
    Context tContext;
    int matchID;
    int seats = 0;
    private List<MatchesModel> mMatches;

    public static double homeWinPercentage = 0;
    public static double drawPercentage = 0;
    public static double awayWinPercentage = 0;
    public static double allPercentage = 1;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.recycler_specific_match, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    public SpecificMatchAdapter(List<MatchesModel> matches, int matchID, Context context) {
        mMatches = matches;
        this.matchID = matchID;
        tContext = context;
    }

    @Override
    public void onBindViewHolder(SpecificMatchAdapter.ViewHolder viewHolder, int position) {
        MatchesModel matchesModel = mMatches.get(position);

        TeamSQLiteOpenHelper sqLiteOpenHelper;
        sqLiteOpenHelper = new TeamSQLiteOpenHelper(tContext);
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT B_TotalTickets FROM BOOKINGS WHERE B_MatchID = ?", new String[]{String.valueOf(matchID)});
        if (cursor.moveToFirst()) {
            seats = cursor.getInt(0);
        }

        ImageView homeTeamLogo = viewHolder.homeImage;
        ImageView awayTeamLogo = viewHolder.awayImage;
        TextView hTeamScore = viewHolder.homeTeamScore;
        TextView aTeamScore = viewHolder.awayTeamScore;
        TextView homeTeamName = viewHolder.homeTeam;
        TextView awayTeamName = viewHolder.awayTeam;
        TextView date = viewHolder.matchDate;
        TextView nOfSeats = viewHolder.numberOfSeats;
        TextView stadium = viewHolder.stadium;
        Button bookTicket = viewHolder.book;
        Spinner spinner = viewHolder.bookingSpinner;
        Button homeWin = viewHolder.homeWin;
        Button awayWin = viewHolder.awayWin;
        Button draw = viewHolder.draw;
        TextView homeWinText = viewHolder.homeWinText;
        TextView drawText = viewHolder.drawText;
        TextView awayWinText = viewHolder.awayWinText;

        homeTeamLogo.setImageResource(matchesModel.getHomeTeamID());
        awayTeamLogo.setImageResource(matchesModel.getAwayTeamID());
        hTeamScore.setText(String.valueOf(matchesModel.getHomeScore()));
        aTeamScore.setText(String.valueOf(matchesModel.getAwayScore()));
        homeTeamName.setText(matchesModel.getHomeTeamName());
        awayTeamName.setText(matchesModel.getAwayTeamName());
        date.setText(matchesModel.getDate());
        stadium.setText(matchesModel.getStadium());
        nOfSeats.setText("Number of Seats Left: " + String.valueOf(seats));

        bookTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = spinner.getSelectedItem().toString();
                int nBooks = Integer.parseInt(temp);

                for (int i = 0; i < nBooks; i++) {
                    if (seats != 0) {
                        seats--;
                    } else {
                        Toast.makeText(tContext, "There are no available tickets", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                Cursor cursor = db.rawQuery("UPDATE BOOKINGS SET B_TotalTickets = ? WHERE B_MatchID = ?", new String[]{String.valueOf(seats), String.valueOf(matchID)});
                cursor.moveToFirst();
                cursor.close();
                Toast.makeText(tContext, "You Have Successfully booked a seat!", Toast.LENGTH_SHORT).show();

                MatchesFragment matchesFragment = new MatchesFragment();
                FragmentTransaction ft = ((FragmentActivity) tContext).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container_homepage, matchesFragment).commit();

            }
        });

        String[] values = {"1", "2", "3", "4", "5",};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.tContext, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        homeWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeWinPercentage += 100;
                Toast.makeText(tContext, "You Have Successfully Voted!", Toast.LENGTH_SHORT).show();

                MatchesFragment matchesFragment = new MatchesFragment();
                FragmentTransaction ft = ((FragmentActivity) tContext).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container_homepage, matchesFragment).commit();
            }
        });

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawPercentage += 100;
                Toast.makeText(tContext, "You Have Successfully Voted!", Toast.LENGTH_SHORT).show();

                MatchesFragment matchesFragment = new MatchesFragment();
                FragmentTransaction ft = ((FragmentActivity) tContext).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container_homepage, matchesFragment).commit();
            }
        });

        awayWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayWinPercentage += 100;
                Toast.makeText(tContext, "You Have Successfully Voted!", Toast.LENGTH_SHORT).show();

                MatchesFragment matchesFragment = new MatchesFragment();
                FragmentTransaction ft = ((FragmentActivity) tContext).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container_homepage, matchesFragment).commit();
            }
        });
        allPercentage = homeWinPercentage + drawPercentage + awayWinPercentage;
        System.out.println(allPercentage);
        double homeWinCalculated = ((homeWinPercentage / allPercentage) * 100);
        System.out.println(homeWinCalculated);
        double awayWinCalculated = ((awayWinPercentage / allPercentage) * 100);
        System.out.println(awayWinCalculated);
        double drawCalculated = ((drawPercentage / allPercentage) * 100);
        System.out.println(drawCalculated);

        homeWinText.setText("Win %: " + homeWinCalculated);
        drawText.setText("Draw %: " + drawCalculated);
        awayWinText.setText("Win %: " + awayWinCalculated);
    }

    @Override
    public int getItemCount() {
        return mMatches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView homeTeam, awayTeam, homeTeamScore, awayTeamScore, matchDate, stadium, numberOfSeats, homeWinText, drawText, awayWinText;
        Button homeWin, draw, awayWin, book;
        ImageView homeImage, awayImage;
        Spinner bookingSpinner;

        public ViewHolder(final View itemView) {
            super(itemView);
            homeTeam = (TextView) itemView.findViewById(R.id.m_home_team_text_view);
            awayTeam = (TextView) itemView.findViewById(R.id.m_away_team_text_view);
            homeTeamScore = (TextView) itemView.findViewById(R.id.m_home_team_score_text_view);
            awayTeamScore = (TextView) itemView.findViewById(R.id.m_away_team_score_text_view);
            homeImage = (ImageView) itemView.findViewById(R.id.m_home_team_image_view);
            awayImage = (ImageView) itemView.findViewById(R.id.m_away_team_image_view);
            matchDate = (TextView) itemView.findViewById(R.id.date_textView);
            stadium = (TextView) itemView.findViewById(R.id.stadium_text_view);
            homeWin = (Button) itemView.findViewById(R.id.win_home_button);
            awayWin = (Button) itemView.findViewById(R.id.win_away_button);
            draw = (Button) itemView.findViewById(R.id.draw_button);
            book = (Button) itemView.findViewById(R.id.book_button);
            bookingSpinner = (Spinner) itemView.findViewById(R.id.booking_spinner);
            numberOfSeats = (TextView) itemView.findViewById(R.id.number_of_seats_text_view);
            homeWinText = (TextView) itemView.findViewById(R.id.home_win_percentage);
            drawText = (TextView) itemView.findViewById(R.id.draw_percentage);
            awayWinText = (TextView) itemView.findViewById(R.id.away_win_percentage);
        }
    }
}
