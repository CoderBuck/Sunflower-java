package me.buck.sunflower_java.data;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Created by gwf on 2019/7/2
 */
public class GardenPlantingRepository {

    private static GardenPlantingRepository instance;

    private GardenPlantingDao mGardenPlantingDao;

    public GardenPlantingRepository(GardenPlantingDao gardenPlantingDao) {
        mGardenPlantingDao = gardenPlantingDao;
    }

    public static GardenPlantingRepository getInstance(GardenPlantingDao gardenPlantingDao) {
        if (instance == null) {
            synchronized (GardenPlantingRepository.class) {
                if (instance == null) {
                    instance = new GardenPlantingRepository(gardenPlantingDao);
                }
            }
        }
        return instance;
    }

    public void createGardenPlanting(String palntId) {
        mGardenPlantingDao.insertGardenPlanting(new GardenPlanting(palntId));


    }

    public void removeGardenPlanting(GardenPlanting gardenPlanting) {
        mGardenPlantingDao.deleteGardenPlanting(gardenPlanting);
    }

    public LiveData<GardenPlanting> getGardenPlantingForPlant(String plantId) {
        return mGardenPlantingDao.getGardenPlantingForPlant(plantId);
    }

    public LiveData<List<GardenPlanting>> getGardenPlantings() {
        return mGardenPlantingDao.getGardenPlantings();
    }

    public LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return mGardenPlantingDao.getPlantAndGardenPlantings();
    }
}
