package me.kiuber.base.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created 2017/4/28 0028 22:47
 * Author Kiuber
 * Description
 */

public class PreferenceUtil {

    public static final String FILE_NAME_APP_CONFIG = "app_config";

    /**
     * 存一个
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      键
     * @param value    值
     * @return
     */
    public static boolean putOneValue(Context context, String fileName
            , String key, String value) {
        if (key != null && value != null) {
            context.getSharedPreferences(fileName, Context.MODE_PRIVATE).edit()
                    .putString(key, value).apply();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 取一个
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      键
     * @return
     */
    public static String getOneValue(Context context, String fileName, String key) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if (preferences != null) {
            return preferences.getString(key, "");
        } else {
            return null;
        }
    }

    /**
     * 存多个
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param map      键值集合
     * @return
     */
    public static boolean putMultipleValue(Context context, String fileName
            , Map<String, Object> map) {
        SharedPreferences.Editor edit = context.getSharedPreferences(fileName, Context.MODE_PRIVATE).edit();
        if (edit != null && map != null) {
            for (HashMap.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(entry.getKey(), String.valueOf(value));
                } else if (value instanceof Boolean) {
                    edit.putBoolean(entry.getKey(), Boolean.parseBoolean(String.valueOf(value)));
                } else if (value instanceof Float) {
                    edit.putFloat(entry.getKey(), Float.parseFloat(String.valueOf(value)));
                } else if (value instanceof Integer) {
                    edit.putInt(entry.getKey(), Integer.parseInt(String.valueOf(value)));
                } else if (value instanceof Long) {
                    edit.putLong(entry.getKey(), Long.parseLong(String.valueOf(value)));
                }
            }
            edit.apply();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 取多个
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param keys     键结合
     * @return
     */
    public static Map<String, Object> getMultipleValue(Context context, String fileName, Set<String> keys) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Map<String, Object> values = new HashMap<>();
        if (preferences != null && keys != null) {
            for (String next : keys) {
                try {
                    values.put(next, preferences.getString(next, ""));
                } catch (Exception e) {
                    String message = e.getMessage();
                    if (message.contains("java.lang.Long cannot be cast to java.lang.String")) {
                        values.put(next, preferences.getLong(next, -1));
                    } else if (message.contains("java.lang.Integer cannot be cast to java.lang.String")) {
                        values.put(next, preferences.getInt(next, -1));
                    } else if (message.contains("java.lang.Float cannot be cast to java.lang.String")) {
                        values.put(next, preferences.getFloat(next, -1));
                    } else if (message.contains("java.lang.Boolean cannot be cast to java.lang.String")) {
                        values.put(next, preferences.getBoolean(next, false));
                    }
                    e.printStackTrace();
                }
            }
            return values;
        } else {
            return null;
        }
    }

    /**
     * 取所有
     *
     * @param context  上下文
     * @param fileName 文件名
     * @return
     */
    public static Map<String, ?> getAll(Context context, String fileName) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if (preferences != null) {
            return preferences.getAll();
        } else {
            return null;
        }
    }

    public static boolean clear(Context context, String fileName) {
        try {
            context.getSharedPreferences(fileName, Context.MODE_PRIVATE).edit().clear().apply();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
