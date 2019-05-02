package co.com.kqm.orders.utilities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.com.kqm.orders.R;
import co.com.kqm.orders.model.Products;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ViewHolderProduct> {

    ArrayList<Products> listProducts;

    public AdapterProducts(ArrayList<Products> listProducts) {
        this.listProducts = listProducts;
    }

    @NonNull
    @Override
    public ViewHolderProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products, null, false );
        return new ViewHolderProduct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProduct viewHolderProduct, int position) {
        viewHolderProduct.nameProduct.setText(listProducts.get(position).getNombre());
        viewHolderProduct.infoProduct.setText(listProducts.get(position).getDescripcion());
        viewHolderProduct.picture.setImageResource(listProducts.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    public class ViewHolderProduct extends RecyclerView.ViewHolder {

        TextView nameProduct, infoProduct;
        ImageView picture;

        public ViewHolderProduct(@NonNull View itemView) {
            super(itemView);

            nameProduct = itemView.findViewById(R.id.id_itemName);
            infoProduct = itemView.findViewById(R.id.id_itemInfo);
            picture = itemView.findViewById(R.id.id_image);
        }

    }
}