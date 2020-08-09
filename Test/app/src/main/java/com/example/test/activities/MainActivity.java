package com.example.test.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.R;
import com.example.test.activities.AddProfile1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_add_prof1=findViewById(R.id.add_prof1);
        Button btn_add_prof2=findViewById(R.id.add_prof2);

        btn_add_prof1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentforProfile1=new Intent(getApplicationContext(), AddProfile1.class);
                startActivity(intentforProfile1);
            }
        });

        btn_add_prof2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenforProfile2 = new Intent(getApplicationContext(),AddProfile2.class);
                startActivity(intenforProfile2);
            }
        });

    }
}