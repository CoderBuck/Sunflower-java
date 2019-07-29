package me.buck.sunflower_java.objectbox.box;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.query.Query;
import me.buck.sunflower_java.objectbox.entity.Plant;

/**
 * Created by gwf on 2019/7/29
 */
public class PlantBox {

    private static Box<Plant> sPlantBox;

    public static Box<Plant> getPlantBox() {
        if (sPlantBox == null) {
            sPlantBox = ObjectBox.get().boxFor(Plant.class);
        }
        return sPlantBox;
    }

    public static List<Plant> getPlants() {
        return getPlantBox().getAll();
    }

    public static List<Plant> getPlantsWithGrowZoneNumber(int num) {
        Query<Plant> build = getPlantBox().query()
                .filter(entity -> entity.getGrowZoneNumber() == num)
                .build();
        return build.find();
    }


}
