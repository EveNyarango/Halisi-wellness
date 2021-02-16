package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.halisiwellness.R;

public class ArticlesActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        String[] tArticles = getResources().getStringArray(R.array.title_articles);
        String[] dArticles = getResources().getStringArray(R.array.details_articles);

        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tArticles);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = dArticles[position];

                Intent intent = new Intent(ArticlesActivity.this, MainActivity2.class);

                intent.putExtra("articles", t);
                startActivity(intent);
            }
        });
    }
}