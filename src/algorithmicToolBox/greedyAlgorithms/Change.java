package algorithmicToolBox.greedyAlgorithms;


import java.util.Scanner;

public class Change {

    private static int getChange(int n) {

        //validate input restrictions
        if (n < 1 || n > 1000) {
            return 0;
        }

        //this variable will contain  the answer, the minimum number of coins needed
        int totalCoins = 0;

        //for this problem we need to arrange the denominations in descending order
        int[] denominations = {10, 5, 1};

        // In order to use the minimun number of coins, we will try to use
        // the max number of possible coins starting from the biggest denomination
        for (int denomination : denominations) {

            while (denomination <= n) {
                n = n - denomination;
                totalCoins++;
            }

        }

        return totalCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getChange(n));

    }
}
