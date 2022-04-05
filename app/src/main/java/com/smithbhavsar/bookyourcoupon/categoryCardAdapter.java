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

public class categoryCardAdapter extends RecyclerView.Adapter<categoryCardAdapter.categoryViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<categorycard> categoryList;

    //getting the context and product list with constructor
    public categoryCardAdapter(Context mCtx, List<categorycard> categoryList  ) {
        this.mCtx = mCtx;
        this.categoryList = categoryList;
    }

    @Override
    public categoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardviewlistofcategory, null);
        return new categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(categoryViewHolder holder, int position) {
        //getting the product of the specified position
        categorycard product = categoryList.get(position);
        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    class categoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;




        public categoryViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.iconimg);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(),categoryCouponsdisplay.class);
            v.getContext().startActivity(i);
        }
    }
}

