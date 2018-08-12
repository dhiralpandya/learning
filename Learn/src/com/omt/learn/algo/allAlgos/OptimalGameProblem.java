package com.omt.learn.algo.allAlgos;

class Data {

	int left = 0;
	int right = 0;

	public static Data getData(int l, int r) {
		Data d = new Data();
		d.left = l;
		d.right = r;
		return d;
	}
}

public class OptimalGameProblem {

	public static void main(String[] args) {
		int a[] = { 3, 9, 1, 2 };
		System.out.println(getMaxForPlayerOne(a));
	}

	public static int getMaxForPlayerOne(int[] a) {

		Data[][] matrix = new Data[a.length][a.length];

		for (int l = 1; l <= a.length; l++) {

			for (int i = 0; i < a.length; i++) {

				int j = i + l - 1;
				if (j < a.length) {
					if (l == 1) {
						matrix[i][j] = Data.getData(a[i], 0);
					} else {

						int leftPick = a[i] + matrix[i + 1][j].right;
						int rightPick = a[j] + matrix[i][j - 1].right;

						if (leftPick > rightPick) {
							matrix[i][j] = Data.getData(leftPick, matrix[i + 1][j].left);
						} else {
							matrix[i][j] = Data.getData(rightPick, matrix[i][j - 1].left);
						}

					}
				}
			}

		}

		printMatrix(matrix);
		return matrix[0][a.length - 1].left;

	}

	public static void printMatrix(Data[][] matrix) {

		for (Data[] datas : matrix) {

			for (int i = 0; i < datas.length; i++) {
				Data d = datas[i];
				if (d == null) {
					System.out.print("(--,--) ");
				} else {

					System.out.print("(" + appendZero(d.left) + "," + appendZero(d.right) + ") ");
				}
			}
			System.out.println();

		}

	}

	public static String appendZero(int v) {
		return v < 10 ? "0" + v : v + "";
	}

}
