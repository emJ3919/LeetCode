public class LC_121 {
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        // 只有一天或者没有数据收益为0
        if (len <= 1) return 0;
        // 表示第i天前的最低价
        int[] minPrice = new int[len];
        // 初始化第二天的，注意是第一天的价钱
        minPrice[1] = prices[0];
        // 从第三天开始计算
        for (int i = 2; i < len; i++){
            minPrice[i] = Math.min(minPrice[i - 1], prices[i - 1]);
        }
        // 计算最大收益：当天价格 - 第i天前的最低价。
        int ans = 0;
        // 从第二天开始算
        for (int i = 1; i < len; i++){
            ans = Math.max(ans, prices[i] - minPrice[i]);
        }
        return ans;
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
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
