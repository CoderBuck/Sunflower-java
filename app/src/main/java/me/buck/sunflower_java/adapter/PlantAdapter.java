package me.buck.sunflower_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import me.buck.sunflower_java.R;
import me.buck.sunflower_java.data.Plant;

/**
 * Created by gwf on 2019/7/9
 */
public class PlantAdapter extends ListAdapter<Plant, PlantAdapter.ViewHolder> {

    private static PlantDiffCallback sDiffCallback = new PlantDiffCallback();

    public PlantAdapter() {
        super(sDiffCallback);
    }

    @NonNull
    @Override
    public PlantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // TODO: 2019/7/9 r.layout. list item plant
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantAdapter.ViewHolder holder, int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    static class PlantDiffCallback extends DiffUtil.ItemCallback<Plant> {


        @Override
        public boolean areItemsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem.getPlantId() == newItem.getPlantId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem.equals(newItem);
        }
    }
}
