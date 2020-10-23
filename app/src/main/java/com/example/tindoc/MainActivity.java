package com.example.tindoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text_view;
    private Button button1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_view = findViewById(R.id.textView);


        button1 = findViewById(R.id.button);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });


    }

    public void openlogin() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void opensignup() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}