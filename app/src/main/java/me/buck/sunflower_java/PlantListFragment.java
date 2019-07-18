package me.buck.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.buck.sunflower_java.adapter.PlantAdapter;
import me.buck.sunflower_java.util.InjectorUtils;
import me.buck.sunflower_java.viewmodels.PlantListViewModel;

/**
 * Created by buck on 2019-06-18
 */
public class PlantListFragment extends Fragment {


    @BindView(R.id.plant_list) RecyclerView       mPlantList;
    private                    PlantListViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.plant_list_fragment, container, false);
        ButterKnife.bind(inflate);
        mViewModel = InjectorUtils.providePlantListViewModelFactory(getContext()).create(PlantListViewModel.class);

        PlantAdapter adapter = new PlantAdapter();
        mPlantList.setAdapter(adapter);

        mViewModel.getPlants().observe(this,plants -> {
            if (plants != null) {
                adapter.submitList(plants);
            }
        });

        setHasOptionsMenu(true);
        return inflate;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_plant_list,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.filter_zone) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
