package com.smithbhavsar.bookyourcoupon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void callfunc(View view) {
        Toast.makeText(this, "Setting called", Toast.LENGTH_SHORT).show();
    }
}