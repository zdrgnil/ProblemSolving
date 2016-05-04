import java.util.Collections;
import java.util.PriorityQueue;

public class MainArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 8, 4, 7 }, { 6, 5, 9 } };
		Sorting a = new Sorting();
		a.testObjectSort();
	}

	public static void print2DArray(Integer matrix[][]) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c] + ",");
			}
			System.out.println();
		}
	}

	public static void printIntArray(int nums[]) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ", ");
	}
}
