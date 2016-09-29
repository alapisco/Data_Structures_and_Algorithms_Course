package algorithmicToolBox.greedyAlgorithms;


import java.util.*;

public class DifferentSummands {

    /*
    
    In general, our subproblem is the following: given integers k and l, where l ≤ k, represent k as a sum
    of as many pairwise distinct integers each of which is at least l as possible. 
    
    If k> 2l it is safe to use l as one of the summands
    
     */
    private static List<Integer> optimalSummands2(int n) {

        // Store the summands to be used 
        ArrayList<Integer> summands = new ArrayList<>();

        // this is the next number to represent
        int k = n;

        // counter for consecutive numbers
        int l = 0;

        
        int sum = 0;

        // While the sum of consecutive numbers is lesser than n
        while (sum < n) {
            l++;

            // It is safe to use l as the next summand
            if (k > 2 * l) {

                summands.add(l);
                k = k - l;
                sum += l;

                // use k as next summand    
            } else {

                summands.add(k);
                sum += k;

            }

        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands2(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
