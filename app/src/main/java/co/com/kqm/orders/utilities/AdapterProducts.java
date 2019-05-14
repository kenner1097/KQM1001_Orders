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

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ViewHolderProduct> implements View.OnClickListener {

    private View.OnClickListener listener;
    ArrayList<Products> listProducts;

    public AdapterProducts(ArrayList<Products> listProducts) {
        this.listProducts = listProducts;
    }

    @NonNull
    @Override
    public ViewHolderProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int layout = 1;

        if (Constants.visualizacion == Constants.LIST){
            layout = R.layout.item_products;
        } else {
            layout = R.layout.item_gird_product;
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, null, false );
        view.setOnClickListener(this);
        return new ViewHolderProduct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProduct viewHolderProduct, int position) {
        viewHolderProduct.nameProduct.setText(listProducts.get(position).getNombre());
        if (Constants.visualizacion == Constants.LIST){
            viewHolderProduct.infoProduct.setText(listProducts.get(position).getDescripcion());
        }
        viewHolderProduct.picture.setImageResource(listProducts.get(position).getImagen());
    }

    @Override
    public int getItemCount(){
        return listProducts.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listProducts != null){
            listener.onClick(v);
        }
    }

    public class ViewHolderProduct extends RecyclerView.ViewHolder {

        TextView nameProduct, infoProduct;
        ImageView picture;

        public ViewHolderProduct(@NonNull View itemView) {
            super(itemView);

            nameProduct = itemView.findViewById(R.id.id_itemName);
            if (Constants.visualizacion == Constants.LIST) {
                infoProduct = itemView.findViewById(R.id.id_itemInfo);
            }
            picture = itemView.findViewById(R.id.id_image);
        }

    }
}