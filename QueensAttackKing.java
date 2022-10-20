import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensAttackKing {

	public static void main(final String[] args) {
		/*
		final int[][] queens = { { 0, 1 }, { 1, 0 }, { 4, 0 }, { 0, 4 }, { 3, 3 }, { 2, 4 } };
		final int[] king = { 0, 0 };
		*/
		/*
		final int[][] queens = { { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 4 }, { 3, 5 }, { 4, 4 }, { 4, 5 } };
		final int[] king = { 3, 3 };
		*/
		final int[][] queens = { { 5, 6 }, { 7, 7 }, { 2, 1 }, { 0, 7 }, { 1, 6 }, { 5, 1 }, { 3, 7 }, { 0, 3 }, { 4,
			0 }, { 1, 2 }, { 6, 3 }, { 5, 0 }, { 0, 4 }, { 2, 2 }, { 1, 1 }, { 6, 4 }, { 5, 4 }, { 0, 0 }, { 2, 6 }, {
			4, 5 }, { 5, 2 }, { 1, 4 }, { 7, 5 }, { 2, 3 }, { 0, 5 }, { 4, 2 }, { 1, 0 }, { 2, 7 }, { 0, 1 }, { 4, 6
		}, { 6, 1 }, { 0, 6 }, { 4, 3 }, { 1, 7 } };
		final int[] king = { 3, 4 };
		System.out.println(queensAttacktheKing(queens, king));
	}

	public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		final int kY = king[0], kX = king[1];
		final List<List<Integer>> answer = new ArrayList<>();

		final boolean[][] queenPresent = new boolean[8][8];
		for (int[] queen : queens) {
			final int qY = queen[0], qX = queen[1];
			queenPresent[qY][qX] = true;
		}

		for (int[] queen : queens) {
			final int qY = queen[0], qX = queen[1];
			final int dY = kY - qY, dX = kX - qX;

			boolean flag = false;

			if (dY == 0 || dX == 0 || Math.abs(dY) == Math.abs(dX)) {
				flag = true;
				int tempY = qY, tempX = qX;
				for (int i = 1; i < Math.max(Math.abs(dY), Math.abs(dX)); i++) {
					if (dY < 0)
						tempY--;
					else if (dY > 0)
						tempY++;

					if (dX < 0)
						tempX--;
					else if (dX > 0)
						tempX++;

					if (queenPresent[tempY][tempX]) {
						flag = false;
						break;
					}
				}
			}

			if (flag)
				answer.add(Arrays.asList(qY, qX));
		}

		return answer;
	}

}
