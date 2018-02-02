package com.papissian.razzle.randomnumbergenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText inputMin, inputMax;
    private TextView answer;

    private long min, max, random, last;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMin = (EditText) findViewById(R.id.input_min);
        inputMax = (EditText) findViewById(R.id.input_max);
        answer = (TextView) findViewById(R.id.answer);
        button = (Button) findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                min = Long.parseLong(inputMin.getText().toString());
                max = Long.parseLong(inputMax.getText().toString());
                if (min < max) {
                    answer.setText(generateRandom(min, max) + "");
                } else if (min == max) {
                    answer.setText(min + "");
                } else {
                    Toast.makeText(getApplication(), "Max value should not be smaller then min value", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public long generateRandom(long min, long max) {
        random = (System.currentTimeMillis() % 1000); // will return last 3 digits of current milliseconds
        random = (System.currentTimeMillis() / random); // will return large random number
        random =  (random % (max-min)) + min; // will return random number in range

        return random;
    }

}