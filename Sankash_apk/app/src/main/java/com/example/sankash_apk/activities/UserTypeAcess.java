package com.example.sankash_apk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.sankash_apk.R;

public class UserTypeAcess extends AppCompatActivity {

    private AppCompatImageView imageViewA;
    private AppCompatImageView imageViewB1;
    private AppCompatImageView imageViewB2;
    private AppCompatImageView imageViewC1;
    private AppCompatImageView imageViewC2;

    private String usertype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        initViews();
        setVisibility();
    }

    private void initViews() {

         imageViewA = findViewById(R.id.imageA);

         imageViewB1 = findViewById(R.id.imageB1);
         imageViewB2 = findViewById(R.id.imageB2);

         imageViewC1 = findViewById(R.id.imageC1);
         imageViewC2 = findViewById(R.id.imageC2);
    }


    private void setVisibility() {

        Intent intent = getIntent();
        usertype = intent.getStringExtra("type");

        if(usertype.contentEquals("A"))
        {
            imageViewB1.setVisibility(View.GONE);
            imageViewB2.setVisibility(View.GONE);
            imageViewC1.setVisibility(View.GONE);
            imageViewC2.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(),"Type A User",Toast.LENGTH_LONG).show();
        }
        else if(usertype.contentEquals("B"))
        {
            imageViewA.setVisibility(View.GONE);
            imageViewC1.setVisibility(View.GONE);
            imageViewC2.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(),"Type B User",Toast.LENGTH_LONG).show();
        }
        else if(usertype.contentEquals("C"))
        {
            imageViewA.setVisibility(View.GONE);
            imageViewB1.setVisibility(View.GONE);
            imageViewB2.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(),"Type C User",Toast.LENGTH_LONG).show();
        }

    }
}
