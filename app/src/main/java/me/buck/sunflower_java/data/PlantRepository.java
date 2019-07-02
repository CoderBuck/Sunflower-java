package me.buck.sunflower_java.data;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Created by gwf on 2019/7/2
 */
public class PlantRepository {

    private static PlantRepository instance;

    private PlantDao mPlantDao;

    public PlantRepository(PlantDao plantDao) {
        mPlantDao = plantDao;
    }

    public static PlantRepository getInstance(PlantDao plantDao) {
        if (instance == null) {
            synchronized (PlantRepository.class) {
                if (instance == null) {
                    instance = new PlantRepository(plantDao);
                }
            }
        }
        return instance;
    }

    public LiveData<List<Plant>> getPlants()                             {return mPlantDao.getPlants();}

    public LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int number) {return mPlantDao.getPlantsWithGrowZoneNumber(number);}

    public LiveData<Plant> getPlant(String plantId)                      {return mPlantDao.getPlant(plantId);}

}
