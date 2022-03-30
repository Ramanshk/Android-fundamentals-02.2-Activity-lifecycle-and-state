package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.shoppinglist.extra.TEXT";
    Button item_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        item_btn = findViewById(R.id.button1);
    }

    public void sendItem(View view) {
        String item = item_btn.getText().toString();
        Intent replyIntent = new Intent();

        switch (view.getId()){
            case R.id.button1:
                replyIntent.putExtra(EXTRA_TEXT, "Apple");
                setResult(RESULT_OK, replyIntent);
                finish();
            case R.id.button2:
                replyIntent.putExtra(EXTRA_TEXT, "Banana");
                setResult(RESULT_OK, replyIntent);
                finish();
            case R.id.button3:
                replyIntent.putExtra(EXTRA_TEXT, "Mango");
                setResult(RESULT_OK, replyIntent);
                finish();
            case R.id.button4:
                replyIntent.putExtra(EXTRA_TEXT, "Cheese");
                setResult(RESULT_OK, replyIntent);
                finish();
            case R.id.button5:
                replyIntent.putExtra(EXTRA_TEXT, "Milk");
                setResult(RESULT_OK, replyIntent);
                finish();
            case R.id.button6:
                replyIntent.putExtra(EXTRA_TEXT, "Yogurt");
                setResult(RESULT_OK, replyIntent);
                finish();
            case R.id.button7:
                replyIntent.putExtra(EXTRA_TEXT, "Chicken");
                setResult(RESULT_OK, replyIntent);
                finish();
            case R.id.button8:
                replyIntent.putExtra(EXTRA_TEXT, "Tuna");
                setResult(RESULT_OK, replyIntent);
                finish();
            case R.id.button9:
                replyIntent.putExtra(EXTRA_TEXT, "Crab");
                setResult(RESULT_OK, replyIntent);
                finish();
        }
    }
}