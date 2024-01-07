package com.msku.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Nutritition_program extends AppCompatActivity {
    TextView sunday,monday,tuesday,wednesday,thursday,friday,saturday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritition_program);
        sunday = findViewById(R.id.pazar);
        monday = findViewById(R.id.pzt);
        tuesday = findViewById(R.id.salı);
        wednesday = findViewById(R.id.çarşamba);
        thursday = findViewById(R.id.perşembe);
        friday = findViewById(R.id.cuma);
        saturday =findViewById(R.id.cumartesi);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        User_Manager user_manager =  new User_Manager(FirebaseAuth.getInstance());


        System.out.println(user_manager.getCurrentUser().getUid());
        firestore.collection("userNutritition")
                .document(user_manager.getCurrentUser().getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        UserNutritition userNutritition = documentSnapshot.toObject(UserNutritition.class);
                        monday.setText(userNutritition.getMonday());
                        sunday.setText(userNutritition.getSunday());
                        tuesday.setText(userNutritition.getTuesday());
                        saturday.setText(userNutritition.getSaturday());
                        friday.setText(userNutritition.getFriday());
                        thursday.setText(userNutritition.getThursday());
                        wednesday.setText(userNutritition.getWednesday());





                    } else {

                    }
                })
                .addOnFailureListener(e -> {

                });
    }

}