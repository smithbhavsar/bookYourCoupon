package com.smithbhavsar.bookyourcoupon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class referafriend extends AppCompatActivity {

    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referafriend);
        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));

        Button button = findViewById(R.id.refer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 boolean installed  = appInstalledOrNot("com.whatsapp");
                 if(installed){
                     Intent sendIntent = new Intent();
                     sendIntent.setAction(Intent.ACTION_SEND);
                     sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my app link. :) - Book Your Coupon.");
                     sendIntent.setType("text/plain");
                     sendIntent.setPackage("com.whatsapp");
                     startActivity(sendIntent);
                 }
            }
        });
    }
    private boolean appInstalledOrNot(String s) {
        PackageManager packageManager = getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(s,PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }catch (PackageManager.NameNotFoundException e){
            app_installed = false;
        }
        return  app_installed;
    }
}
