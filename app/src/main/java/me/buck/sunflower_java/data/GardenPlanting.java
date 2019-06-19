package me.buck.sunflower_java.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;

import java.util.Calendar;

/**
 * Created by gwf on 2019/6/19
 */
@Entity(
        tableName = "garden_plantings"
)
public class GardenPlanting {

    private String   plantId;
    private Calendar plantDate     = Calendar.getInstance();
    private Calendar lastWaterDate = Calendar.getInstance();

    private long gardenPlantingId = 0;








    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public Calendar getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(Calendar plantDate) {
        this.plantDate = plantDate;
    }

    public Calendar getLastWaterDate() {
        return lastWaterDate;
    }

    public void setLastWaterDate(Calendar lastWaterDate) {
        this.lastWaterDate = lastWaterDate;
    }

    public long getGardenPlantingId() {
        return gardenPlantingId;
    }

    public void setGardenPlantingId(long gardenPlantingId) {
        this.gardenPlantingId = gardenPlantingId;
    }
}
