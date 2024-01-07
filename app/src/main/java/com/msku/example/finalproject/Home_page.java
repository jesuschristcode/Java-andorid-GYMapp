package com.msku.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.msku.example.finalproject.databinding.ActivityHomePageBinding;
import com.msku.example.finalproject.databinding.ActivityMainBinding;

public class Home_page extends AppCompatActivity  {
    User_Manager user_manager;

    ActivityHomePageBinding binding ;


    @SuppressLint("CommitTransaction")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigation.setBackground(null);

        getSupportFragmentManager().beginTransaction().replace(
                R.id.frame_layout,new home_fragment()
        ).commit();

        binding.shop.setOnClickListener(item ->{
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.frame_layout,new shop_fragment()
            ).commit();
        });

        binding.wallet.setOnClickListener(item ->{
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.frame_layout,new wallet_fragment()
            ).commit();
        });

        binding.physic.setOnClickListener(item ->{
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.frame_layout,new physical_fragment()
            ).commit();
        });

        binding.home.setOnClickListener(item ->{
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.frame_layout,new home_fragment()
            ).commit();
        });



        //binding.bottomNavigation.setOnItemSelectedListener(item -> {

      //     switch (item.getItemId()) {
      //         case R.id.home:
      //             replaceFragment(new home_fragment());
      //             break;
      //         case R.id.shop:
      //             replaceFragment(new shop_fragment());
      //             Intent intent =  new Intent(Home_page.this,Shop.class);
      //             startActivity(intent);

      //             break;
      //         case R.id.nutritition:
      //             replaceFragment(new nutritition_fragment());
      //             Intent intent1 =  new Intent(Home_page.this,Nutritition_program.class);
      //             startActivity(intent1);
      //             break;

      //         case R.id.pyhsicalInfo:
      //             replaceFragment(new physical_fragment());
      //           //  Intent intent2 =  new Intent(Home_page.this,Physical_information.class);
      //           //  startActivity(intent2);
      //             break;
      //         case R.id.fitnessProgram:
      //             replaceFragment(new program_fragment());
      //             Intent intent3 =  new Intent(Home_page.this,Fitness_program.class);
      //             startActivity(intent3);
      //             break;
      //     }
      //     return true;
      // });

     // user_manager = new User_Manager(FirebaseAuth.getInstance());
     ///QrCode = findViewById(R.id.QrCode);

     // FirebaseUser currentUser = user_manager.getCurrentUser();
     // if (currentUser != null) {
     //     String userId = currentUser.getUid();

     //     try {
     //         BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
     //         Bitmap bitmap = barcodeEncoder.encodeBitmap(userId, BarcodeFormat.QR_CODE, 400, 400);
     //        // QrCode.setImageBitmap(bitmap);
     //     } catch (WriterException e) {
     //         e.printStackTrace();
     //     }
     // }






    }
    private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }

}