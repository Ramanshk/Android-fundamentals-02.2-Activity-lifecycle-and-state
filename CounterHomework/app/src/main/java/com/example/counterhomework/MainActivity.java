package com.example.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0, count_resume_value;
    Button count_btn;
    TextView count_text;
    String count_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count_btn = findViewById(R.id.count_btn);
        count_text = findViewById(R.id.count_text);

        if (savedInstanceState != null){
            count_value = savedInstanceState.getString("count_value");
            count_text.setText(count_value);

            count_resume_value = savedInstanceState.getInt("count_resume_value");
            count = count_resume_value;
        }

        count_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (count_text != null){
                    count_text.setText(Integer.toString(count));
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count_value", count_text.getText().toString());
        outState.putInt("count_resume_value", count);
    }
}