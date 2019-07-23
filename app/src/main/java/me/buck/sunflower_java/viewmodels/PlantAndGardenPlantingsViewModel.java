package me.buck.sunflower_java.viewmodels;

import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.Locale;

import me.buck.sunflower_java.data.GardenPlanting;
import me.buck.sunflower_java.data.Plant;
import me.buck.sunflower_java.data.PlantAndGardenPlantings;

/**
 * Created by gwf on 2019/7/10
 */
public class PlantAndGardenPlantingsViewModel extends ViewModel {

    private PlantAndGardenPlantings mPlantAndGardenPlantings;

    public PlantAndGardenPlantingsViewModel(PlantAndGardenPlantings plantAndGardenPlantings) {
        mPlantAndGardenPlantings = plantAndGardenPlantings;
    }

    {
        Plant plant = mPlantAndGardenPlantings.plant;
        GardenPlanting gardenPlanting = mPlantAndGardenPlantings.getGardenPlantings().get(0);
        SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy", Locale.US);
    }


}
