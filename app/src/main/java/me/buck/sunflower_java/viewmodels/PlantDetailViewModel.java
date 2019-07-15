package me.buck.sunflower_java.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import me.buck.sunflower_java.data.GardenPlanting;
import me.buck.sunflower_java.data.GardenPlantingRepository;
import me.buck.sunflower_java.data.Plant;
import me.buck.sunflower_java.data.PlantRepository;

/**
 * Created by gwf on 2019/7/10
 */
public class PlantDetailViewModel extends ViewModel {

    private PlantRepository          mPlantRepository;
    private GardenPlantingRepository mGardenPlantingRepository;
    private String                   mPlantId;
    private LiveData<Boolean> mIsPlanted;
    private LiveData<Plant> mPlant;

    public PlantDetailViewModel(PlantRepository plantRepository, GardenPlantingRepository gardenPlantingRepository, String plantId) {
        mPlantRepository = plantRepository;
        mGardenPlantingRepository = gardenPlantingRepository;
        this.mPlantId = plantId;

        init();
    }

    private LiveData<Boolean> mIsPlant;
    private LiveData<Plant>   mPlantLiveData;

    private void init() {
        LiveData<GardenPlanting> gardenPlantingForPlant = mGardenPlantingRepository.getGardenPlantingForPlant(mPlantId);
        //gardenPlantingForPlant.
        // TODO: 2019/7/10
        mIsPlanted = Transformations.map(gardenPlantingForPlant, input -> input != null);
        mPlant = mPlantRepository.getPlant(mPlantId);
    }

    public void addPlantToGarden() {
        mGardenPlantingRepository.createGardenPlanting(mPlantId);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }




}
