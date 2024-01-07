package com.msku.example.finalproject;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class User_Manager {
    private FirebaseAuth mAuth;

    public User_Manager(FirebaseAuth auth) {
        mAuth = auth;
    }

    // Kullanıcı girişi yapma metodu
    public void loginUser(String email, String password, final OnLoginListener listener) {

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Giriş başarılı
                            listener.onLoginSuccess();
                        } else {
                            // Giriş başarısız
                            listener.onLoginFailure(task.getException().getMessage());
                        }
                    });


    }

    // Kullanıcı oturumu kapatma metodu
    public void logoutUser() {
        mAuth.signOut();
    }

    // Kullanıcı durumunu kontrol etme metodu
    public boolean isUserLoggedIn() {
        return mAuth.getCurrentUser() != null;
    }

    // Kullanıcı bilgilerini alma metodu
    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

    // Listener interface'i
    public interface OnLoginListener {
        void onLoginSuccess();
        void onLoginFailure(String errorMessage);
    }
}
