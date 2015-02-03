
public class Best_Time_to_Buy_and_Sell_Stock {
	public static void main(String[] args) {
		int[] num = {1,2,4};
		System.out.println(maxProfit3(num));
	}
    public int maxProfit(int[] prices) {
    	if (prices.length == 0)
    		return 0;
        int min = prices[0], profit = 0;
        for (int i : prices) {
        	if (i < min) {
        		min = i;
        	}
        	if (i-min > profit)
        		profit = i-min;
        }
        return profit;
    }
    public int maxProfit2(int[] prices) {
    	if (prices.length == 0)
    		return 0;
        int i = 0, j = 0, profit = 0;
        while (j!=prices.length-1) {
        	while(i <= prices.length-2 && prices[i] >= prices[i+1]) {
        		i++;
        	}
        	j = i;
        	while(j <= prices.length-2 && prices[j] <= prices[j+1]) {
        		j++;
        	}
        	profit += prices[j]-prices[i];
        	i = j+1;
        }
        return profit;
    }
    /*
     * 1. Try find 2 max in array. Wrong Answer.
     * 2. Separate the array to 2 parts, do max. TLE.
     * 3. change Strategy.*/
    public static int maxProfit(int[] prices, int start, int end) {
    	if (start >= end)
    		return 0;
        int min = prices[start], profit = 0;
        for (int i = start; i <= end ; i++) {
        	if (prices[i] < min) {
        		min = prices[i];
        	}
        	if (prices[i]-min > profit)
        		profit = prices[i]-min;
        }
        return profit;
    }
    public static int minProfit(int[] prices, int start, int end) {
    	if (start >= end)
    		return 0;
        int max = prices[start], profit = 0;
        for (int i = start; i <= end ; i++) {
        	if (prices[i] > max) {
        		max = prices[i];
        	}
        	if (max - prices[i] > profit)
        		profit = max - prices[i];
        }
        return profit;
    }
    
    public static int maxProfit3(int[] prices) {
        int min = 0, profit1 = 0;//min is array position
        int x = 0, y = 0;
        for (int i = 0; i < prices.length; i++) {
        	if (prices[i] < prices[min]) {
        		min = i;
        	}
        	if (prices[i]-prices[min] >= profit1) {
        		profit1 = prices[i]-prices[min];
        		y = i;
        		x = min;
        	}
        }
    	
        int profit_first = maxProfit(prices, 0, x-1);
        int profit_last = maxProfit(prices, y+1, prices.length-1);
        int profit_middle = minProfit(prices, x+1, y-1);
        int profit2 = profit_first > profit_last ? profit_first : profit_last;
        profit2 = profit2 > profit_middle ? profit2 : profit_middle;

    	return profit1 + profit2;
    }

    static int TRANSACTIONS = 2;
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        //I should be able to recognize that this is a DP problem.
        int ret = 0;
        int[][] opt = new int[TRANSACTIONS+1][prices.length];
        //base
        for(int i = 0; i < prices.length; i++) {
            opt[0][i] = 0;
        }
        for(int t = 0; t <= TRANSACTIONS; t++) {
            opt[t][0] = 0;
        }
        for(int t = 1; t <= TRANSACTIONS; t++) {
            int cur_money = opt[t-1][0]-prices[0];
            for(int i = 1; i < prices.length; i++) {
                cur_money = Math.max(opt[t-1][i]-prices[i], cur_money);
                opt[t][i] = Math.max(cur_money+prices[i], opt[t][i-1]);
                ret = Math.max(opt[t][i], ret);
            }
        }
        return ret;
        
    }

}
