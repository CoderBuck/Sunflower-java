package me.buck.sunflower_java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GardenActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)         Toolbar        mToolbar;
    @BindView(R.id.appbar)          AppBarLayout   mAppbar;
    @BindView(R.id.navigation_view) NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)   DrawerLayout   mDrawerLayout;

    private NavController       mNavController;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden);
        ButterKnife.bind(this);

        mNavController = Navigation.findNavController(this, R.id.garden_nav_fragment);
        mAppBarConfiguration = new AppBarConfiguration.Builder(mNavController.getGraph())
                .setDrawerLayout(mDrawerLayout)
                .build();

        setSupportActionBar(mToolbar);
        NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(mNavigationView, mNavController);



    }
}
