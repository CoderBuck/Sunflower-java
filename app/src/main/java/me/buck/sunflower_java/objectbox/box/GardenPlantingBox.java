package me.buck.sunflower_java.objectbox.box;

import java.util.List;

import io.objectbox.Box;
import me.buck.sunflower_java.objectbox.entity.GardenPlanting;
import me.buck.sunflower_java.objectbox.entity.GardenPlanting_;

/**
 * Created by buck on 2019-07-29
 */
public class GardenPlantingBox {

    private static Box<GardenPlanting> sGardenPlantingBox
            = ObjectBox.get().boxFor(GardenPlanting.class);

    public static List<GardenPlanting> getGardenPlantings() {
        return sGardenPlantingBox.getAll();
    }

    public static GardenPlanting getGardenPlanting(long gardenPlantingId) {
        return sGardenPlantingBox.query()
                .equal(GardenPlanting_.gardenPlantingId, gardenPlantingId)
                .build().findFirst();
    }

    public static GardenPlanting getGardenPlantingForPlant(String plantId) {
        return sGardenPlantingBox.query()
                .equal(GardenPlanting_.plantId, plantId)
                .build()
                .findFirst();
    }

    public static void insertGardenPlanting(GardenPlanting gardenPlanting) {
        sGardenPlantingBox.put(gardenPlanting);
    }

    public static void deleteGardenPlanting(GardenPlanting gardenPlanting) {
        List<GardenPlanting> plantings = sGardenPlantingBox.query()
                .equal(GardenPlanting_.gardenPlantingId, gardenPlanting.getGardenPlantingId())
                .build()
                .find();
        sGardenPlantingBox.remove(plantings);

    }


}
