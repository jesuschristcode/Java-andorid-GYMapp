package com.msku.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.msku.example.finalproject.databinding.ActivityPhysicalInformationBinding;


public class Physical_information extends AppCompatActivity  {
    TextView sex ,age,fatrate,arm,chest,waist,height, weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sex = findViewById(R.id.sexx);
        age = findViewById(R.id.Age);
        fatrate = findViewById(R.id.Ftrate);
        arm = findViewById(R.id.Armcrc);
        chest = findViewById(R.id.Chstcrc);
        waist = findViewById(R.id.Waistcrc);
        height = findViewById(R.id.Height);
        weight = findViewById(R.id.Weight);


        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        User_Manager user_manager = new User_Manager(FirebaseAuth.getInstance());


        System.out.println(user_manager.getCurrentUser().getUid());
        firestore.collection("user")
                .document(user_manager.getCurrentUser().getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        UserInfo user = documentSnapshot.toObject(UserInfo.class);
                        sex.setText(user.getSex());
                        arm.setText(String.valueOf(user.getArm()));
                        fatrate.setText(user.getFatRate());
                        chest.setText(String.valueOf(user.getChest()));
                        waist.setText(String.valueOf(user.getWaist()));
                        age.setText(String.valueOf(user.getAge()));
                        weight.setText(String.valueOf(user.getWeight()));
                        height.setText(String.valueOf(user.getHeight()));


                    } else {

                    }
                })
                .addOnFailureListener(e -> {

                });


    }
}