package com.amitmusician.secure;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SeekBar seekBar;
    Button button;

    int pos = 0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.seekbartext);
        seekBar = findViewById(R.id.seekbar);
        button = findViewById(R.id.genreat);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pos = progress;
                textView.setText(""+pos);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button.setOnClickListener(v -> {
            if (pos>3){
                Intent intent = new Intent(MainActivity.this,PasswordActivity.class);
                intent.putExtra("val",pos);
                startActivity(intent);
            }
            else {
                textView.setText("Minimum 4 Digits");
            }
        });
    }
}