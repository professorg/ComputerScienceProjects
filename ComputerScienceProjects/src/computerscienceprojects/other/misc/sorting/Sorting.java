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

        int n = Short.MAX_VALUE;
        int failures = 0;
        int[] a = new int[n];
        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {

            if ((double) (i*100) / n == (i*100) / n) System.out.printf("\rProgress:%4d%%", (i*100) / n);
            for (int j = 0; j < a.length; ++j) {
                a[j] = (int) (Math.random() * n);
            }
            // System.out.print(toString(a) + " -> ");
            quickSort(a);
            // System.out.println(toString(a));
            if (!isSorted(a)) failures++;
        }
        time -= System.currentTimeMillis();
        time *= -1;
        System.out.println("\rProgress: 100%\nCompleted " + n + " quicksorts in " + time + " milliseconds.");
        System.out.println("FAILURES: " + failures);
        time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {

            if ((double) (i*100) / n == (i*100) / n) System.out.printf("\rProgress:%4d%%", (i*100) / n);
            for (int j = 0; j < a.length; ++j) {
                a[j] = (int) (Math.random() * n);
            }
            // System.out.print(toString(a) + " -> ");
            insertionSort(a);
            // System.out.println(toString(a));
            if (!isSorted(a)) failures++;
        }
        time -= System.currentTimeMillis();
        time *= -1;
        System.out.println("\rProgress: 100%\nCompleted " + n + " quicksorts in " + time + " milliseconds.");
        System.out.println("FAILURES: " + failures);
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            int minIndex = findMinimum(a, i);
            if (minIndex != i) {
                swap(a, i, minIndex);
            }
        }
    }
    
    public static void shellSort(int[] a) {
        int h = 1 << (int)Math.floor(Math.log(a.length)/Math.log(2));
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length);
    }

    /**
     * Quicksort.
     *
     * @param a Array
     * @param start Start index, inclusive
     * @param end End index, exclusive
     */
    public static void quickSort(int[] a, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int sep = start;    // Seperate at 0
        for (int i = start; i < end - 1; i++) { // For each element...

            if (a[i] <= a[end - 1]) {
                swap(a, i, sep++);  // Swap ith element and element after separator, move separator forward
            }
        }
        swap(a, sep, end - 1);   // Move value to separator so right list pivot is different
        quickSort(a, start, sep);
        quickSort(a, sep, end);
    }

    public static void insertionSort(int[] a) {
        int itemToInsert;
        int j;
        boolean stillLooking;
        for (int i = 0; i < a.length - 1; ++i) {
            itemToInsert = a[i];
            stillLooking = true;
            j = i;
            while ((j >= 0) && stillLooking) {
                if (itemToInsert <= a[j]) {

                    a[j + 1] = a[j];
                    j--;
                } else {
                    stillLooking = false;
                }
            }
            a[j + 1] = itemToInsert;
        }
    }

    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int findMinimum(int[] a, int first) {
        int minIndex = first;
        for (int i = first; i < a.length; ++i) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
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
        for (int i = start; i < end; ++i) {
            s += a[i] + ", ";
        }
        if (end - start > 0) {
            s = s.substring(0, s.length() - 2);
        }
        s += "]";
        return s;
    }
}
