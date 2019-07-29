package me.buck.sunflower_java;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

import me.buck.sunflower_java.objectbox.box.ObjectBox;

/**
 * Created by gwf on 2019/7/22
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        ObjectBox.init(this);
    }
}
