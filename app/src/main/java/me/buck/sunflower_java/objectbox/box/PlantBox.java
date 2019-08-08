package me.buck.sunflower_java.objectbox.box;

import java.util.List;

import io.objectbox.Box;
import me.buck.sunflower_java.objectbox.entity.Plant;
import me.buck.sunflower_java.objectbox.entity.Plant_;

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
        return getPlantBox().query()
                .filter(entity -> entity.getGrowZoneNumber() == num)
                .build().find();
    }

    public static List<Plant> getPlant(String plantId) {
        return getPlantBox().query()
                .equal(Plant_.plantId, plantId)
                .build().find();
    }

    public static void insertAll(List<Plant> plants) {
        getPlantBox().put(plants);
    }


}
