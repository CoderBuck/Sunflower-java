package me.buck.sunflower_java.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by buck on 2019-06-18
 */
public class PlantAndGardenPlantings {

    @Embedded
    public Plant plant;

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    public List<GardenPlanting> gardenPlantings = new ArrayList<>();



    public Plant getPlant() {
        return plant;
    }

    public List<GardenPlanting> getGardenPlantings() {
        return gardenPlantings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantAndGardenPlantings plantings = (PlantAndGardenPlantings) o;
        return plant.equals(plantings.plant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plant);
    }
}
