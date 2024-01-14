package com.msku.example.finalproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText mailEditText;
    EditText passwordEditText;
    Button loginButton;
    User_Manager userManager; // Burada userManager'ı sınıf düzeyinde tanımla

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        mailEditText = findViewById(R.id.edittext_Mail);
        passwordEditText = findViewById(R.id.edittext_Password);
        loginButton = findViewById(R.id.BtnLogin);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        // Burada sınıf içindeki userManager nesnesini kullan
        userManager = new User_Manager(mAuth);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Boşlukları doldurunuz", Toast.LENGTH_SHORT).show();
                } else {
                    new LoginTask().execute(email, password);
                }
            }
        });
    }

    private class LoginTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            String email = params[0];
            String password = params[1];

            userManager.loginUser(email, password, new User_Manager.OnLoginListener() {
                @Override
                public void onLoginSuccess() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this, Home_page.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                @Override
                public void onLoginFailure(String errorMessage) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Giriş başarısız: " + errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

            return null;
        }
    }
}
