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

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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
    //private PlantDetailViewModel    mViewModel;
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
        //PlantDetailViewModelFactory factory = InjectorUtils
        //        .providePlantDetailViewModelFactory(requireActivity(), mArgs.getPlantId());
        //mViewModel = ViewModelProviders.of(this, factory).get(PlantDetailViewModel.class);
        //mViewModel.getPlant().observe(this, plant -> {
        //    mToolbarLayout.setTitle(plant.getName());
        //    Glide.with(getActivity()).load(plant.getImageUrl()).into(mDetailImage);
        //    mPlantName.setText(plant.getName());
        //    CommonUtils.bindingWateringText(mPlantWatering,plant.getWateringInterval());
        //    CommonUtils.bindingHtml(mPlantDescription,plant.getDescription());
        //
        //    if (plant == null) {
        //        mShareText = "";
        //    } else {
        //        mShareText = getString(R.string.share_text_plant, plant.getName());
        //    }
        //});
        //
        //mFab.setOnClickListener(v -> {
        //    mViewModel.addPlantToGarden();
        //    Snackbar.make(v, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show();
        //});
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
            Intent chooserIntent = ShareCompat.IntentBuilder.from(getActivity())
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
