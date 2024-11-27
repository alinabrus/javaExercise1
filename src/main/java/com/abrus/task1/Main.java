package com.abrus.task1;

import java.util.Arrays;

/*
https://leetcode.com/problems/move-zeroes/description/
 */
public class Main {
    public static void main(String[] args) {
        processArray(new int[]{0,1,0,3,12});
        processArray(new int[]{0});
        processArray(new int[]{});
    }

    public static void processArray(int[] nums) {
        printArray("Input: ", nums);
        moveZeroes(nums);
        printArray("Result: ", nums);
        System.out.println();
    }

    private static void printArray(String prefix, int[] arr) {
        System.out.println(prefix + Arrays.toString(arr));
    }

    private static void swapItems(int[] arr, int pos1, int pos2) {
        int buf = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = buf;
    }

    public static void moveZeroes(int[] nums) {
        final int minLength = 1;
        final int maxLength = 10000;
        if (nums.length < minLength || nums.length > maxLength) {
            System.out.println("Input array can not be processed. " +
                    "Valid input length must be in range [" + minLength + ", " + maxLength + "].");
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 0 && nums[j] != 0) {
                    swapItems(nums, i, j);
                    printArray("-> ", nums);
                }
            }
        }
    }
}
