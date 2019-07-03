package com.example.piyush.fim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {   RatingBar ratingBar;
    SeekBar seekBar;
    Button btp1;
    TextView textView,tp;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tp= findViewById(R.id.txt5);

        tp.setText("Rating");

        ratingBar= findViewById(R.id.rat);
        seekBar= findViewById(R.id.seek);
        btp1= findViewById(R.id.btn2);
        textView= findViewById(R.id.text);
        seekBar.setMax(100);


        btp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rate= String.valueOf(ratingBar.getRating());
                Toast.makeText(Main3Activity.this, "You give a"+rate, Toast.LENGTH_SHORT).show();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                textView.setText("Progress is"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
