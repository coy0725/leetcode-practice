package com.coy.algorithms.sorting;

import java.util.Comparator;

/**
 * @author coy
 * @since 2022/3/19
 **/
public class Shell {
    public static void main(String[] args) {
        String [] integers = {"A","12","45","6a"};
        sort(integers);

    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;

        int h = 1;
        while (h<n/3){
            h = 3*h+1;
        }
        while (h>=1){
            for (int i = 0; i < n; i++) {
                for (int j = i; j > h; h= j-h) {
                    if (less(a[j], a[j - h])) {
                        exch(a,j,j-h);
                    }else
                        break;

                }
                h= h/3;
            }
        }


        assert isSorted(a);
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }


    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int maxprofit = 0;
            int minPrice =prices[0];
            for (int i = 0; i < prices.length - 1; i++) {

            }
            return maxprofit;

        }
    }
}
