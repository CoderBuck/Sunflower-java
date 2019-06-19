package me.buck.sunflower_java.data;

import androidx.room.Embedded;

import java.util.Objects;

/**
 * Created by buck on 2019-06-18
 */
public class PlantAndGardenPlantings {

    @Embedded
    private Plant plant;



    public Plant getPlant() {
        return plant;
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
