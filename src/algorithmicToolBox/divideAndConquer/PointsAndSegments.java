package algorithmicToolBox.divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        
        int[][]segments = new int[starts.length][starts.length];
        
        for (int i = 0; i < segments.length; i++) {
			segments[i] = new int[]{starts[i], ends[i]};
		}
               
        
        
        int[][] sortedSegments = mergeSort(segments);

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
			if(points[i]<min){
				min = points[i];
			}
			
			if(points[i]>max){
				max = points[i];
			}
		}

        
        
        int l =0;
        int r=-1;
        for (int i = 0; i < sortedSegments.length; i++) {
			if(sortedSegments[i][1]<min){l++;}
			if(sortedSegments[i][0]<max){r++;}
			
		}
        
        /*
        for (int[] is : sortedSegments) {
			System.out.println(Arrays.toString(is));
		}
        
        for (int i = l; i <= r; i++) {
        	System.out.println(" -"+Arrays.toString(sortedSegments[i]));
		}
		*/
        
        for (int i = 0; i < points.length; i++) {
        	int point = points[i];
        	//System.out.println("for " + point);
        	int count=0;
			for (int j = l; j <= r; j++) {
				if(sortedSegments[j][0]>point){
					continue;
				}
				//System.out.println("check " + Arrays.toString(sortedSegments[j]));
				if(sortedSegments[j][1]>=point){
					
					count++;
				}
			}
			
			cnt[i]=count;
        	
		}
        
     //System.out.println(Arrays.toString(points));
     //System.out.println(Arrays.toString(cnt));
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }
    
    static int[][] mergeSort(int[][] array) {

		if (array.length == 1) {
			return array;
		}

		int mid = array.length / 2;


		int[][] left = new int[mid][mid];
		int[][] right = new int[array.length - mid][array.length - mid];
		
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		
		for (int i = mid; i < array.length; i++) {
			right[i-mid] = array[i];
		}
		

		int[][] A = mergeSort(left);
		int[][] B = mergeSort(right);

		return merge(A, B);
	}

	static int[][] merge(int[][] A, int[][] B) {
		

		ArrayList<Integer[]> merged = new ArrayList<Integer[]>();

		ArrayList<Integer[]> Alist = new ArrayList<Integer[]>();
		ArrayList<Integer[]> Blist = new ArrayList<Integer[]>();

		for (int i = 0; i < A.length; i++) {
			Alist.add(new Integer[]{A[i][0], A[i][1]});
		}

		for (int i = 0; i < B.length; i++) {
			Blist.add(new Integer[]{B[i][0], B[i][1]});
		}

		while (!Alist.isEmpty() && !Blist.isEmpty()) {
			Integer[] a = Alist.get(0);
			Integer[] b = Blist.get(0);
						

			if (a[0] <= b[0]) {
				merged.add(a);
				Alist.remove(0);
			} else {
				merged.add(b);
				Blist.remove(0);
			}
		}

		for (Integer[] i : Alist) {
			merged.add(i);
		}

		for (Integer i[] : Blist) {
			merged.add(i);
		}

		int[][] result = new int[merged.size()][2];
		
		for (int i = 0; i < merged.size(); i++) {
			result[i] = new int[]{merged.get(i)[0],merged.get(i)[1]};
		}

		
		
		
		//System.out.println(Arrays.toString(result));
		return result;
	}

    

    public static void main(String[] args) {
    	//int[] s = new int[]{2,6,9,4,11,32};
    	//int[] e = new int[]{10,9,13,6,24,100};
    	//fastCountSegments(s,e,new int[]{6,7,8,12});
    	//System.exit(0);
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

