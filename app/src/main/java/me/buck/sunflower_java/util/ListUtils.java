package me.buck.sunflower_java.util;

import java.util.List;

/**
 * Created by gwf on 2019/7/16
 */
public class ListUtils {

    public static boolean isNullOrEmpty(List list) {
        return list == null || list.isEmpty();
    }
}
