package com.msku.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText mailEditText;
    EditText passwordEditText;
    Button loginButton;
    User_Manager userManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        mailEditText = findViewById(R.id.edittext_Mail);
        passwordEditText = findViewById(R.id.edittext_Password);
        loginButton = findViewById(R.id.BtnLogin);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        User_Manager userManager = new User_Manager(mAuth);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = mailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if(email.isEmpty()&& password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Boşlukları dDoldurunuz", Toast.LENGTH_SHORT).show();
                }else {
                    userManager.loginUser(email, password, new User_Manager.OnLoginListener() {
                        @Override
                        public void onLoginSuccess() {
                            // Giriş başarılı
                            Intent intent = new Intent(MainActivity.this, Home_page.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
                            // İstediğiniz aktiviteye geçiş yapabilirsiniz
                            // Örneğin: startActivity(new Intent(MainActivity.this, MainActivity.class));
                        }

                        @Override
                        public void onLoginFailure(String errorMessage) {
                            // Giriş başarısız
                            Toast.makeText(MainActivity.this, "Giriş başarısız: " + errorMessage, Toast.LENGTH_SHORT).show();

                            // MainActivity'yi kapatmak istiyorsanız

                        }
                    });
                }


                // Kullanıcı girişi yap

            }

        });
    }
}