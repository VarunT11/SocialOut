package com.example.socialout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    LinearLayoutManager HorizontalLayout;
    FloatingActionButton filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter = findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilterDialogFragment newFragment = new FilterDialogFragment();
                newFragment.show(getSupportFragmentManager(),"Dialog");
            }
        });

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