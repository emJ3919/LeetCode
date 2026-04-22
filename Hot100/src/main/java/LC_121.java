/**
 * 题目：买卖股票的最佳时机
 * 思路：贪心。
 * 遍历股票价格，维护历史最低价格。
 * 对于每一天，计算在最低价买入、今天卖出的收益，取最大收益。
 * 时间复杂度：O(n)，空间复杂度：O(1)。
 */
public class LC_121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0; // 只有一天或者没有数据收益为0
        // 记录历史最低价，初始化为第一天的价格
        int minPrice = prices[0];
        // 记录最大收益
        int ans = 0;
        for (int i = 1; i < len; i++){
            // 当天价格比历史最低价低，更新历史最低价，不用更新收益，因为收益为负数，不如不买
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }else {
                ans = Math.max(ans, prices[i] - minPrice);
            }
        }
        return ans;
    }
}
