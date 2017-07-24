package com.example.dramalho.hw2017mobiledevlab2;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private LinearLayout mLinearLayoutOne;
    private LinearLayout mLinearLayoutTwo;
    private TextView mTextView;
    private Button mButtonBlue;
    private Button mButtonGreen;
    public String mLastColour = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonBlue = (Button) findViewById(R.id.blue_button);
        mButtonGreen = (Button) findViewById(R.id.green_button);
        mLinearLayoutOne = (LinearLayout) findViewById(R.id.linear_layout_one);
        mLinearLayoutTwo = (LinearLayout) findViewById(R.id.linear_layout_two);
        mTextView = (TextView) findViewById(R.id.top_text);

        mButtonBlue.setOnClickListener(new View.OnClickListener() {
            boolean pressed = false;
            public void onClick(View v){
                Toast toast;
                mLinearLayoutOne.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_blue_bright));
                mTextView.setText("Now we feel blue");
                if (mLastColour=="" || mLastColour=="green") {
                    toast = Toast.makeText(getApplicationContext(), "Now we feel blue", Toast.LENGTH_SHORT);
                    toast.show();
                    mLastColour="blue";
                }
            }
        });

        mButtonGreen.setOnClickListener(new View.OnClickListener() {
            boolean pressed = false;
            public void onClick(View v){
                Toast toast;
                mLinearLayoutOne.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_light));
                mTextView.setText("Now we feel green");
                if (mLastColour=="" || mLastColour=="blue") {
                    toast = Toast.makeText(getApplicationContext(), "Now we feel green", Toast.LENGTH_SHORT);
                    toast.show();
                    mLastColour="green";
                }
            }
        });
    }

}