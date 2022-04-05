package com.smithbhavsar.bookyourcoupon;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class categoryCouponsdisplay extends AppCompatActivity
        implements ShopCardAdapter.onShopListener {

    RecyclerView recyclerView;
    List<ShopCard> productList;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_couponsdisplay);
        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new ShopCard(
                        1,
                        "Shakti Sandwich",
                        "Food",
                        "Buy 1 Get 1 Free",
                        500,"3.7",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        2,
                        "Enrich Salon",
                        "Salon and Spa",
                        "Upto 70% off",
                        1000,"4.7",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        3,
                        "Asopalav",
                        "Fashion",
                        "Buy 1 Get 1 Free",
                        500,"4.1",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        4,
                        "Dell Electronics",
                        "Electronis",
                        "Offer offer Offer",
                        900,"4.3",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        5,
                        "Zeus Fitness Point",
                        "Fitness",
                        "12 months + 3 months Free",
                        1500,"3.2",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        6,
                        "Dell Electronics",
                        "Electronis",
                        "Offer offer Offer",
                        700,"3.9",
                        R.drawable.shopimg));

        productList.add(
                new ShopCard(
                        7,
                        "Shakti Sandwich",
                        "Food",
                        "Buy 1 Get 1 Free",
                        500,"3.7",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        8,
                        "Enrich Salon",
                        "Salon and Spa",
                        "Upto 70% off",
                        1000,"4.7",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        9,
                        "Enrich Salon",
                        "Salon and Spa",
                        "Upto 70% off",
                        1000,"4.7",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        10,
                        "Enrich Salon",
                        "Salon and Spa",
                        "Upto 70% off",
                        1000,"4.7",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        11,
                        "Enrich Salon",
                        "Salon and Spa",
                        "Upto 70% off",
                        1000,"4.7",
                        R.drawable.shopimg));
        productList.add(
                new ShopCard(
                        12,
                        "Enrich Salon",
                        "Salon and Spa",
                        "Upto 70% off",
                        1000,"4.7",
                        R.drawable.shopimg));


        ShopCardAdapter adapter = new ShopCardAdapter(this,productList,this);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onShopClicked(int id) {
        Toast.makeText(this, "Item Clicked  " + id, Toast.LENGTH_SHORT).show();
    }
}
