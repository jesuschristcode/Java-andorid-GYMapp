package com.msku.example.finalproject;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class home_fragment extends Fragment {


    ImageView qrCode;

    User_Manager user_manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        qrCode = view.findViewById(R.id.qrCode);



        setQrCode();
        // Inflate the layout for this fragment
        return view;
    }

    private void setQrCode() {
        user_manager = new User_Manager(FirebaseAuth.getInstance());
        //QrCode = findViewById(R.id.QrCode);

        FirebaseUser currentUser = user_manager.getCurrentUser();

        if (currentUser != null) {
            String userId = currentUser.getUid();

            try {
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.encodeBitmap(userId, BarcodeFormat.QR_CODE, 400, 400);
                qrCode.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }
    }
}