package me.buck.sunflower_java.objectbox.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Function;
import com.blankj.utilcode.util.ToastUtils;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.ClickEventHook;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.buck.sunflower_java.R;
import me.buck.sunflower_java.objectbox.box.PlantBox;
import me.buck.sunflower_java.objectbox.entity.Plant;
import me.buck.sunflower_java.objectbox.fastadapter.PlantItem;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity2";

    @BindView(R.id.plant_list) RecyclerView mPlantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_list_fragment);
        ButterKnife.bind(this);

        ItemAdapter<PlantItem> itemAdapter = new ItemAdapter<>();
        FastAdapter<PlantItem> fastAdapter = FastAdapter.with(itemAdapter);
        mPlantList.setAdapter(fastAdapter);
        fastAdapter.withEventHook(new ClickEventHook<PlantItem>() {

            @Override
            public void onClick(View v, int position, FastAdapter<PlantItem> fastAdapter, PlantItem item) {
                Log.d(TAG, "onClick: 1");
                ToastUtils.showLong(item.title);
            }
        });

        //fastAdapter.withOnClickListener((v, adapter, item, position) -> {
        //    Log.d(TAG, "onClick: 2");
        //    ToastUtils.showLong(item.title);
        //    return true;
        //});

        List<Plant> plants = PlantBox.getPlants();
        List<PlantItem> items = Stream.of(plants)
                .map(plant -> {
                    PlantItem item = new PlantItem();
                    item.title = plant.getName();
                    item.url = plant.getImageUrl();
                    return item;
                })
                .toList();
        itemAdapter.add(items);

    }
}
