package com.nmbb.oplayer.util;

import android.content.Context;

/**
 * ����ת����
 * Created by xuebp on 2016/1/26.
 */
public final class ConvertUtils {
    private static final float UNIT = 1000.0F;

    /**
     * ����ת��
     *
     * @param time ����
     * @return
     */
    public static float ms2s(long time) {
        return time / UNIT;
    }

    /**
     * ΢��ת��
     *
     * @param time ΢��
     * @return
     */
    public static float us2s(long time) {
        return time / UNIT / UNIT;
    }

    /**
     * ����ת��
     *
     * @param time ����
     * @return
     */
    public static float ns2s(long time) {
        return time / UNIT / UNIT / UNIT;
    }

    /**
     * ת���ַ���Ϊboolean
     *
     * @param str
     * @return
     */
    public static boolean toBoolean(String str) {
        return toBoolean(str, false);
    }

    /**
     * ת���ַ���Ϊboolean
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
     * ת���ַ���Ϊfloat
     *
     * @param str
     * @return
     */
    public static float toFloat(String str) {
        return toFloat(str, 0F);
    }

    /**
     * ת���ַ���Ϊfloat
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
     * ת���ַ���Ϊlong
     *
     * @param str
     * @return
     */
    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    /**
     * ת���ַ���Ϊlong
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
     * ת���ַ���Ϊshort
     *
     * @param str
     * @return
     */
    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    /**
     * ת���ַ���Ϊshort
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
     * ת���ַ���Ϊint
     *
     * @param str
     * @return
     */
    public static int toInt(String str) {
        return toInt(str, 0);
    }

    /**
     * ת���ַ���Ϊint
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
