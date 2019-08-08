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

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.ItemFilterListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.buck.sunflower_java.adapter.PlantItem;
import me.buck.sunflower_java.objectbox.box.PlantBox;
import me.buck.sunflower_java.objectbox.entity.Plant;

/**
 * Created by buck on 2019-06-18
 */
public class PlantListFragment extends Fragment {


    @BindView(R.id.plant_list) RecyclerView mPlantList;

    private Unbinder mUnbinder;

    private ItemAdapter<PlantItem> mItemAdapter;
    private FastAdapter<PlantItem> mFastAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.plant_list_fragment, container, false);
        mUnbinder = ButterKnife.bind(this, inflate);

        mItemAdapter = new ItemAdapter<>();
        mFastAdapter = FastAdapter.with(mItemAdapter);
        mFastAdapter.withAttachDefaultListeners(false);
        mPlantList.setAdapter(mFastAdapter);

        mItemAdapter.getItemFilter().withFilterPredicate(new IItemAdapter.Predicate<PlantItem>() {
            @Override
            public boolean filter(PlantItem item, @javax.annotation.Nullable CharSequence constraint) {
                try {
                    return item.getModel().getGrowZoneNumber() == Integer.valueOf(constraint.toString());
                } catch (Exception e) {
                    return false;
                }
            }
        });

        List<Plant> plantList = PlantBox.getPlants();
        ArrayList<PlantItem> items = new ArrayList<>();
        for (Plant plant : plantList) {
            items.add(new PlantItem(plant));
        }
        mItemAdapter.add(items);
        setHasOptionsMenu(true);
        return inflate;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_plant_list, menu);
    }

    boolean filter = true;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.filter_zone) {
            if (filter) {
                mItemAdapter.filter("9");
            } else {
                mItemAdapter.filter("");
            }
            filter = !filter;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
