package com.smithbhavsar.bookyourcoupon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contact_us extends AppCompatActivity {

    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));

        final EditText cname,cphone,cmessage;
        Button button;

        cname = findViewById(R.id.contactname);
        cphone = findViewById(R.id.contactnumber);
        cmessage = findViewById(R.id.contactmessage);
        button = findViewById(R.id.contactsubmit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cname.setText("");
                cphone.setText("");
                cmessage.setText("");
                Toast.makeText(Contact_us.this, "Thankyou for your response", Toast.LENGTH_SHORT).show();
            }
        });
    }
}