package com.chetan.spacex.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.chetan.spacex.model.Launch;

import java.util.List;

@Dao
public interface SpaceXDao {

    @Insert
    void insert(Launch model);

    @Update
    void update(Launch model);

    @Query(("UPDATE table_launch SET favStatus = :favStatus WHERE flightNumber = :id"))
    void updateFavoriteStatus(int id, int favStatus);

    @Query("SELECT * FROM table_launch")
    LiveData<List<Launch>> getAllLaunches();

    @Query("SELECT * FROM table_launch WHERE flightNumber = :id")
    Launch getSingleLaunch(int id);

    @Query("SELECT EXISTS(SELECT * FROM table_launch WHERE flightNumber = :id)")
    boolean isRecordExists(int id);

    @Query("DELETE FROM table_launch")
    void deleteAllCourses();
}