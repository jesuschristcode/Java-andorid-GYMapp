package com.msku.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class wallet_fragment extends Fragment {
    TextView Balance;
    ImageView imageWallet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_wallet_fragment,container,false);
        Balance =  view.findViewById(R.id.blnc);
        imageWallet =  view.findViewById(R.id.WalletImage);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        User_Manager user_manager =  new User_Manager(FirebaseAuth.getInstance());


        System.out.println(user_manager.getCurrentUser().getUid());
        firestore.collection("wallet")
                .document(user_manager.getCurrentUser().getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        WalletInfo walletInfo = documentSnapshot.toObject(WalletInfo.class);
                        Balance.setText(String.valueOf(walletInfo.getBalance())+"$");

                    } else {
                        System.out.println("Document Does not exist");

                    }
                })
                .addOnFailureListener(e -> {

                });
        // Inflate the layout for this fragment
        return view;
    }


}