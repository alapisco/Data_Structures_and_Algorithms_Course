package algorithmicToolBox.greedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FractionalKnapsack {

    // Helper class that contains the necessary data about the products
    public static class Product implements Comparable<Product> {

        int value;
        int weight;
        double unitPrice;

        @Override
        public int compareTo(Product o) {

            if (this.unitPrice > o.unitPrice) {
                return 1;
            } else if (this.unitPrice < o.unitPrice) {
                return -1;

            } else {
                return 0;
            }
        }

    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {

        double optimalValue = 0;

        // First we need to calculate the unit prices of all the products
        // and store their value and weight. For this we will use the Product helper class
        int size = values.length;
        Product[] products = new Product[size];

        for (int i = 0; i < size; i++) {
            double value = values[i];
            double weight = weights[i];
            double unitPrice = value / weight;

            Product p = new Product();

            p.value = values[i];
            p.weight = weights[i];
            p.unitPrice = unitPrice;
            products[i] = p;

        }

        // Sort the producs by unit price in descending order
        Arrays.sort(products, Collections.reverseOrder());

        // We will first try to consume the maximun weight possible of the product
        // with highest unit price, and we will continue to do with with the other  
        // products (from highest to lowest unit price) until our capacity is over
        for (Product product : products) {
            int weight = product.weight;
            int value = product.value;
            //We can consume all the weight of this product
            if (weight <= capacity) {
                capacity = capacity - weight;
                optimalValue = optimalValue + value;
                if (capacity == 0) {
                    break;
                }
                // We can only consume part of the weight of the product    
            } else {

                optimalValue = optimalValue + (capacity * product.unitPrice);
                break;

            }

        }

        // Round to 4 digits decimals
        double roundedValue = Math.round(optimalValue * 10000.0) / 10000.0;
        return roundedValue;
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
