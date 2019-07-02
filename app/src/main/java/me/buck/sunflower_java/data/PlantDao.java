package me.buck.sunflower_java.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * Created by gwf on 2019/7/2
 */
@Dao
public interface PlantDao {

    @Query("SELECT * FROM plants order by name")
    LiveData<List<Plant>> getPlants();

    @Query("SELECT * FROM plants where growZoneNumber = :number order by name")
    LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int number);

    @Query("select * from plants where id = :plantId ")
    LiveData<Plant> getPlant(String plantId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Plant> plants);
}
