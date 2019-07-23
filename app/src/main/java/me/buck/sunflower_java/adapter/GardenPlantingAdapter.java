package me.buck.sunflower_java.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import me.buck.sunflower_java.GardenFragmentDirections;
import me.buck.sunflower_java.R;
import me.buck.sunflower_java.data.GardenPlanting;
import me.buck.sunflower_java.data.Plant;
import me.buck.sunflower_java.data.PlantAndGardenPlantings;

/**
 * Created by buck on 2019-06-18Ø
 */
public class GardenPlantingAdapter extends ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.Holder> {

    public GardenPlantingAdapter() {
        super(InnerDiffCallback.create());
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_garden_planting, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        PlantAndGardenPlantings item = getItem(position);
        holder.itemView.setTag(item);
        holder.itemView.setOnClickListener(v -> {
            GardenFragmentDirections.ActionGardenFragmentToPlantDetailFragment fragment
                    = GardenFragmentDirections.actionGardenFragmentToPlantDetailFragment(item.getPlant().getPlantId());
            Navigation.findNavController(v).navigate(fragment);
        });

        Glide.with(holder.imageView)
                .load(item.getPlant().getImageUrl())
                .into(holder.imageView);

        Resources resources = holder.itemView.getContext().getResources();
        GardenPlanting planting = item.getGardenPlantings().get(0);
        Date time = planting.getLastWaterDate().getTime();
        SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy", Locale.US);
        String format1 = format.format(time);
        String water_next_prefix = resources.getString(R.string.watering_next_prefix,format1);

        Plant plant = item.getPlant();
        int interval = plant.getWateringInterval();
        String water_next_suffix = resources.getQuantityString(R.plurals.watering_next_suffix,interval,interval);
        String water_date = resources.getString(R.string.water_date,water_next_prefix,water_next_suffix);
        holder.waterDate.setText(water_date);

        String plantName = plant.getName();
        String format2 = format.format(planting.getPlantDate().getTime());
        String string = resources.getString(R.string.planted_date, plantName, format2);
        holder.plantDate.setText(string);
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView  plantDate, waterDate;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            plantDate = itemView.findViewById(R.id.plant_date);
            waterDate = itemView.findViewById(R.id.water_date);
        }
    }

    static class InnerDiffCallback extends DiffUtil.ItemCallback<PlantAndGardenPlantings> {
        @Override
        public boolean areItemsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
            return Objects.equals(
                    oldItem.getPlant().getPlantId(),
                    newItem.getPlant().getPlantId()
            );
        }

        @Override
        public boolean areContentsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
            return Objects.equals(
                    oldItem.getPlant(),
                    newItem.getPlant()
            );
        }

        public static InnerDiffCallback create() {
            return new InnerDiffCallback();
        }
    }

}
