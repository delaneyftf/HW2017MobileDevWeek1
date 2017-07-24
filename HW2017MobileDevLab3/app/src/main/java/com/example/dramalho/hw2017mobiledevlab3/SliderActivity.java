package com.example.dramalho.hw2017mobiledevlab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

public class SliderActivity extends AppCompatActivity
{
    public static final String SLIDER_KEY = "slider_key";
    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        int initialValue = getIntent().getIntExtra(SLIDER_KEY, 0);

        mSeekBar=(SeekBar) findViewById(R.id.seek_bar);
        mSeekBar.setProgress(initialValue);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //You have to override all three methods, but you can leave two of them empty and just override onStopTrackingTouch()
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(SLIDER_KEY, seekBar.getProgress());
                setResult(RESULT_OK, returnIntent);
            }
        });
    }
}