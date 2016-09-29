package algorithmicToolBox.introduction;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		int a =357;
		int b =234;

		System.out.println(new GreatestCommonDivisor().euclidianGDC(a, b));
		System.out.println(new GreatestCommonDivisor().naiveGDC(a, b));

	}

	int naiveGDC(int a, int b) {
		
		int best = 0;
		
		for (int i = 1; i <= (a+b); i++) {
			if (a % i == 0 && b % i == 0) {
				best = i;
			}
		}

		return best;
	}

	int euclidianGDC(int a, int b) {

		if (b == 0) {
			return a;
		}

		a = a % b;

		return euclidianGDC(b, a);
	}

}
