package me.buck.sunflower_java;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.buck.sunflower_java.objectbox.box.GardenPlantingBox;
import me.buck.sunflower_java.objectbox.box.PlantBox;
import me.buck.sunflower_java.objectbox.entity.GardenPlanting;
import me.buck.sunflower_java.objectbox.entity.Plant;
import me.buck.sunflower_java.util.CommonUtils;

/**
 * Created by buck on 2019-06-18
 */
public class PlantDetailFragment extends Fragment {

    @BindView(R.id.detail_image)            ImageView               mDetailImage;
    @BindView(R.id.toolbar_layout)          CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.appbar)                  AppBarLayout            mAppbar;
    @BindView(R.id.plant_name)              TextView                mPlantName;
    @BindView(R.id.plant_watering)          TextView                mPlantWatering;
    @BindView(R.id.plant_description)       TextView                mPlantDescription;
    @BindView(R.id.plant_detail_scrollview) NestedScrollView        mPlantDetailScrollview;
    @BindView(R.id.fab)                     FloatingActionButton    mFab;


    private PlantDetailFragmentArgs mArgs;
    private String                  mShareText;
    private Unbinder                mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.plant_detail_fragment, container, false);
        mUnbinder = ButterKnife.bind(this, inflate);
        mArgs = PlantDetailFragmentArgs.fromBundle(getArguments());
        String plantId = mArgs.getPlantId();
        Plant plant = PlantBox.getPlant(plantId);

        Glide.with(this)
                .load(plant.getImageUrl())
                .into(mDetailImage);

        mToolbarLayout.setTitle(plant.getName());
        mPlantName.setText(plant.getName());
        CommonUtils.bindingWateringText(mPlantWatering, plant.getWateringInterval());
        CommonUtils.bindingHtml(mPlantDescription, plant.getDescription());
        mShareText = getString(R.string.share_text_plant, plant.getName());

        mFab.setOnClickListener(v -> {
            GardenPlanting gardenPlanting = new GardenPlanting();
            gardenPlanting.setPlantId(plantId);
            LocalDateTime localDateTime = LocalDateTime.now();
            int interval = plant.getWateringInterval();
            LocalDateTime plusDays = localDateTime.plusDays(interval);
            gardenPlanting.setPlantDate(localDateTime.toString());
            gardenPlanting.setLastWaterDate(plusDays.toString());
            GardenPlantingBox.insertGardenPlanting(gardenPlanting);
            Snackbar.make(v, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show();
        });
        setHasOptionsMenu(true);
        return inflate;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_plant_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_share) {
            Intent chooserIntent = ShareCompat.IntentBuilder.from(requireActivity())
                    .setText(mShareText)
                    .setType("text/plain")
                    .createChooserIntent();

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            } else {
                chooserIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            }
            startActivity(chooserIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
