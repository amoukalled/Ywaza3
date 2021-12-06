package com.amg.ywaza3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    EditText regEmail, regPassword, regUsername;
    Button regBtn;
    TextView logBtn;
    ImageView logBtn2;

    FirebaseAuth fAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fAuth = FirebaseAuth.getInstance();


        regEmail = findViewById(R.id.editTextEmail);
        regPassword = findViewById(R.id.editTextPassword);
        regUsername = findViewById(R.id.editTextUsername);
        regBtn = findViewById(R.id.registerButton);
        logBtn = findViewById(R.id.go_to_login);
        logBtn2 = findViewById(R.id.go_to_login_button);


        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        logBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("Users");

                String email = regEmail.getText().toString();
                String password = regPassword.getText().toString();
                String userName = regUsername.getText().toString();

                if (email.isEmpty()) {
                    regEmail.setError("Email is required");
                    return;
                }
                if (password.isEmpty()) {
                    regPassword.setError("Password is required");
                    return;
                }
                if (userName.isEmpty()) {
                    regUsername.setError("Username is required");
                    return;
                }
                if (password.length() < 6) {
                    regPassword.setError("Password must be greater than 6 characters");
                    return;
                }

                checkRegistration(email, userName, password);


            }
        });
    }

    public void checkRegistration(String email, String username, String password) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        Query checkUser = reference.orderByChild("userName").equalTo(username);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Toast.makeText(RegisterActivity.this, "Error: Username already taken!", Toast.LENGTH_SHORT).show();
                } else {
                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                                UserModel helperClass = new UserModel(email, password, username, "Chelsea");
                                myRef.push().setValue(helperClass);
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            } else {
                                Toast.makeText(RegisterActivity.this, "Error: Email already taken!", Toast.LENGTH_SHORT).show();

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