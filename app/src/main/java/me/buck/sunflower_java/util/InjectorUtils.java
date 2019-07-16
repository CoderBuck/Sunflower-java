package me.buck.sunflower_java.util;

import android.content.Context;

import me.buck.sunflower_java.data.AppDatabase;
import me.buck.sunflower_java.data.GardenPlantingRepository;
import me.buck.sunflower_java.data.PlantRepository;
import me.buck.sunflower_java.viewmodels.GardenPlantingListViewModelFactory;
import me.buck.sunflower_java.viewmodels.PlantDetailViewModelFactory;
import me.buck.sunflower_java.viewmodels.PlantListViewModelFactory;

/**
 * Created by gwf on 2019/7/16
 */
public class InjectorUtils {

    private static PlantRepository getPlantRepository(Context context) {
        return PlantRepository.getInstance(
                AppDatabase.getInstance(context).plantDao()
        );
    }

    private static GardenPlantingRepository getGardenPlantingRepository(Context context) {
        return GardenPlantingRepository.getInstance(
                AppDatabase.getInstance(context).gardenPlantingDao()
        );
    }

    public static GardenPlantingListViewModelFactory provideGardenPlantingListViewModelFactory(Context context) {
        GardenPlantingRepository repository = getGardenPlantingRepository(context);
        return new GardenPlantingListViewModelFactory(repository);
    }

    public static PlantListViewModelFactory providePlantListViewModelFactory(Context context) {
        PlantRepository repository = getPlantRepository(context);
        return new PlantListViewModelFactory(repository);
    }

    public static PlantDetailViewModelFactory providePlantDetailViewModelFactory(Context context, String plantId) {
        return new PlantDetailViewModelFactory(
                getPlantRepository(context),
                getGardenPlantingRepository(context),
                plantId
        );
    }


}
