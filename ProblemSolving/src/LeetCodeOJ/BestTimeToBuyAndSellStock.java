package LeetCodeOJ;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int max = 0;
		int buy = prices[0];
		for (int price : prices) {
			if (price < buy) {
				buy = price;
			} else {
				if (max < price - buy)
					max = price - buy;
			}
		}
		return max;
	}
}
