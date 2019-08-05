package me.buck.sunflower_java.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import me.buck.sunflower_java.objectbox.box.PlantBox;
import me.buck.sunflower_java.objectbox.entity.Plant;

/**
 * Created by gwf on 2019/7/15
 */
public class PlantListViewModel extends ViewModel {
    private static final int NO_GROW_ZONE = -1;

    private MutableLiveData<Integer>     mGrowZoneNumber = new MutableLiveData<>();
    private MutableLiveData<List<Plant>> mPlants;

    public PlantListViewModel() {
        mGrowZoneNumber.setValue(NO_GROW_ZONE);
        Integer num = mGrowZoneNumber.getValue();
        if (num == NO_GROW_ZONE) {
            List<Plant> plants = PlantBox.getPlants();
            mPlants.setValue(plants);
        } else {
            List<Plant> plants = PlantBox.getPlantsWithGrowZoneNumber(num);
            mPlants.setValue(plants);
        }
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


    public static int getNoGrowZone() {
        return NO_GROW_ZONE;
    }

    public MutableLiveData<Integer> getGrowZoneNumber() {
        return mGrowZoneNumber;
    }

    public LiveData<List<Plant>> getPlants() {
        return mPlants;
    }


}
