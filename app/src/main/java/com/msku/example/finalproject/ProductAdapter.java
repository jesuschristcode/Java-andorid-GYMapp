package com.msku.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    private List<Product> productList;


    private Context context;
   // private OnBuyButtonClickListener buyButtonClickListener;


    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
        //this.buyButtonClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productNameTextView.setText(product.getName());
        holder.productPriceTextView.setText(String.valueOf(product.getValue()));

        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBalance(v);
            }
            public void updateBalance(View v){
                User_Manager user_manager =  new User_Manager(FirebaseAuth.getInstance());
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                String documentId = user_manager.getCurrentUser().getUid();
                db.collection("wallet").document(documentId)
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {

                                // Belge varsa değeri al
                                int currentBalance = documentSnapshot.getLong("Balance").intValue();
                                if(currentBalance>=Integer.parseInt(product.getValue())) {
                                    // Değeri güncelleme işlemi
                                    int newBalance = currentBalance - Integer.parseInt(product.getValue()); // Örnek: Mevcut bakiyeye 100 ekliyoruz

                                    // Güncellenmiş değeri Firestore'e yazma
                                    db.collection("wallet").document(documentId)
                                            .update("Balance", newBalance)
                                            .addOnSuccessListener(aVoid -> {
                                                // Güncelleme başarılı
                                                System.out.println("Balance updated successfully");
                                            })
                                            .addOnFailureListener(e -> {
                                                // Güncelleme başarısız
                                                System.out.println("Failed to update balance: " + e.getMessage());
                                            });
                                    Toast.makeText(v.getContext(), "Ürün başarıyla satın alındı. Yeni bakiye: " + newBalance, Toast.LENGTH_SHORT).show();

                                }
                                else{

                                    Toast.makeText(v.getContext(), "Bakiye yetersiz. Lütfen bakiyenizi kontrol edin.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                System.out.println("Document does not exist");
                            }
                        })
                        .addOnFailureListener(e -> {
                            // Firestore'dan belge çekme işlemi başarısız
                            System.out.println("Failed to fetch document: " + e.getMessage());
                        });

            }

        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productNameTextView, productPriceTextView;
        Button buyButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            productPriceTextView = itemView.findViewById(R.id.productPriceTextView);
            buyButton = itemView.findViewById(R.id.buyButton);
        }
    }

    public interface OnBuyButtonClickListener {
        void onBuyButtonClick(Product product);

    }
}
