package me.buck.sunflower_java.adapter;

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

import java.util.Objects;

import me.buck.sunflower_java.PlantListFragmentDirections;
import me.buck.sunflower_java.R;
import me.buck.sunflower_java.data.Plant;

/**
 * Created by gwf on 2019/7/9
 */
public class PlantAdapter extends ListAdapter<Plant, PlantAdapter.ViewHolder> {

    public PlantAdapter() {
        super(PlantDiffCallback.create());
    }

    @NonNull
    @Override
    public PlantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantAdapter.ViewHolder holder, int position) {
        Plant plant = getItem(position);
        holder.itemView.setTag(plant);
        holder.itemView.setOnClickListener(createOnClickListener(plant.getPlantId()));
        Glide.with(holder.img.getContext())
                .load(plant.getImageUrl())
                .into(holder.img);
        holder.title.setText(plant.getName());
    }

    private View.OnClickListener createOnClickListener(String plantId) {
        return v -> {
            Navigation
                    .findNavController(v)
                    .navigate(
                            PlantListFragmentDirections.actionPlantListFragmentToPlantDetailFragment(plantId)
                    );
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView  title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.plant_item_image);
            title = itemView.findViewById(R.id.plant_item_title);
        }
    }

    static class PlantDiffCallback extends DiffUtil.ItemCallback<Plant> {

        @Override
        public boolean areItemsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return Objects.equals(oldItem.getPlantId(), newItem.getPlantId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return Objects.equals(oldItem, newItem);
        }

        public static PlantDiffCallback create() {
            return new PlantDiffCallback();
        }
    }
}
