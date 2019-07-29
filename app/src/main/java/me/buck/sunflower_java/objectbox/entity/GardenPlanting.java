package me.buck.sunflower_java.objectbox.entity;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import lombok.Data;

/**
 * Created by gwf on 2019/7/26
 */
@Entity
public class GardenPlanting {

    @Id private long id;

    private long   gardenPlantingId;
    private String plantId;
    private String plantDate;
    private String lastWaterDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGardenPlantingId() {
        return gardenPlantingId;
    }

    public void setGardenPlantingId(long gardenPlantingId) {
        this.gardenPlantingId = gardenPlantingId;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(String plantDate) {
        this.plantDate = plantDate;
    }

    public String getLastWaterDate() {
        return lastWaterDate;
    }

    public void setLastWaterDate(String lastWaterDate) {
        this.lastWaterDate = lastWaterDate;
    }
}
