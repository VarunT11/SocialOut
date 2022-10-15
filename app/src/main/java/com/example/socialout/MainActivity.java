package com.example.socialout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    LinearLayoutManager HorizontalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User[] myListData = new User[]{new User(),new User(),new User(),new User(),new User(),new User(),new User(),new User(),new User(),new User(),new User(),new User()};

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        StoryAdapter adapter = new StoryAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        HorizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(HorizontalLayout);
        recyclerView.setAdapter(adapter);
    }
}