package com.chetan.spacex.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.chetan.spacex.database.SpaceXRepository;
import com.chetan.spacex.model.Launch;
import com.chetan.spacex.network.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LaunchesViewModel extends AndroidViewModel {
    //Database related
    private SpaceXRepository repository;

    private LiveData<List<Launch>> allServers;

    // constructor for our view modal.
    public LaunchesViewModel(Application application) {
        super(application);
        repository = new SpaceXRepository(application);
        allServers = repository.getAllServers();
    }

    // below method is use to insert the data to our repository.
    public void insert(Launch model) {
        repository.insert(model);
    }

    // below method is use to update the data to our repository.
    public void update(Launch model) {
        repository.update(model);
    }

    // below method is use to update the data to our repository
    public void updateFavoriteStatus(Launch model) {
        repository.updateFavoriteStatus(model);
    }

    // below method is to delete all the courses in our list.
    public void deleteAllServers() {
        repository.deleteAllServers();
    }

    // below method is to get all the courses in our list.
    public LiveData<List<Launch>> getAllServers() {
        return allServers;
    }

    // get single record
    public Launch getRecordById(int flightNumber) {
        Launch launch = repository.getRecordById(flightNumber);
        return launch;
    }

    public Boolean isRecordExists(int id) {

        Boolean isRecordExists = repository.isRecordExists(id);

        return isRecordExists;
    }

    // API
    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Launch>> launchesList;

    //we will call this method to get the data
    public LiveData<List<Launch>> getHeroes() {
        //if the list is null
        if (launchesList == null) {
            launchesList = new MutableLiveData<List<Launch>>();
            //we will load it asynchronously from server in this method
            loadLaunches();
        }

        //finally we will return the list
        return launchesList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadLaunches() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Launch>> call = api.getLaunches();


        call.enqueue(new Callback<List<Launch>>() {
            @Override
            public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                Log.e("TAG", "onResponse: response.body() = " + response.body());
                //finally we are setting the list to our MutableLiveData
                launchesList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Launch>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }


}
