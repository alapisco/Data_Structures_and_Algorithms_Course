package algorithmicToolBox.divideAndConquer;

import java.util.*;

public class Inversions {

	static long inversions = 0;

	private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {

		mergeSort(a);

		return inversions;
	}

	static int[] mergeSort(int[] array) {

		if (array.length == 1) {
			return array;
		}

		int mid = array.length / 2;

		int[] leftArray = new int[mid];
		int[] rightArray = new int[array.length - mid];

		System.arraycopy(array, 0, leftArray, 0, leftArray.length);
		System.arraycopy(array, mid, rightArray, 0, rightArray.length);

		int[] A = mergeSort(leftArray);
		int[] B = mergeSort(rightArray);

		return merge(A, B);

	}

	static int[] merge(int[] A, int[] B) {
		

		ArrayList<Integer> merged = new ArrayList<Integer>();

		ArrayList<Integer> Alist = new ArrayList<Integer>();
		ArrayList<Integer> Blist = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			Alist.add(A[i]);
		}

		for (int i = 0; i < B.length; i++) {
			Blist.add(B[i]);
		}

		while (!Alist.isEmpty() && !Blist.isEmpty()) {
			int a = Alist.get(0);
			int b = Blist.get(0);
						

			if (a <= b) {
				merged.add(a);
				Alist.remove(0);
			} else {
				merged.add(b);
				inversions+=Alist.size();
				Blist.remove(0);
			}
		}

		for (Integer i : Alist) {
			merged.add(i);
		}

		for (Integer i : Blist) {
			merged.add(i);
		}

		int[] result = new int[merged.size()];
		for (int i = 0; i < merged.size(); i++) {
			result[i] = merged.get(i);
		}

		
		
		
		//System.out.println(Arrays.toString(result));
		return result;
	}

	public static void main(String[] args) {
		
		//System.out.println(Arrays.toString(mergeSort(new int[]{9 ,8 ,7 ,3, 2 ,1})));
		//System.out.println(Arrays.toString(mergeSort(new int[]{1,2,3,4,2})));
		

		//System.out.println(inversions);
		//System.exit(0);
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		System.out.println(getNumberOfInversions(a, b, 0, a.length));
	}
}
