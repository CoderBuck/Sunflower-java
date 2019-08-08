package me.buck.sunflower_java;

import android.app.Application;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import me.buck.sunflower_java.objectbox.box.ObjectBox;
import me.buck.sunflower_java.objectbox.box.PlantBox;
import me.buck.sunflower_java.objectbox.entity.Plant;

/**
 * Created by gwf on 2019/7/22
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        ObjectBox.init(this);

        boolean db_init = SPUtils.getInstance().getBoolean("db_init");
        if (!db_init) {
            ThreadUtils.getIoPool().execute(() -> {
                try {
                    InputStream open = getApplicationContext().getAssets().open("plants.json");

                    JsonReader jsonReader = new JsonReader(new InputStreamReader(open));
                    TypeToken<List<Plant>> token = new TypeToken<List<Plant>>() {};

                    Gson gson = new Gson();
                    List<Plant> plants = gson.fromJson(jsonReader, token.getType());
                    PlantBox.insertAll(plants);
                    SPUtils.getInstance().put("db_init", true);

                } catch (IOException e) {
                    e.printStackTrace();

                }
            });
        }
    }
}
