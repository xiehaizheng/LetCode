package Array;
/*
* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
* 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
* 注意：你不能在买入股票前卖出股票。
* */
public class BestTimeForTradeStocks121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};
        int res = maxProfit2(prices);
        System.out.println(res);
    }
    // 暴力做法，算法复杂度O（n^2）
    public static int maxProfit(int[] prices){
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < len ; i++) {
            for (int j = i + 1; j < len; j++){
                maxProfit = Math.max(maxProfit,prices[j]-prices[i]);
            }
        }
        return maxProfit;
    }
    //一次遍历,时间复杂度O（n）
    public static int maxProfit2(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit2 = 0;
        for (int i = 0; i < prices.length ; i++) {
            if (minPrice > prices[i]){
                minPrice = prices[i];
            }else if(prices[i] - minPrice >maxProfit2){
                maxProfit2 = prices[i] - minPrice;
            }
        }
        return maxProfit2;
    }
}
