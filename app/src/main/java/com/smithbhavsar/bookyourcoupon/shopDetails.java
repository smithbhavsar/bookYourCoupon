package com.smithbhavsar.bookyourcoupon;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class shopDetails extends AppCompatActivity {
    private static final int request_call = 1;
    TextView phonenumber, shopname ,shoprating , category;
    Button viewcoupon;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);

        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));

        shopname = findViewById(R.id.shopname);
        Intent i = getIntent();
        String title = i.getStringExtra("Title");
        shopname.setText(title);

        shoprating = findViewById(R.id.shoprating);
        Intent intent = getIntent();
        String rate = intent.getStringExtra("rate");
        shoprating.setText(rate);

        category = findViewById(R.id.area_name);
        Intent intent1 = getIntent();
        String cate = intent1.getStringExtra("category");
        category.setText(cate);

        viewcoupon = findViewById(R.id.view);
        viewcoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shopDetails.this,viewcoupons.class);
                startActivity(intent);
            }
        });

        phonenumber = findViewById(R.id.shopnumber);
        phonenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = phonenumber.getText().toString();
                if(ContextCompat.checkSelfPermission(shopDetails.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(shopDetails.this,
                            new String[]{Manifest.permission.CALL_PHONE},request_call);
                }
                else
                    { String dial = "tel:" + number;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                    }
            }
        });
    }
}
