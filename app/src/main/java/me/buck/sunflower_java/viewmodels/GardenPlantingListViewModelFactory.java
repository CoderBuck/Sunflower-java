package me.buck.sunflower_java.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import me.buck.sunflower_java.data.GardenPlantingRepository;

/**
 * Created by gwf on 2019/7/2
 */
public class GardenPlantingListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GardenPlantingRepository mRepository;

    public GardenPlantingListViewModelFactory(GardenPlantingRepository repository) {
        mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GardenPlantingListViewModel(mRepository);
    }
}
