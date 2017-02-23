/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.sorting;

/**
 *
 * @author gvandomelen19
 */
public class Sorting {
    
    public static void main(String[] args) {
        
        int[] a = new int[100000];
        for (int i = 0; i < a.length; ++i) {
            a[i] = (int)(Math.random() * Integer.MAX_VALUE);
        }
        System.out.println(toString(a));
        quickSort(a);
        System.out.println(toString(a));
    }
    
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            int minIndex = findMinimum(a,i);
            if (minIndex != i)
                swap(a, i, minIndex);
        }
    }
    
    public static void quickSort(int[] a) {
        if (a.length <= 1) return;
        int[] left = new int[(int)Math.floor(a.length/2.0)];
        for (int i = 0; i < left.length; i++) {
            left[i] = a[i];
        }
        int[] right = new int[(int)Math.ceil(a.length/2.0)];
        for (int i = left.length + 1; i < a.length; i++) {
            right[i-left.length] = a[i];
        }
        quickSort(left);
        quickSort(right);
        for (int i = 0; i < a.length; ++i) {
            if (i < left.length) a[i] = left[i];
            else a[i] = right[i-left.length];
        }
    }
    
    private static int findMinimum(int[] a, int first) {
        int minIndex = first;
        for (int i = first; i < a.length; ++i) {
            if (a[i] < a[minIndex]) minIndex = i;
        }
        return minIndex;
    }
    
    private static void swap(int[] a, int first, int second) {
        int tmp = a[first];
        a[first] = a[second];
        a[second] = tmp;
    }
    
    private static String toString(int[] a) {
        String s = "[";
        for (int i : a) s += i + ", ";
        s = s.substring(0, s.length() - 2);
        s += "]";
        return s;
    }
}
