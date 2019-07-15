package me.buck.sunflower_java.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import me.buck.sunflower_java.data.PlantRepository;

/**
 * Created by gwf on 2019/7/15
 */
public class PlantListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private PlantRepository mPlantRepository;

    public PlantListViewModelFactory(PlantRepository plantRepository) {
        mPlantRepository = plantRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlantListViewModel(mPlantRepository);
    }
}
