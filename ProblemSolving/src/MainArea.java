import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import LeetCodeOJ.CopyListWithRandomPointer;
import LeetCodeOJ.GetIntersectionNode;
import LeetCodeOJ.LengthOfLongestSubstring;
import LeetCodeOJ.LetterCombinationsOfPhoneNumber;
import LeetCodeOJ.LongestPalindromic;
import LeetCodeOJ.MinStack;
import LeetCodeOJ.SerializeAndDeserializeBT;
import LeetCodeOJ.TwoSum;
import LeetCodeOJ.ValidAnagram;
import LeetCodeOJ.ValidParentheses;
import LeetCodeOJ.WordBreak;
import OOD.Card;

public class MainArea {

	public static void main(String[] args) {
		Card ace = new Card(0, Card.Suit.SPADE);
		Card king = new Card(13, Card.Suit.SPADE);
		if (ace.compareTo(king) < 0)
			System.out.println("ace bigger");

	}

	public static void reverseWords(char[] s) {
		int c = 0;
		char r[] = new char[s.length];
		for (int i = s.length - 1; i >= -1; i--) {
			if (i == -1 || s[i] == ' ') {
				for (int j = i + 1; j < s.length; j++) {
					r[c] = s[j];
					c++;
					if (s[j] == ' ')
						break;
				}
			}
		}
		for (int i = 0; i < s.length; i++)
			s[i] = r[i];
	}

	public static void reverseWords2(char[] s) {
		if (s.length <= 1)
			return;
		String str = String.copyValueOf(s);
		String[] words = str.split(" ");
		String result = "";
		for (int i = words.length - 1; i >= 0; i--)
			result += " " + words[i];
		result = result.trim();
		char[] c = result.toCharArray();
		for (int i = 0; i < c.length; i++) {
			s[i] = c[i];
		}
	}

	public static int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				count++;
				for (int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}
		return count;
	}

	public static String sortStr(String str) {
		char[] cs = str.toCharArray();
		Arrays.sort(cs);
		return String.copyValueOf(cs);
	}

	public static void findOptimalWeights(double capacity, double[] weights) {
		Arrays.sort(weights);
		int a = 0;
		int b = weights.length - 1;
		int A = 0;
		int B = weights.length - 1;
		double bestSum = Integer.MIN_VALUE;
		while (a < b) {
			double sum = weights[a] + weights[b];
			if (sum <= capacity && sum > bestSum) {
				A = a;
				B = b;
				bestSum = sum;
			}
			if (sum < capacity)
				a++;
			else
				b--;
		}
		System.out.println(A + "," + B);
	}

	public static int gcd(int a, int b) {
		while (a != b) {
			if (a > b)
				a -= b;
			else
				b -= a;
		}
		return a;
	}

	public static Boolean isReachable(int[][] maze) {
		Boolean[] isfound = new Boolean[1];
		isfound[0] = false;
		isReacheable(maze, 0, 0, isfound);
		return isfound[0];
	}

	public static void isReacheable(int[][] maze, int x, int y, Boolean[] isfound) {
		if (x < 0 || y < 0 || x >= maze[0].length || y >= maze.length || maze[x][y] == 1 || maze[x][y] == -1
				|| isfound[0])
			return;
		if (maze[x][y] == 0) {
			maze[x][y] = -1;
			isReacheable(maze, x + 1, y, isfound);
			isReacheable(maze, x - 1, y, isfound);
			isReacheable(maze, x, y + 1, isfound);
			isReacheable(maze, x, y - 1, isfound);
			return;
		}
		if (maze[x][y] == 9) {
			isfound[0] = true;
			return;
		}
	}

	public static void printA(ArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public static void print2DArray(int[][] m) {
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[0].length; c++) {
				System.out.print(m[r][c] + ",");
			}
			System.out.println();
		}
	}

	public static void printIntArray(int nums[]) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ", ");
	}
}
