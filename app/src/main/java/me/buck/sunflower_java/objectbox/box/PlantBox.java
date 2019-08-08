package me.buck.sunflower_java.objectbox.box;

import java.util.Collections;
import java.util.Comparator;
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

//        List<Plant> plants = getPlantBox().getAll();
//        Collections.sort(plants, new Comparator<Plant>() {
//            @Override
//            public int compare(Plant o1, Plant o2) {
//                return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
//            }
//        });

        List<Plant> plants1 = getPlantBox().query()
                .order(Plant_.name)
                .build()
                .find();

        return plants1;
    }

    public static List<Plant> getPlantsWithGrowZoneNumber(int num) {
        return getPlantBox().query()
                .filter(entity -> entity.getGrowZoneNumber() == num)
                .build().find();
    }

    public static Plant getPlant(String plantId) {
        return getPlantBox().query()
                .equal(Plant_.plantId, plantId)
                .build().findFirst();
    }

    public static void insertAll(List<Plant> plants) {
        getPlantBox().put(plants);
    }


}
