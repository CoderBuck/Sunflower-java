package me.buck.sunflower_java.objectbox.box;

import android.content.Context;

import io.objectbox.BoxStore;
import io.objectbox.BoxStoreBuilder;
import me.buck.sunflower_java.objectbox.entity.MyObjectBox;

/**
 * Created by gwf on 2019/7/29
 */
public class ObjectBox {

    private static BoxStore sBoxStore;

    public static void init(Context context) {
        sBoxStore = MyObjectBox.builder()
                .androidContext(context)
                .build();
    }

    public static BoxStore get() {
        return sBoxStore;
    }
}
