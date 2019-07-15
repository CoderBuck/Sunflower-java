package me.buck.sunflower_java.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import me.buck.sunflower_java.data.GardenPlantingRepository;
import me.buck.sunflower_java.data.PlantRepository;

/**
 * Created by gwf on 2019/7/15
 */
public class PlantDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private PlantRepository mPlantRepository;
    private GardenPlantingRepository mGardenPlantingRepository;
    private String mPlantId;

    public PlantDetailViewModelFactory(PlantRepository plantRepository, GardenPlantingRepository gardenPlantingRepository, String plantId) {
        mPlantRepository = plantRepository;
        mGardenPlantingRepository = gardenPlantingRepository;
        mPlantId = plantId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlantDetailViewModel(mPlantRepository, mGardenPlantingRepository, mPlantId);
    }
}
