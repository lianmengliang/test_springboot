package com.springboot.utils;

import org.apache.commons.lang3.Conversion;

import java.math.BigInteger;
import java.util.Arrays;

public class ByteUtils {
    /**
     * 字节转数字
     *
     * @param bytes
     * @return
     */
    public static short bytesToShort(byte[] bytes) {
        byte[] dst = Arrays.copyOf(bytes, 2);
        return Conversion.byteArrayToShort(dst, 0, (short) 0, 0, 2);
    }

    /**
     * 字节转数字
     *
     * @param bytes
     * @return
     */
    public static int bytesToInt(byte[] bytes) {
        byte[] dest = Arrays.copyOf(bytes, 4);
        return Conversion.byteArrayToInt(dest, 0, 0, 0, 4);
    }

    /**
     * 字节转数字
     *
     * @param bytes
     * @return
     */
    public static long bytesToLong(byte[] bytes) {
        byte[] dst = Arrays.copyOf(bytes, 8);
        return Conversion.byteArrayToLong(dst, 0, 0, 0, 8);
    }

    /**
     * 字节转数字
     *
     * @param bytes
     * @return
     */
    public static BigInteger bytesToBigInteger(byte[] bytes) {
        return new BigInteger(bytes);
    }

    /**
     * 数字转字节
     *
     * @param num
     * @return
     */
    public static byte[] numberToBytes(short num) {
        byte[] dst = new byte[2];
        return Conversion.shortToByteArray(num, 0, dst, 0, 2);
    }

    /**
     * 数字转字节
     *
     * @param num
     * @return
     */
    public static byte[] numberToBytes(int num) {
        byte[] dst = new byte[4];
        return Conversion.intToByteArray(num, 0, dst, 0, 4);
    }


    /**
     * 数字转字节
     *
     * @param num
     * @return
     */
    public static byte[] numberToBytes(long num) {
        byte[] dst = new byte[8];
        return Conversion.longToByteArray(num, 0, dst, 0, 8);
    }


    /**
     * 数字转字节
     *
     * @param num
     * @return
     */
    public static byte[] numberToBytes(BigInteger num) {
        return num.toByteArray();
    }

}
