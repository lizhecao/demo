package com.test.hashmap;

/**
 * @description:
 * @author: 李哲操
 * @create: 2021-03-04 17:42
 **/
public class FindNumberOnlyOnce {
    public static int getOnce(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 3, 4, 4, 3};
        System.out.println(getOnce(arr));
        int[] arr1 = new int[]{4,1,2,1,2};
        System.out.println(getOnce(arr1));
    }
}
