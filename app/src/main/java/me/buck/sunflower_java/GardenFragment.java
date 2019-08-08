package me.buck.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.buck.sunflower_java.adapter.GardenPlantingItem;
import me.buck.sunflower_java.objectbox.box.GardenPlantingBox;
import me.buck.sunflower_java.objectbox.entity.GardenPlanting;

/**
 * Created by buck on 2019-06-18
 */
public class GardenFragment extends Fragment {

    @BindView(R.id.garden_list)  RecyclerView mGardenList;
    @BindView(R.id.empty_garden) TextView     mEmptyGarden;

    //private GardenPlantingAdapter mAdapter;
    //
    //private GardenPlantingListViewModel mViewModel;

    private ItemAdapter<GardenPlantingItem> mItemAdapter;
    private FastAdapter<GardenPlantingItem> mFastAdapter;
    private Unbinder                        mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.garden_fragment, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        mItemAdapter = new ItemAdapter<>();
        mFastAdapter = FastAdapter.with(mItemAdapter);
        mGardenList.setAdapter(mFastAdapter);

        List<GardenPlanting> gardenPlantings = GardenPlantingBox.getGardenPlantings();
        if (gardenPlantings == null || gardenPlantings.size() == 0) {
            mEmptyGarden.setVisibility(View.VISIBLE);
            mGardenList.setVisibility(View.GONE);
        } else {
            mEmptyGarden.setVisibility(View.GONE);
            mGardenList.setVisibility(View.VISIBLE);

            ArrayList<GardenPlantingItem> items = new ArrayList<>();
            for (GardenPlanting planting : gardenPlantings) {
                items.add(new GardenPlantingItem(planting));
            }
            mItemAdapter.set(items);

        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
