package me.buck.sunflower_java.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.items.ModelAbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.buck.sunflower_java.PlantListFragmentDirections;
import me.buck.sunflower_java.R;
import me.buck.sunflower_java.objectbox.entity.Plant;

/**
 * Created by gwf on 2019/8/8
 */
public class PlantItem extends ModelAbstractItem<Plant, PlantItem, PlantItem.Holder> {
    private static final String TAG = "PlantItem";



    public PlantItem(Plant plant) {
        super(plant);
    }

    @NonNull
    @Override
    public Holder getViewHolder(View v) {
        return new Holder(v);
    }

    @Override
    public int getType() {
        return ItemType.PlantingItem;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_plant;
    }

    @Override
    public void bindView(Holder holder, List<Object> payloads) {
        super.bindView(holder, payloads);
        Plant plant = getModel();
        Glide.with(holder.itemView.getContext())
                .load(plant.getImageUrl())
                .into(holder.mPlantItemImage);

        holder.mPlantItemTitle.setText(plant.getName());
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.plant_item_image) ImageView mPlantItemImage;
        @BindView(R.id.plant_item_title) TextView  mPlantItemTitle;


        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                PlantItem item = FastAdapter.getHolderAdapterItem(this);
                Plant plant = item.getModel();
                Log.d(TAG, "Holder: plant = " + plant.getPlantId());
                Navigation.findNavController(itemView)
                        .navigate(PlantListFragmentDirections
                                .actionPlantListFragmentToPlantDetailFragment(plant.getPlantId()));
            });
        }
    }
}
