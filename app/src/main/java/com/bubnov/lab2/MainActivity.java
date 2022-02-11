package com.bubnov.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int clickCounter = 0;
    long pressStart = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = new LinearLayout( this );
        layout.setOrientation(LinearLayout.VERTICAL);
        for (int i = 1; i <= 10; i++){
            Button button = new Button( this);
            String formatted = getString(R.string.nupp, i);
            button.setText(formatted);
            button.setBackgroundColor(Color.rgb( 0, i*20, 255));
            layout.addView(button);
        }
        //setContentView(layout);

        Button buttonClicker = findViewById(R.id.btnClicker);
        buttonClicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clickCounter++;
                buttonClicker.setText("I was clicked " + clickCounter + " times");
            }
        });

        Button buttonReset = findViewById(R.id.btnReset);
        buttonReset.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    pressStart = System.currentTimeMillis();
                }else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    long duration = System.currentTimeMillis() - pressStart;
                    TextView text = findViewById(R.id.textView);
                    text.setText("Button was pressed for " + duration + " ms");
                    LinearLayout vertical = findViewById(R.id.vertical_layout);
                    TextView txtDuration = new TextView(getApplicationContext());
                    txtDuration.setText("Button was pressed for "+duration+" ms");
                    vertical.addView(txtDuration);
                }
                return false;
            }
        });

       /* buttonClicker.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                clickCounter--;
                buttonClicker.setText("I was clicked " + clickCounter + " times");
                return false;
            }
        });*/
    };


    public void resetbtn(View view) {
        clickCounter = 0;
        Button button = findViewById(R.id.btnClicker);
        button.setText("I was clicked " + clickCounter + " times");
        LinearLayout vertical = findViewById(R.id.vertical_layout);
        vertical.removeAllViews();

    }
}