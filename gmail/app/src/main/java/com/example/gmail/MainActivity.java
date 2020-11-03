package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list1);

        List database = new database().dbList;
        CustomBaseAdapter adapter = new CustomBaseAdapter(this,database,R.layout.item_list);
        listView.setAdapter(adapter);
    }
}