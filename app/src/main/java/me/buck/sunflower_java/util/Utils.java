package me.buck.sunflower_java.util;

import android.content.res.Resources;
import android.widget.TextView;

import com.blankj.utilcode.util.SpanUtils;

import me.buck.sunflower_java.R;

/**
 * Created by buck on 2019-07-21
 */
public class Utils {

    public static void bindingWateringText(TextView textView, int wateringInterval) {
        Resources resources = textView.getContext().getResources();
        String quantityString = resources.getQuantityString(R.plurals.watering_needs_suffix, wateringInterval, wateringInterval);
        String prefix = resources.getString(R.string.watering_needs_prefix);
        SpanUtils.with(textView)
                .append(prefix).setBold()
                .append(" ")
                .append(quantityString).setItalic()
                .create();
    }
}
