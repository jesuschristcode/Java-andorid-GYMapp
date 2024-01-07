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
import java.util.List;
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    private List<Product> productList;
   // private OnBuyButtonClickListener buyButtonClickListener;
    private Context mContext;

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
               // buyButtonClickListener.onBuyButtonClick(product);
                Toast.makeText(mContext,"seçtiğiniz ürün:" +product.getName(),Toast.LENGTH_SHORT).show();
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
