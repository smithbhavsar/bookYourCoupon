package com.smithbhavsar.bookyourcoupon;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , ShopCardAdapter.onShopListener{

    RecyclerView recyclerView;
    List<ShopCard> productList;
    ShopCardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
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

        ShopCardAdapter adapter = new ShopCardAdapter(this, productList, this);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.dashboard, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.add_to_cart) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_order) {

        } else if (id == R.id.about_us) {
            Intent intent = new Intent(this, aboutUs.class);
            startActivity(intent);

        } else if (id == R.id.share) {

            Intent intent = new Intent(this, referafriend.class);
            startActivity(intent);

        } else if (id == R.id.help){
            Intent intent = new Intent(this, Contact_us.class);
            startActivity(intent);
        }else if (id == R.id.signout){

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int id = menuItem.getItemId();

            if (id == R.id.category){

                Intent intent = new Intent(dashboard.this, categories.class);
                startActivity(intent);

            }
            else if (id == R.id.location){

                Intent intent = new Intent(dashboard.this, Locationpop.class);
                startActivity(intent);

            }
            else if(id == R.id.setting){

                Intent intent = new Intent(dashboard.this, Setting.class);
                startActivity(intent);
            }
            return true;
        }
    };

    @Override
    public void onShopClicked(int id) {
        Toast.makeText(this, "Item Clicked  " + id, Toast.LENGTH_SHORT).show();
    }

    public void callcate(View view) {
        Intent intent = new Intent(dashboard.this, categoryCouponsdisplay.class);
        startActivity(intent);
    }
    public void callmore(View view) {
        Intent intent = new Intent(dashboard.this, categories.class);
        startActivity(intent);
    }

}
