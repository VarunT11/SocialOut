package com.example.socialout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ApiSingleton apiSingleton;
    MainViewModel mainViewModel;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.navHostMain);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager horizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayout);

        apiSingleton = ApiSingleton.getInstance(this);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        getStories();

        mainViewModel.getStories().observe(this, users -> {
            StoryAdapter storyAdapter = new StoryAdapter(users, userId -> {

            });
            recyclerView.setAdapter(storyAdapter);
        });
    }

    private final String URL_USERS = "";

    private void getStories() {
        apiSingleton.sendGetRequest(URL_USERS, (success, result) -> {
            if (success) {
                try {
                    ArrayList<User> userList = new ArrayList<>();
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        User user = new User();

                        userList.add(user);
                    }
                    mainViewModel.setStoryUserList(userList);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("GET USER STORY", "Error: " + e.getMessage());
                }

            } else {
                Log.d("GET USER STORY", "Error: " + result);
            }
        });
    }
}