package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add_item_btn;
    TextView[] listItemTextView= new TextView[9];
    ArrayList<String> itemNameList = new ArrayList<>(9);
    public static final int REQUEST = 1;
    public static final String EXTRA_REPLY = "com.example.shoppinglist.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_item_btn = findViewById(R.id.add_item_btn);
        listItemTextView[0] = findViewById(R.id.list_item_1);
        listItemTextView[1] = findViewById(R.id.list_item_2);
        listItemTextView[2] = findViewById(R.id.list_item_3);
        listItemTextView[3] = findViewById(R.id.list_item_4);
        listItemTextView[4] = findViewById(R.id.list_item_5);
        listItemTextView[5] = findViewById(R.id.list_item_6);
        listItemTextView[6] = findViewById(R.id.list_item_7);
        listItemTextView[7] = findViewById(R.id.list_item_8);
        listItemTextView[8] = findViewById(R.id.list_item_9);

        if (savedInstanceState != null) {
            itemNameList = savedInstanceState.getStringArrayList("ItemsList");
            int i;
            if (itemNameList != null && itemNameList.size() > 0) {
                for (i = 0; i < itemNameList.size(); i++) {
                    listItemTextView[i].setVisibility(View.VISIBLE);
                    listItemTextView[i].setText(itemNameList.get(i));
                }
            }
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQUEST);
        /*String reply = intent.getStringExtra(SecondActivity.EXTRA_TEXT);
        listItemTextView[0].setText(reply);*/
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (itemNameList.size() != 0){
            outState.putStringArrayList("ItemsList", itemNameList);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST){
            if(resultCode == RESULT_OK){
                String item_name = data.getStringExtra(SecondActivity.EXTRA_TEXT);
                itemNameList.add(item_name);

                for (int i = 0; i < itemNameList.size(); i++){
                    if (itemNameList.size() > 10){
                        Toast.makeText(this, "List full", Toast.LENGTH_LONG).show();
                        break;
                    }
                    listItemTextView[i].setVisibility(View.VISIBLE);
                    listItemTextView[i].setText(itemNameList.get(i));
                }
            }
        }
    }
}