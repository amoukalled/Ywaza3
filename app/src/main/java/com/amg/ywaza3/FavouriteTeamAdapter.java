package com.amg.ywaza3;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;

public class FavouriteTeamAdapter extends RecyclerView.Adapter<FavouriteTeamAdapter.ViewHolder> {

    Context tContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView teamName;
        Button favouriteButton;


        public ViewHolder(final View itemView) {
            super(itemView);
            teamName = (TextView) itemView.findViewById(R.id.team_name);
            favouriteButton = (Button) itemView.findViewById(R.id.favourite_button);
        }

    }

    private List<TeamModel> mTeam;

    public FavouriteTeamAdapter(List<TeamModel> teams, Context context) {
        mTeam = teams;
        tContext = context;
    }

    @Override
    public FavouriteTeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.recycler_favourite_team, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FavouriteTeamAdapter.ViewHolder viewHolder, int position) {
        TeamModel team = mTeam.get(position);

        TextView mTeam = viewHolder.teamName;
        mTeam.setText(team.getName());

        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = fAuth.getCurrentUser();


        viewHolder.favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dReference;
                dReference = FirebaseDatabase.getInstance().getReference("Users");
                dReference.orderByChild("email").equalTo(currentUser.getEmail()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {
                            String id = data.getKey();
                            String userName = data.child("userName").getValue().toString();
                            String email = data.child("email").getValue().toString();
                            String password = data.child("password").getValue().toString();

                            HashMap user = new HashMap();
                            user.put("email", email);
                            user.put("userName", userName);
                            user.put("password", password);
                            user.put("favTeam", team.getName());

                            dReference.child(id).updateChildren(user).addOnCompleteListener(new OnCompleteListener() {
                                @Override
                                public void onComplete(@NonNull Task task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(mTeam.getContext(), "Successfully chose favourite Team!\nWelcome!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(tContext, LoginActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        tContext.startActivity(intent);
                                    } else {
                                        Toast.makeText(mTeam.getContext(), "Failed to update favourite team!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTeam.size();
    }
}
