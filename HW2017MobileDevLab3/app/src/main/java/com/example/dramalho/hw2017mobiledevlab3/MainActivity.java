package com.example.dramalho.hw2017mobiledevlab3;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private static final int A_CODE = 0;
    private static final String A_KEY = "A_key";

    private static final int B_CODE = 1;
    private static final String B_KEY = "B_key";


    private int mValueA;
    private int mValueB;

    private Button mButtonA;
    private Button mButtonB;

    private TextView mTextViewA;
    private TextView mTextViewB;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonA=(Button) findViewById(R.id.value_A_button);
        mButtonB=(Button) findViewById(R.id.value_B_button);
        mTextViewA=(TextView) findViewById(R.id.value_A_textview);
        mTextViewB=(TextView) findViewById(R.id.value_B_textview);

        mTextViewA=(TextView) findViewById(R.id.value_A_textview);
        mButtonA=(Button) findViewById(R.id.value_A_button);
        mButtonA.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent i = new Intent(MainActivity.this, SliderActivity.class);
                i.putExtra(SliderActivity.SLIDER_KEY, mValueA);
                startActivityForResult(i, A_CODE);

            }
        });

        mTextViewB=(TextView) findViewById(R.id.value_B_textview);
        mButtonB=(Button) findViewById(R.id.value_B_button);
        mButtonB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent i = new Intent(MainActivity.this, SliderActivity.class);
                i.putExtra(SliderActivity.SLIDER_KEY, mValueB);
                startActivityForResult(i, B_CODE);

            }
        });

        if (savedInstanceState != null)
        {

            mValueA=savedInstanceState.getInt(A_KEY, 0);
            mValueB=savedInstanceState.getInt(B_KEY, 0);

            mTextViewA.setText("" + mValueA);
            mTextViewB.setText("" + mValueB);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == RESULT_OK) {
            if(requestCode == A_CODE)
            {
                mValueA = data.getIntExtra(SliderActivity.SLIDER_KEY, 0);
                mTextViewA.setText("" + mValueA);

            }
            else if (requestCode == B_CODE)
            {
                mValueB = data.getIntExtra(SliderActivity.SLIDER_KEY, 0);
                mTextViewB.setText("" + mValueB);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(A_KEY, mValueA);
        savedInstanceState.putInt(B_KEY, mValueB);
    }
}