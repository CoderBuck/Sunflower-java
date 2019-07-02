package me.buck.sunflower_java.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

/**
 * Created by gwf on 2019/7/2
 */
@Dao
public interface GardenPlantingDao {

    @Query("select * from garden_plantings ")
    LiveData<List<GardenPlanting>> getGardenPlantings();

    @Query("select * from garden_plantings where id = :gardenPlantingId")
    LiveData<GardenPlanting> getGardenPlanting(long gardenPlantingId);

    @Query("select * from garden_plantings where plant_id = :plantId")
    LiveData<GardenPlanting> getGardenPlantingForPlant(String plantId);

    @Transaction
    @Query("select * from plants")
    LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings();

    @Insert
    long insertGardenPlanting(GardenPlanting gardenPlanting);

    @Delete
    void deleteGardenPlanting(GardenPlanting gardenPlanting);

}
