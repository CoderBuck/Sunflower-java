package me.buck.sunflower_java.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.annimon.stream.Stream;

import java.util.List;

import me.buck.sunflower_java.data.GardenPlanting;
import me.buck.sunflower_java.data.GardenPlantingRepository;
import me.buck.sunflower_java.data.PlantAndGardenPlantings;
import me.buck.sunflower_java.objectbox.box.GardenPlantingBox;

/**
 * Created by gwf on 2019/6/19
 */
public class GardenPlantingListViewModel extends ViewModel {

    private GardenPlantingRepository mRepository;

    public GardenPlantingListViewModel(GardenPlantingRepository repository) {
        mRepository = repository;
    }

    public LiveData<List<GardenPlanting>> getGardenPlantings() {
        //MutableLiveData<List<me.buck.sunflower_java.objectbox.entity.GardenPlanting>> liveData = new MutableLiveData<>();
        //List<me.buck.sunflower_java.objectbox.entity.GardenPlanting> plantings = GardenPlantingBox.getGardenPlantings();
        //liveData.setValue(plantings);

        return mRepository.getGardenPlantings();
    }

    public LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return Transformations.map(mRepository.getPlantAndGardenPlantings(), plantings -> Stream.of(plantings)
                .filter(it -> !it.getGardenPlantings().isEmpty())
                .toList());
    }

}
