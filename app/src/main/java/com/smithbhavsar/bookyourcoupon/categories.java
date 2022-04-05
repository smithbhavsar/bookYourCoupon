package com.smithbhavsar.bookyourcoupon;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class categories extends AppCompatActivity{

    RecyclerView recyclerView;
    List<categorycard> categoryList;
    categoryCardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setElevation(2);
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        categoryList = new ArrayList<>();
        categoryList.add(new categorycard(1,"Food",R.drawable.food_orange));
        categoryList.add(new categorycard(2,"Entertainment",R.drawable.enter_orange));
        categoryList.add(new categorycard(3,"Groceries",R.drawable.groceries_orange));
        categoryList.add(new categorycard(4,"Fashion",R.drawable.fashion_orange));
        categoryList.add(new categorycard(5,"Fitness",R.drawable.fitness_orange));
        categoryList.add(new categorycard(6,"Electronics",R.drawable.electronics_orange));
        categoryList.add(new categorycard(7,"Hotels",R.drawable.hotel_orange));
        categoryList.add(new categorycard(8,"Salon",R.drawable.salon));
        categoryList.add(new categorycard(9,"Cosmetics",R.drawable.cosmetics));
        categoryList.add(new categorycard(10,"Stationary",R.drawable.stationary));
        categoryList.add(new categorycard(11,"Furniture and Decoration",R.drawable.furniture));
        categoryList.add(new categorycard(12,"Travel",R.drawable.travel));
        categoryList.add(new categorycard(13,"Events",R.drawable.events));
        categoryList.add(new categorycard(14,"Health",R.drawable.health));
        categoryList.add(new categorycard(15,"Others",R.drawable.others));

        categoryCardAdapter adapter = new categoryCardAdapter(this,categoryList);
        recyclerView.setAdapter(adapter);

    }
}
