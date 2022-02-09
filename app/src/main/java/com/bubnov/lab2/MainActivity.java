package com.bubnov.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int clickCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = new LinearLayout( this );
        layout.setOrientation(LinearLayout.VERTICAL);
        for (int i = 1; i <= 10; i++){
            Button button = new Button( this);
            button.setText("button" +i);
            button.setBackgroundColor(Color.rgb( 0, i*20, 255));
            layout.addView(button);
        }
   //     setContentView(layout);
    }

    public void resetbtn(View view) {
        clickCounter = 0;
        Button button = findViewById(R.id.button);
        button.setText("I was clicked " + clickCounter + " times");

    }
}