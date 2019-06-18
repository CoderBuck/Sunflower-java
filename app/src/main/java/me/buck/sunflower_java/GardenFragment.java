package me.buck.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by buck on 2019-06-18
 */
public class GardenFragment extends Fragment {

    @BindView(R.id.garden_list)  RecyclerView mGardenList;
    @BindView(R.id.empty_garden) TextView     mEmptyGarden;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.garden_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
