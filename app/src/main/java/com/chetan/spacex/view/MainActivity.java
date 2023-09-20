package com.chetan.spacex.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chetan.spacex.R;
import com.chetan.spacex.adapter.SpaceXAdapter;
import com.chetan.spacex.model.Launch;
import com.chetan.spacex.util.CommonMethods;
import com.chetan.spacex.util.SharedPref;
import com.chetan.spacex.viewmodel.LaunchesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SpaceXAdapter adapter;
    LaunchesViewModel model;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        SharedPref.init(mContext);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        model = ViewModelProviders.of(MainActivity.this).get(LaunchesViewModel.class);
        //model = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LaunchesViewModel.class);
        //model.deleteAllServers();

        // Room DB data list
        boolean loadStatus = SharedPref.read("isRecordsLoaded", false);
        if (loadStatus) {
            showDataFromLocal();
        }

        // API Call
        if (CommonMethods.isInternetAvailable(mContext)) {
            model.getHeroes().observe(this, new Observer<List<Launch>>() {
                @Override
                public void onChanged(@Nullable List<Launch> launchList) {
                    Log.e("TAG", "onChanged: launchList size = " + launchList.size());
                    for (int i = 0; i < launchList.size(); i++) {
                        try {
                            Launch obj = launchList.get(i);
                            int flightNumber = obj.getFlightNumber();
                            Boolean isRecordExist = model.isRecordExists(flightNumber);
                            if (isRecordExist != null) {
                                if (isRecordExist) {
                                    model.update(obj);
                                } else {
                                    obj.setFavStatus(0);
                                    model.insert(obj);
                                    SharedPref.write("isRecordsLoaded", true);
                                }
                            } else {
                                obj.setFavStatus(0);
                                model.insert(obj);
                                SharedPref.write("isRecordsLoaded", true);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    // finally show data from local db
                    showDataFromLocal();
                }
            });
        } else {
            Toast.makeText(mContext, "Network is required!", Toast.LENGTH_SHORT).show();
            if (loadStatus) {
                showDataFromLocal();
            }
        }
    }

    private void showDataFromLocal() {
        model.getAllServers().observe(this, new Observer<List<Launch>>() {
            @Override
            public void onChanged(List<Launch> launches) {
                adapter = new SpaceXAdapter(MainActivity.this, launches);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}