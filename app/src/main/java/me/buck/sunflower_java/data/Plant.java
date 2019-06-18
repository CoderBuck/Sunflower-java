package me.buck.sunflower_java.data;

import java.util.Objects;

/**
 * Created by buck on 2019-06-18
 */
public class Plant {

    private String plantId;

    private String name;
    private String description;
    private int    growZoneNumber;
    private int    wateringInterval = 7;
    private String imageUrl         = "";



    public Plant(String name, String description, int growZoneNumber, int wateringInterval, String imageUrl) {
        this.name = name;
        this.description = description;
        this.growZoneNumber = growZoneNumber;
        this.wateringInterval = wateringInterval;
        this.imageUrl = imageUrl;
    }

    public String getPlantId() {
        return plantId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getGrowZoneNumber() {
        return growZoneNumber;
    }

    public int getWateringInterval() {
        return wateringInterval;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return growZoneNumber == plant.growZoneNumber &&
                wateringInterval == plant.wateringInterval &&
                plantId.equals(plant.plantId) &&
                name.equals(plant.name) &&
                description.equals(plant.description) &&
                imageUrl.equals(plant.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plantId, name, description, growZoneNumber, wateringInterval, imageUrl);
    }
}
