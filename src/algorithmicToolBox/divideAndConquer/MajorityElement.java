package algorithmicToolBox.divideAndConquer;

import java.util.*;
import java.io.*;

public class MajorityElement {
	private static int getMajorityElement(int[] a, int left, int right) {
		if (left == right) {
			return -1;
		}
		if (left + 1 == right) {
			return a[left];
		}
		// write your code here

		int mid = (right - left) / 2;

		int majLeft = getMajorityElement(a, left, left + mid);

		int majRight = getMajorityElement(a, left + mid, right);

		if (majLeft == -1 && majRight == -1) {
			return -1;
		} else if (majLeft == -1 && majRight != -1) {
			int count = 0;
			for (int i = left; i < right; i++) {
				if (a[i] == majRight) {
					count++;
				}
				if (count > ((right-left) / 2)) {
					return majRight;
				}
			}

		} else if (majRight == -1 && majLeft != -1) {
			int count = 0;
			for (int i = left; i < right; i++) {
				if (a[i] == majLeft) {
					count++;
				}
				if (count > ((right-left) / 2)) {
					return majLeft;
				}
			}

		} else {

			int countLeft = 0;
			int countRight = 0;
			for (int i = left; i < right; i++) {
				if (a[i] == majLeft) {
					countLeft++;
				}

				if (a[i] == majRight) {
					countRight++;
				}
				if (countLeft > ((right-left) / 2)) {
					return majLeft;
				}

				if (countRight > ((right-left) / 2)) {
					return majRight;
				}
			}

		}

		return -1;

	}

	public static void main(String[] args) {

		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		if (getMajorityElement(a, 0, a.length) != -1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
