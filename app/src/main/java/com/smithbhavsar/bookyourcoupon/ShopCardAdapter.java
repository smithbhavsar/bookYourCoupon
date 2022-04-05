package com.smithbhavsar.bookyourcoupon;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;


import java.util.List;


public class ShopCardAdapter extends RecyclerView.Adapter<ShopCardAdapter.ShopViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<ShopCard> productList;

    private onShopListener monShopListener;

    //getting the context and product list with constructor
    public ShopCardAdapter(Context mCtx, List<ShopCard> productList, onShopListener onShopListener) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.monShopListener = onShopListener;
    }

    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardviewcategory, null);

        return new ShopViewHolder(view , monShopListener);
    }

    @Override
    public void onBindViewHolder(ShopViewHolder holder, int position) {
        //getting the product of the specified position
        ShopCard product = productList.get(position);

        String title = product.getShopname();
        holder.textViewTitle.setText(product.getShopname());
        holder.textviewcaetory.setText(product.getCategory());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewoffer.setText(String.valueOf(product.getOffer_detail()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getShopimg()));
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }



    class ShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle, textViewoffer, textViewRating, textViewPrice, textviewcaetory;
        ImageView imageView;

        onShopListener onShopListener;

        public ShopViewHolder(View itemView,onShopListener onShopListener) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.shopname);
            textViewoffer = itemView.findViewById(R.id.shopcat);
            textviewcaetory = itemView.findViewById(R.id.shopcategory);
            textViewRating = itemView.findViewById(R.id.shoprating);
            textViewPrice = itemView.findViewById(R.id.voucher_price);
            imageView = itemView.findViewById(R.id.shopimg);
            this.onShopListener = onShopListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onShopListener.onShopClicked(getAdapterPosition());
            Intent i = new Intent(v.getContext(),shopDetails.class);
            i.putExtra("Title", productList.get(getAdapterPosition()).getShopname());
            i.putExtra("rate",productList.get(getAdapterPosition()).getRating());
            i.putExtra("category",productList.get(getAdapterPosition()).getCategory());
            v.getContext().startActivity(i);
        }
    }

    public interface onShopListener{
        void onShopClicked(int id);
    }
}
