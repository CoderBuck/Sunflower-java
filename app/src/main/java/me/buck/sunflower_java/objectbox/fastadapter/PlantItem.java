package me.buck.sunflower_java.objectbox.fastadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.buck.sunflower_java.R;

/**
 * Created by buck on 2019-07-29
 */
public class PlantItem extends AbstractItem<PlantItem, PlantItem.ViewHolder> {

    public String title;
    public String url;

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.plant_item_type;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_plant;
    }

    public class ViewHolder extends FastAdapter.ViewHolder<PlantItem> {
        @BindView(R.id.plant_item_image) ImageView mPlantItemImage;
        @BindView(R.id.plant_item_title) TextView  mPlantItemTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void bindView(PlantItem item, List<Object> payloads) {
            mPlantItemTitle.setText(item.title);
            Glide.with(itemView.getContext())
                    .load(item.url)
                    .into(mPlantItemImage);
        }

        @Override
        public void unbindView(PlantItem item) {

        }
    }
}
