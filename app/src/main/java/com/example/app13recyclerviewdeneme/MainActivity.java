package com.example.app13recyclerviewdeneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<String> ulkelerList;
    private BasitRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        ulkelerList = new ArrayList<>();
        ulkelerList.add("türkiye");
        ulkelerList.add("almanya");
        ulkelerList.add("amerika");
        ulkelerList.add("çin");
        ulkelerList.add("azerbaycan");
        ulkelerList.add("italya");
        ulkelerList.add("hollanda");
        ulkelerList.add("bulgaristan");
        ulkelerList.add("macaristan");
        ulkelerList.add("türkmen");
        ulkelerList.add("fas");
        ulkelerList.add("slovenya");
        ulkelerList.add("hollanda");
        ulkelerList.add("canada");

        adapter = new BasitRVAdapter(this, ulkelerList);

        rv.setAdapter(adapter);

    }
}