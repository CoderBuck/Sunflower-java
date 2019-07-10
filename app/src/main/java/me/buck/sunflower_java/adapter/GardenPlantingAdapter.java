package me.buck.sunflower_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import me.buck.sunflower_java.R;
import me.buck.sunflower_java.data.PlantAndGardenPlantings;

/**
 * Created by buck on 2019-06-18Ø
 */
public class GardenPlantingAdapter extends ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.Holder> {

    private static InnerDiffCallback sDiffCallback = new InnerDiffCallback();

    public GardenPlantingAdapter() {
        super(sDiffCallback);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                // TODO: 2019/7/9 list item
                .inflate(R.layout.list_item_garden_planting, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        PlantAndGardenPlantings item = getItem(position);
        holder.itemView.setTag(item);
    }

    class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
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
    }

}
