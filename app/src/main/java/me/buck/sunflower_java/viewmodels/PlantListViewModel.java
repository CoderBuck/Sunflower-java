package me.buck.sunflower_java.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

import me.buck.sunflower_java.data.Plant;
import me.buck.sunflower_java.data.PlantRepository;

/**
 * Created by gwf on 2019/7/15
 */
public class PlantListViewModel extends ViewModel {
    private static final int NO_GROW_ZONE = -1;

    private PlantRepository          mPlantRepository;
    private MutableLiveData<Integer> mGrowZoneNumber = new MutableLiveData<>();
    private LiveData<List<Plant>>    mPlants;

    public PlantListViewModel(PlantRepository plantRepository) {
        mPlantRepository = plantRepository;

        mGrowZoneNumber.setValue(NO_GROW_ZONE);
        mPlants = Transformations.switchMap(mGrowZoneNumber, num -> {
            if (num == NO_GROW_ZONE) {
                return plantRepository.getPlants();
            } else {
                return plantRepository.getPlantsWithGrowZoneNumber(num);
            }
        });
    }

    public void setGrowZoneNumber(int number) {
        mGrowZoneNumber.setValue(number);
    }

    public void clearGrowZoneNumber() {
        mGrowZoneNumber.setValue(NO_GROW_ZONE);
    }

    public boolean isFiltered() {
        return mGrowZoneNumber.getValue() != NO_GROW_ZONE;
    }
}
