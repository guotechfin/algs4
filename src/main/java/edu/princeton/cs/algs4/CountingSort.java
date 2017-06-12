package edu.princeton.cs.algs4;

import java.util.Arrays;

/**
 * CHECK LSD
 */
public class CountingSort {

    /**
     * c[a[i]] = target location
     */
    public static int[] countingSort(int[] a, int k) {
        int c[] = new int[k];
        for (int i = 0; i < a.length; i++)
            c[a[i]]++;
        for (int i = 1; i < k; i++)
            c[i] += c[i-1];
        int b[] = new int[a.length];
        //move data to target location, with adjust next round location
        //approach one
//        for (int i = a.length-1; i >= 0; i--)
//            b[--c[a[i]]] = a[i];
        //approach two
        for (int i = 0; i <a.length; i++)
            b[--c[a[i]]] = a[i];
        return b;
    }

    public static void main(String[] args) {
        int[] a = {7,2,9,0,1,2,0,9,7,4,4,6,9,1,0,9,3,2,5,9};
        int[] b = countingSort(a,10);
        System.out.println(Arrays.toString(b));
    }
}
