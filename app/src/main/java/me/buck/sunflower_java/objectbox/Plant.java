package me.buck.sunflower_java.objectbox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by gwf on 2019/7/26
 */
@Entity
public class Plant {

    @Id private long id;


    /**
     * plantId : 1
     * name : Apple
     * description : An apple is a sweet, edible fruit produced by an apple tree (Malus pumila). Apple trees are cultivated worldwide, and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today. Apples have been grown for thousands of years in Asia and Europe, and were brought to North America by European colonists. Apples have religious and mythological significance in many cultures, including Norse, Greek and European Christian traditions.<br><br>Apple trees are large if grown from seed. Generally apple cultivars are propagated by grafting onto rootstocks, which control the size of the resulting tree. There are more than 7,500 known cultivars of apples, resulting in a range of desired characteristics. Different cultivars are bred for various tastes and uses, including cooking, eating raw and cider production. Trees and fruit are prone to a number of fungal, bacterial and pest problems, which can be controlled by a number of organic and non-organic means. In 2010, the fruit's genome was sequenced as part of research on disease control and selective breeding in apple production.<br><br>Worldwide production of apples in 2014 was 84.6 million tonnes, with China accounting for 48% of the total.<br><br>(From <a href="https://en.wikipedia.org/wiki/Apple">Wikipedia</a>)
     * growZoneNumber : 3
     * wateringInterval : 30
     * imageUrl : https://upload.wikimedia.org/wikipedia/commons/5/55/Apple_orchard_in_Tasmania.jpg
     */

    private String plantId;
    private String name;
    private String description;
    private int    growZoneNumber;
    private int    wateringInterval;
    private String imageUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlantId()                     { return plantId;}

    public void setPlantId(String plantId)         { this.plantId = plantId;}

    public String getName()                        { return name;}

    public void setName(String name)               { this.name = name;}

    public String getDescription()                 { return description;}

    public void setDescription(String description) { this.description = description;}

    public int getGrowZoneNumber()                 { return growZoneNumber;}

    public void setGrowZoneNumber(int growZoneNumber)     { this.growZoneNumber = growZoneNumber;}

    public int getWateringInterval()                      { return wateringInterval;}

    public void setWateringInterval(int wateringInterval) { this.wateringInterval = wateringInterval;}

    public String getImageUrl()                           { return imageUrl;}

    public void setImageUrl(String imageUrl)              { this.imageUrl = imageUrl;}
}
