package com.smithbhavsar.bookyourcoupon;
import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class couponadapter extends RecyclerView.Adapter<couponadapter.couponViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<couponcard> clist;

    private onBuyNowListener onBuyNowListener;

    //getting the context and product list with constructor
    public couponadapter(Context mCtx, List<couponcard> clist, onBuyNowListener onBuyNowListener ) {
        this.mCtx = mCtx;
        this.clist = clist;
        this.onBuyNowListener = onBuyNowListener;
    }

    @Override
    public couponViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.couponscardview, null);
        return new couponViewHolder(view,onBuyNowListener);
    }

    @Override
    public void onBindViewHolder(couponViewHolder holder, int position) {
        //getting the product of the specified position
        couponcard product = clist.get(position);
        //binding the data with the viewholder views
        holder.couponname.setText(product.getTitle());
        holder.validtill.setText(product.getValidtill());
        holder.validon.setText(product.getValidon());
    }

    @Override
    public int getItemCount() {
        return clist.size();
    }


    class couponViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView couponname, validtill , validon;
        Button bunow, details ;
        onBuyNowListener onBuyNowListener;

        public couponViewHolder(final View itemView, final onBuyNowListener onBuyNowListener) {
            super(itemView);

            couponname = itemView.findViewById(R.id.offername);
            validtill = itemView.findViewById(R.id.validtilldate);
            validon = itemView.findViewById(R.id.validondate);
            bunow = itemView.findViewById(R.id.buynow);
            details = itemView.findViewById(R.id.details);
            this.onBuyNowListener = onBuyNowListener;
            bunow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    onBuyNowListener.onBuyNowClicked(getAdapterPosition());
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
                    alertDialogBuilder.setView(R.layout.layout_buynow_alertbox);
                    alertDialogBuilder.setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Intent i = new Intent(v.getContext(),Countdown.class);
                                    i.putExtra("Title", clist.get(getAdapterPosition()).getTitle());
                                    v.getContext().startActivity(i);
                                }
                            });

                    alertDialogBuilder.setNegativeButton("No",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    
                                }
                            });
                    final AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            });
        }
        @Override
        public void onClick(View v) {
        }
    }
//    private void showdailog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(viewcoupons.this,R.style.AlertDailogTheme);
//        View view = LayoutInflater.from(viewcoupons.this).inflate(R.layout.layout_buynow_alertbox, (ViewGroup) findViewById(R.id.alertcontainer));
//        builder.setView(view);
//
//        final AlertDialog alertDialog = builder.create();
//        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });
//
//        if(alertDialog.getWindow()!=null){
//            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
//        }
//        alertDialog.show();
//    }
//
    public interface onBuyNowListener{
        void onBuyNowClicked(int id);
    }
}

