package me.buck.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import me.buck.sunflower_java.util.InjectorUtils;
import me.buck.sunflower_java.viewmodels.PlantDetailViewModel;

/**
 * Created by buck on 2019-06-18
 */
public class PlantDetailFragment extends Fragment {

    private PlantDetailFragmentArgs mArgs;
    private String                  mShareText;
    private PlantDetailViewModel    mViewModel =
            InjectorUtils.providePlantDetailViewModelFactory(requireActivity(), mArgs.getPlantId()).create(PlantDetailViewModel.class);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.plant_detail_fragment, container, false);
        return inflate;
    }
}
