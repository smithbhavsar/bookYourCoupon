package com.smithbhavsar.bookyourcoupon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class viewcoupons extends AppCompatActivity implements couponadapter.onBuyNowListener{

    List<couponcard> couponcardList;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcoupons);

        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.couponrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        couponcardList = new ArrayList<>();
        couponcardList.add(new couponcard("Buy 1 get 1","31st May 2020","Weedays"));
        couponcardList.add(new couponcard("Get 50% off","31st July 2020","All Days"));
        couponcardList.add(new couponcard("Flat 200 OFF","30th June 2020","Weekends"));
        couponcardList.add(new couponcard("Flat 500 OFF","31st october 2020","Wednesdays"));

        couponadapter couponadapter = new couponadapter(this, couponcardList,this);
        recyclerView.setAdapter(couponadapter);
    }

    @Override
    public void onBuyNowClicked(int id) {
        Toast.makeText(this, "Item Clicked  " + id, Toast.LENGTH_SHORT).show();
    }
}
