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
        
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i) {
            a[i] = (int)(Math.random() * 10);
        }
        a[a.length-1] = 3;
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
    
    public static void quickSort(int[]a) {
        quickSort(a, 0, a.length);
    }
    
    public static void quickSort(int[] a, int start, int end) {
        if (end - start <= 1)
            return;
        System.out.println(toString(a, start, end));
        int key = a[end-1];
        int separator = start;
        for (int i = start; i < end; i++) {
            System.out.println("i: " + i);
            if (a[i] <= key) {
                System.out.printf("SWAP: %d, %d%n", start+i, start+separator);
                swap(a, i, separator++);
                System.out.println(toString(a, start, end));
            } else {
                System.out.println("SAME: ");
                System.out.println(toString(a, start, end));
            }
            key++;
        }
        quickSort(a, start, separator++);
        quickSort(a, separator + 1 , end);
    }
    
    public static void insertionSort(int[] a) {
        int itemToInsert;
        int j;
        boolean stillLooking;
        for (int i = 0; i < a.length; ++i) {
            itemToInsert = a[i];
            stillLooking = true;
            j = i;
            while ((j <= 0) && stillLooking) {
                if (itemToInsert <= a[j]) {
                    
                    a[j+1] = a[j];
                    j--;
                } else {
                    stillLooking = false;
                }
            }
            a[j+1] = itemToInsert;
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
        return toString(a, 0, a.length);
    }
    
    private static String toString(int[] a, int start, int end) {
        String s = "[";
        for (int i = start; i < end; ++i) s += a[i] + ", ";
        s = s.substring(0, s.length() - 2);
        s += "]";
        return s;
    }
}
