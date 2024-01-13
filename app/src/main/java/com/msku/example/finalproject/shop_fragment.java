package com.msku.example.finalproject;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class shop_fragment extends Fragment {

    RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private FirebaseFirestore firestore;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_fragment, container, false);

        firestore = FirebaseFirestore.getInstance();


        // RecyclerView ve Adapter tanımlamaları
        recyclerView = view.findViewById(R.id.recyclerView_shop);
        recyclerView.setHasFixedSize(true);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            // Diğer RecyclerView ayarlarını yap
            // ...
        } else {
            // Hata durumunda log veya uyarı mesajı yazdırabilirsiniz.
            Log.e("ShopActivity", "RecyclerView is null!");
        }

        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);

        // Firestore'dan veri çekme
        fetchProducts();


        // Inflate the layout for this fragment
        return view;
    }

    private void fetchProducts() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<Product> productList = new ArrayList<>();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String name = document.getString("name");
                                String value = document.getString("value");

                                // Firebase'den alınan verilerle Product nesnesi oluştur
                                Product product = new Product(name,value);
                                productList.add(product);
                            }

                            // RecyclerView için adapter'a veri setini güncelle
                            productAdapter.setProductList(productList);
                            productAdapter.notifyDataSetChanged();
                        } else {
                            // Firestore'dan veri çekme hatası
                            Log.e(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

    }


}