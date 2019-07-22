package me.buck.sunflower_java.util;

import android.content.res.Resources;
import android.text.Spanned;
import android.widget.TextView;

import androidx.core.text.HtmlCompat;

import com.blankj.utilcode.util.SpanUtils;

import me.buck.sunflower_java.R;

/**
 * Created by buck on 2019-07-21
 */
public class CommonUtils {

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

    public static void bindingHtml(TextView textView, String html) {
        if (html == null) {
            textView.setText("");
        } else {
            Spanned fromHtml = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT);
            textView.setText(fromHtml);
        }
    }
}
