package me.buck.sunflower_java.objectbox.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Function;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.buck.sunflower_java.R;
import me.buck.sunflower_java.objectbox.box.PlantBox;
import me.buck.sunflower_java.objectbox.entity.Plant;
import me.buck.sunflower_java.objectbox.fastadapter.PlantItem;

public class MainActivity2 extends AppCompatActivity {

    @BindView(R.id.plant_list) RecyclerView mPlantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_list_fragment);
        ButterKnife.bind(this);

        ItemAdapter<PlantItem> itemAdapter = new ItemAdapter<>();
        FastAdapter<IItem> fastAdapter = FastAdapter.with(itemAdapter);
        mPlantList.setAdapter(fastAdapter);
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
