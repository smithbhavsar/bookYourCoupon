package com.smithbhavsar.bookyourcoupon;
import android.content.Intent;
import android.graphics.Color;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button sellerbtn, userbtn , signinbtn;
    Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        userbtn = findViewById(R.id.userbtn);
        sellerbtn = findViewById(R.id.sellerbtn);
        TextView textView = findViewById(R.id.callsignup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,signup.class);
                startActivity(intent);

            }
        });

        signinbtn = findViewById(R.id.signinbtn);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,dashboard.class);
                startActivity(intent);
            }
        });

    }
    public void callFrag (View view)
    {

        if (view == findViewById(R.id.userbtn))
        {

            userbtn.setBackgroundColor(Color.parseColor("#DB8304"));
            userbtn.setTextColor(Color.parseColor("#FFFFFF"));
            sellerbtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
            sellerbtn.setTextColor(Color.parseColor("#000000"));
            userlogin userlogin = new userlogin();
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment2, userlogin);
            fragmentTransaction.commit();

        }
        else if (view == findViewById(R.id.sellerbtn))
        {
//            sellerbtn.setBackgroundColor(Color.parseColor("#DB8304"));
//            sellerbtn.setTextColor(Color.parseColor("#FFFFFF"));
//            userbtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
//            userbtn.setTextColor(Color.parseColor("#000000"));
//            retailerlogin retailerlogin = new retailerlogin();
//            fragmentManager = getSupportFragmentManager();
//            fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.fragment2, retailerlogin);
//            fragmentTransaction.commit();

        }



    }
}
