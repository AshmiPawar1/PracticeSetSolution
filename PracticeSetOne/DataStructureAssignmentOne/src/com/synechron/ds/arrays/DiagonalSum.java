package com.synechron.ds.arrays;

public class DiagonalSum {

	static void printDiagonalSums(int[][] mat, int n) {
		int principal = 0, secondary = 0;
		for (int i = 0; i < n; i++) {
			principal += mat[i][i];
			secondary += mat[i][n - i - 1];
		}

		System.out.println("Principal Diagonal:" + principal);

		System.out.println("Secondary Diagonal:" + secondary);
	}

	static public void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		printDiagonalSums(a, 4);
	}
}

//O(n) time complexity
