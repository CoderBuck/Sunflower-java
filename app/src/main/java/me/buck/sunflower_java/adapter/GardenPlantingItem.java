package me.buck.sunflower_java.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mikepenz.fastadapter.items.ModelAbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.buck.sunflower_java.R;
import me.buck.sunflower_java.objectbox.box.PlantBox;
import me.buck.sunflower_java.objectbox.entity.GardenPlanting;
import me.buck.sunflower_java.objectbox.entity.Plant;

/**
 * Created by gwf on 2019/8/8
 */
public class GardenPlantingItem extends ModelAbstractItem<GardenPlanting, GardenPlantingItem, GardenPlantingItem.Holer> {



    public GardenPlantingItem(GardenPlanting planting) {
        super(planting);
    }

    @NonNull
    @Override
    public Holer getViewHolder(View v) {
        return new Holer(v);
    }

    @Override
    public int getType() {
        return ItemType.GardenPlantingItem;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_garden_planting;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void bindView(Holer holder, List<Object> payloads) {
        super.bindView(holder, payloads);
        GardenPlanting gardenPlanting = getModel();
        String plantId = gardenPlanting.getPlantId();
        Plant plant = PlantBox.getPlant(plantId);
        holder.mGardenPlanting = gardenPlanting;
        Glide.with(holder.itemView.getContext())
                .load(plant.getImageUrl())
                .into(holder.mImageView);

        holder.mPlantDate.setText(gardenPlanting.getPlantDate());
        holder.mWaterDate.setText(gardenPlanting.getLastWaterDate() +"  "+  plant.getWateringInterval());

    }

    @Override
    public void unbindView(Holer holder) {
        super.unbindView(holder);

    }

    public class Holer extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)  ImageView mImageView;
        @BindView(R.id.plant_date) TextView  mPlantDate;
        @BindView(R.id.water_date) TextView  mWaterDate;

        GardenPlanting mGardenPlanting;

        public Holer(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
