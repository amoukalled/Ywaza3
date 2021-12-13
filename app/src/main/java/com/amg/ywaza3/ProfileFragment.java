package com.amg.ywaza3;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ProfileFragment extends Fragment {

    FirebaseAuth fAuth;
    TextView email, userName;
    Button changeUsername, changePassword, changeFavTeam, signOut, deleteAccount;
    ImageView favTeamLogo;

    String id, name, eaddress, password, favTeam;

    HashMap user = new HashMap();

    String m_Text;
    String m_Email;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        fAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = fAuth.getCurrentUser();

        View view = getView();
        if (view != null) {
            SQLiteOpenHelper sqLiteOpenHelper = new TeamSQLiteOpenHelper(getContext());
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

            changeUsername = view.findViewById(R.id.change_username);
            changePassword = view.findViewById(R.id.change_password);
            changeFavTeam = view.findViewById(R.id.change_favteam);
            signOut = view.findViewById(R.id.sign_out);
            deleteAccount = view.findViewById(R.id.delete_account);

            email = view.findViewById(R.id.textview_email);
            userName = view.findViewById(R.id.textview_username);

            favTeamLogo = view.findViewById(R.id.image_team);

            DatabaseReference dReference;
            dReference = FirebaseDatabase.getInstance().getReference("Users");


            dReference.orderByChild("email").equalTo(currentUser.getEmail()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot data : snapshot.getChildren()) {
                        id = data.getKey();
                        name = data.child("userName").getValue().toString();
                        eaddress = data.child("email").getValue().toString();
                        favTeam = data.child("favTeam").getValue().toString();
                    }

                    email.setText(eaddress);
                    userName.setText(name);


                    Cursor cursor = db.query("TEAMS",
                            new String[]{"T_IMAGE_RESOURCE_ID"},
                            "T_Name=?", new String[]{favTeam},
                            null, null, null);


                    if (cursor.moveToFirst()) {
                        int logo = cursor.getInt(0);
                        favTeamLogo.setImageResource(logo);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), "Unable to get information", Toast.LENGTH_SHORT).show();
                }
            });

            signOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fAuth.getInstance().signOut();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
            });

            changeFavTeam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), FavouriteTeamActivity.class));
                }
            });

            changeUsername.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Enter New Username");
                    builder.setCancelable(true);

                    final EditText input = new EditText(getContext());
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                    builder.setView(input);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            m_Text = input.getText().toString();

                            if (m_Text.length() < 6) {
                                Toast.makeText(getContext(), "Username must be greater than 6 characters!", Toast.LENGTH_SHORT).show();
                            } else {
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                                Query checkUser = reference.orderByChild("userName").equalTo(String.valueOf(m_Text));
                                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()) {
                                            Toast.makeText(getContext(), "Error: Username already taken!", Toast.LENGTH_SHORT).show();
                                        } else {
                                            user.put("email", eaddress);
                                            user.put("userName", String.valueOf(m_Text));
                                            user.put("password", password);
                                            user.put("favTeam", favTeam);

                                            dReference.child(id).updateChildren(user).addOnCompleteListener(new OnCompleteListener() {
                                                @Override
                                                public void onComplete(@NonNull Task task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(getContext(), "Successfully changed username!", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(getContext(), "Failed to update username!", Toast.LENGTH_SHORT).show();
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
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();


                }
            });

            changePassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Reset Password?");
                    builder.setMessage("Enter you email!");
                    builder.setCancelable(true);
                    final EditText resetMail = new EditText(getContext());
                    builder.setView(resetMail);


                    builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            m_Email = resetMail.getText().toString();

                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                            Query checkUser = reference.orderByChild("email").equalTo(m_Email);

                            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if (snapshot.exists()) {
                                        fAuth.sendPasswordResetEmail(m_Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(getContext(), "Reset link sent to your email!", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(getContext(), "Error! Reset link is not sent.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    } else {
                                        Toast.makeText(getContext(), "Error! Email does not exist.", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                }
                            });
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
            });


            deleteAccount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                    dialog.setTitle("Are you sure?");
                    dialog.setMessage("Deleting this account will result in completely removing your account from the system and you wont be able to access Ywaza3");
                    dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(id);
                                        reference.removeValue();
                                        Toast.makeText(getContext(), "User Account Deleted!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getContext(), LoginActivity.class));
                                    } else {
                                        Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });

                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alertDialog = dialog.create();
                    alertDialog.show();
                }
            });
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
