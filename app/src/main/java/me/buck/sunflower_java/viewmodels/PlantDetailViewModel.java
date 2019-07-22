package me.buck.sunflower_java.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.blankj.utilcode.util.ThreadUtils;

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



    private void init() {
        LiveData<GardenPlanting> gardenPlantingForPlant = mGardenPlantingRepository.getGardenPlantingForPlant(mPlantId);
        mIsPlanted = Transformations.map(gardenPlantingForPlant, input -> input != null);
        mPlant = mPlantRepository.getPlant(mPlantId);
    }

    public void addPlantToGarden() {
        ThreadUtils.getIoPool().execute(() -> {
            mGardenPlantingRepository.createGardenPlanting(mPlantId);
        });
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public PlantRepository getPlantRepository() {
        return mPlantRepository;
    }

    public GardenPlantingRepository getGardenPlantingRepository() {
        return mGardenPlantingRepository;
    }

    public String getPlantId() {
        return mPlantId;
    }

    public LiveData<Boolean> getIsPlanted() {
        return mIsPlanted;
    }

    public LiveData<Plant> getPlant() {
        return mPlant;
    }
}
