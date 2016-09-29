package algorithmicToolBox.greedyAlgorithms;

import java.util.*;

public class DotProduct {
    private static long minDotProduct(int[] a, int[] b) {
        
        // Sorting arrays in descending order
        Arrays.sort(a);
        Arrays.sort(b);
        
        // Sort a in ascending order
        int[] aCopy = Arrays.copyOf(a, a.length);
        
        for (int i = 0; i < a.length; i++) {
            a[i]= aCopy[a.length-1-i];
        }
        
        // min dot product result
        long result = 0;
        
        // multiply the minimum value of the a array  by the maximum value of the b array 
        for (int i = 0; i < a.length; i++) {
            result += (long)a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(minDotProduct(a, b));
    }
}
