package me.buck.sunflower_java.workers;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import me.buck.sunflower_java.data.AppDatabase;
import me.buck.sunflower_java.data.Plant;

/**
 * Created by gwf on 2019/7/2
 */
public class SeedDatabaseWorker extends Worker {
    public static final String PLANT_DATA_FILENAME = "plants.json";

    private Context mContext;
    private WorkerParameters mWorkerParameters;

    public SeedDatabaseWorker(Context context, WorkerParameters workerParameters) {
        super(context,workerParameters);
        mContext = context;
        mWorkerParameters = workerParameters;
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            InputStream open = getApplicationContext().getAssets().open(PLANT_DATA_FILENAME);

            JsonReader jsonReader = new JsonReader(new InputStreamReader(open));
            TypeToken<List<Plant>> token = new TypeToken<List<Plant>>() {};

            Gson gson = new Gson();
            List<Plant> plants = gson.fromJson(jsonReader, token.getType());
            AppDatabase database = AppDatabase.getInstance(mContext);
            database.plantDao().insertAll(plants);
            return Result.success();
        } catch (IOException e) {
            e.printStackTrace();
            return Result.failure();
        }
    }


}
