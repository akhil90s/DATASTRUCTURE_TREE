package Unique_Binary_Search_Trees;

public class Unique_Binary_Search_Trees {

	public static void main(String[] args) {

		int result_numTrees = numTrees(7);
		System.out.println(result_numTrees);

	}

	// Catalan Numbers
	public static int numTrees(int n) {

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {

			int l = 0;
			int r = i - 1;
			while (l <= i - 1) {
				dp[i] += dp[l] * dp[r];
				l++;
				r--;
			}
		}
		return dp[n];
	}

}
