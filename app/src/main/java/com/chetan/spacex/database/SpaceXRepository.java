package com.chetan.spacex.database;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.chetan.spacex.model.Launch;

import java.util.List;

public class SpaceXRepository {

    // below line is the create a variable for dao and list for all courses.
    private SpaceXDao dao;
    private LiveData<List<Launch>> allServers;

    // creating a constructor for our variables
    // and passing the variables to it.
    public SpaceXRepository(Application application) {
        SpaceXDatabase database = SpaceXDatabase.getInstance(application);
        dao = database.spaceXDao();
        allServers = dao.getAllLaunches();
    }

    // creating a method to insert the data to our database.
    public void insert(Launch model) {
        new InsertServerAsyncTask(dao).execute(model);
    }

    // creating a method to update the data to our database.
    public void update(Launch model) {
        new UpdateServerAsyncTask(dao).execute(model);
    }

    // creating a method to update favorite status the data to our database.
    public void updateFavoriteStatus(Launch model) {
        new UpdateFavoriteStatusAsyncTask(dao).execute(model);
    }

    // below is the method to delete all the courses.
    public void deleteAllServers() {
        new DeleteAllServersAsyncTask(dao).execute();
    }

    // below method is to read all the servers list.
    public LiveData<List<Launch>> getAllServers() {
        return allServers;
    }

    public Boolean isRecordExists(int id) {
        Boolean isExists = dao.isRecordExists(id);

        return isExists;
    }

    public Launch getRecordById(int flightNumber) {
        Launch launch = dao.getSingleLaunch(flightNumber);
        return launch;
    }

    // we are creating a async task method to insert new course.
    private static class InsertServerAsyncTask extends AsyncTask<Launch, Void, Void> {
        private SpaceXDao dao;

        private InsertServerAsyncTask(SpaceXDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Launch... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    // we are creating a async task method to update new course.
    private static class UpdateServerAsyncTask extends AsyncTask<Launch, Void, Void> {
        private SpaceXDao dao;

        private UpdateServerAsyncTask(SpaceXDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Launch... model) {
            // below line is use to insert our modal in dao.
            dao.update(model[0]);
            return null;
        }
    }

    // we are creating a async task method to update favorite status of launch.
    private static class UpdateFavoriteStatusAsyncTask extends AsyncTask<Launch, Void, Void> {
        private SpaceXDao dao;

        private UpdateFavoriteStatusAsyncTask(SpaceXDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Launch... models) {
            // below line is use to update our modal in dao.
            int id = 0;
            int favoriteStatus = 0;
            try {
                id = models[0].getFlightNumber();
                favoriteStatus = models[0].getFavStatus();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.e("TAG456", "doInBackground: " + id);
            Log.e("TAG456", "doInBackground: " + favoriteStatus);
            dao.updateFavoriteStatus(id, favoriteStatus);
            return null;
        }
    }

    // we are creating a async task method to check is record exist.
    private static class IsRecordExistAsyncTask extends AsyncTask<Launch, Void, Boolean> {
        private SpaceXDao dao;

        private IsRecordExistAsyncTask(SpaceXDao dao) {
            this.dao = dao;
        }

        @Override
        protected Boolean doInBackground(Launch... models) {
            // below line is use to update our modal in dao.
            int id = 0;
            try {
                id = models[0].getFlightNumber();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dao.isRecordExists(id);
        }
    }

    // we are creating a async task method to delete all courses.
    private static class DeleteAllServersAsyncTask extends AsyncTask<Void, Void, Void> {
        private SpaceXDao dao;

        private DeleteAllServersAsyncTask(SpaceXDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // on below line calling method
            // to delete all courses.
            dao.deleteAllCourses();
            return null;
        }
    }

}
