package com.amg.ywaza3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {

    RecyclerView recyclerView;
    TeamSQLiteOpenHelper sqLiteOpenHelper;
    String favTeam;
    List<FavoriteMatchesModel> favoriteMatchesList = new ArrayList<>();
    FirebaseAuth fAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();

        fAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = fAuth.getCurrentUser();

        DatabaseReference dReference;
        dReference = FirebaseDatabase.getInstance().getReference("Users");


        dReference.orderByChild("email").equalTo(currentUser.getEmail()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    favTeam = data.child("favTeam").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        SQLiteOpenHelper sqLiteOpenHelper = new TeamSQLiteOpenHelper(getContext());
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();


        if (view != null) {
            sqLiteOpenHelper = new TeamSQLiteOpenHelper(getContext());
            recyclerView = (RecyclerView) view.findViewById(R.id.matches_recycler_in_fav_fragment);

            Cursor data = db.rawQuery("SELECT t1.T_Name, t2.T_Name, t1.T_IMAGE_RESOURCE_ID, t2.T_IMAGE_RESOURCE_ID, m.M_HomeTeamScore, m.M_AwayTeamScore, m.M_DATE, m.M_STADIUM FROM MATCHES m, TEAMS t1, TEAMS t2 WHERE m.M_HomeTeamID = t1.T_id AND m.M_AwayTeamID = t2.T_id AND (t1.T_Name = ? OR t2._T_Name = ?)", new String[]{favTeam});
            int i = 0;
            if (data.getCount() != 0) {
                while (data.moveToNext()) {
                    FavoriteMatchesModel matches = new FavoriteMatchesModel(data.getString(0), data.getString(1), data.getInt(2), data.getInt(3), data.getInt(4), data.getInt(5), data.getString(6), data.getString(7));
                    favoriteMatchesList.add(i, matches);
                    i++;
                }
                FavoriteMatchesAdapter adapter = new FavoriteMatchesAdapter(favoriteMatchesList, getContext());
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
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }
}
