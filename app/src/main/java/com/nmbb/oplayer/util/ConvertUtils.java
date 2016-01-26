package com.nmbb.oplayer.util;

import android.content.Context;

/**
 * Êý¾Ý×ª»»Àà
 * Created by xuebp on 2016/1/26.
 */
public final class ConvertUtils {
    private static final float UNIT = 1000.0F;

    /**
     * ºÁÃë×ªÃë
     *
     * @param time ºÁÃë
     * @return
     */
    public static float ms2s(long time) {
        return time / UNIT;
    }

    /**
     * Î¢Ãë×ªÃë
     *
     * @param time Î¢Ãë
     * @return
     */
    public static float us2s(long time) {
        return time / UNIT / UNIT;
    }

    /**
     * ÄÉÃë×ªÃë
     *
     * @param time ÄÉÃë
     * @return
     */
    public static float ns2s(long time) {
        return time / UNIT / UNIT / UNIT;
    }

    /**
     * ×ª»»×Ö·û´®Îªboolean
     *
     * @param str
     * @return
     */
    public static boolean toBoolean(String str) {
        return toBoolean(str, false);
    }

    /**
     * ×ª»»×Ö·û´®Îªboolean
     *
     * @param str
     * @param def
     * @return
     */
    public static boolean toBoolean(String str, boolean def) {
        if (StringUtils.isEmpty(str))
            return def;
        if ("false".equalsIgnoreCase(str) || "0".equals(str))
            return false;
        else if ("true".equalsIgnoreCase(str) || "1".equals(str))
            return true;
        else
            return def;
    }

    /**
     * ×ª»»×Ö·û´®Îªfloat
     *
     * @param str
     * @return
     */
    public static float toFloat(String str) {
        return toFloat(str, 0F);
    }

    /**
     * ×ª»»×Ö·û´®Îªfloat
     *
     * @param str
     * @param def
     * @return
     */
    public static float toFloat(String str, float def) {
        if (StringUtils.isEmpty(str))
            return def;
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    /**
     * ×ª»»×Ö·û´®Îªlong
     *
     * @param str
     * @return
     */
    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    /**
     * ×ª»»×Ö·û´®Îªlong
     *
     * @param str
     * @param def
     * @return
     */
    public static long toLong(String str, long def) {
        if (StringUtils.isEmpty(str))
            return def;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    /**
     * ×ª»»×Ö·û´®Îªshort
     *
     * @param str
     * @return
     */
    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    /**
     * ×ª»»×Ö·û´®Îªshort
     *
     * @param str
     * @param def
     * @return
     */
    public static short toShort(String str, short def) {
        if (StringUtils.isEmpty(str))
            return def;
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    /**
     * ×ª»»×Ö·û´®Îªint
     *
     * @param str
     * @return
     */
    public static int toInt(String str) {
        return toInt(str, 0);
    }

    /**
     * ×ª»»×Ö·û´®Îªint
     *
     * @param str
     * @param def
     * @return
     */
    public static int toInt(String str, int def) {
        if (StringUtils.isEmpty(str))
            return def;
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    public static String toString(Object o) {
        return toString(o, "");
    }

    public static String toString(Object o, String def) {
        if (o == null)
            return def;

        return o.toString();
    }

    public static int dipToPX(final Context ctx, int dip) {
        float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (dip / 1.5D * scale + 0.5D);
    }
}
