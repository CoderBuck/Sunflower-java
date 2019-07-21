package me.buck.sunflower_java.util;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import me.buck.sunflower_java.R;

/**
 * Created by buck on 2019-07-21
 */
public class Utils {

    public static void bindingWateringText(TextView textView, int wateringInterval) {
        Resources resources = textView.getContext().getResources();
        String quantityString = resources.getQuantityString(R.plurals.watering_needs_suffix, wateringInterval, wateringInterval);
//        new SpannableStringBuilder()
        StringBuilder stringBuilder = new StringBuilder()
                .append(resources.getString(R.string.watering_needs_prefix))
                .append(" ")
                .append(quantityString);

        textView.setText(stringBuilder.toString());
    }
}
