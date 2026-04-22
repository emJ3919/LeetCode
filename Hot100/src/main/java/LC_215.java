import com.sun.security.auth.UnixNumericGroupPrincipal;

/**
 * 题目：数组中的第K个最大元素
 * 思路：
 * 方法1：小根堆。维护一个大小为k的小根堆，堆顶是堆中最小的。
 * 遍历数组将元素加入堆中，若堆大小超过k则弹出堆顶，保证堆中始终是前k大的元素，堆顶即为第k大的元素。
 * 时间复杂度：O(n log k)，空间复杂度：O(k)。
 * 方法2：快速选择。基于快速排序的划分思想，将第k大的数转化为排序后数组中第n-k位置上的数。
 * 选取基准将数组划分为两部分，根据目标位置与划分点的关系递归处理。
 * 平均时间复杂度：O(n)，最坏O(n²)，空间复杂度：O(log n)。
 */
public class LC_215 {
        // 小根堆
    public int findKthLargest(int[] nums, int k){
        // 建大小为k的小顶堆
        for (int i = k/2 - 1; i >= 0; i--){
            modify(nums, k, i);
        }
        // 遍历剩下n-k个数，判断是否入堆，使堆里面是前k大的数，那么堆顶就是第k大的
        for (int i = k; i < nums.length; i++){
            // 入堆
            if (nums[i] > nums[0]){
                // 将堆顶弹出放在i这里（在堆外面），nums[i]放到堆顶调整
                int tmp = nums[0];
                nums[0] = nums[i];
                nums[i] = tmp;
                // 继续调整换下去的节点
                modify(nums, k, 0);
            }
        }
        return nums[0];
    }
    // 调整堆
    private void  modify(int[] nums, int size, int i){
        // 找到左右节点
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int min = i;
        // 找出最小的节点
        if (l < size && nums[l] < nums[min]){
            min = l;
        }
        if (r < size && nums[r] < nums[min]){
            min = r;
        }
        // 需要调整
        if (min != i){
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
            // 继续调整换下去的节点
            modify(nums, size, min);
        }
    }

    public int findKthLargest1(int[] nums, int k) {
        // 将第k大的数转化为排序后target位置的数，target就等于nums.length - k
        return targetSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    // 返回基准分割后的区间起点或终点
    public int targetSelect(int[] nums, int l, int r, int target){
        if (l == r) return nums[l];
        // 只选择了基准，并没有放在正确的位置，选择左边需要用j指针递归，防止死循环
        int pivot = nums[l];
        int i = l;
        int j = r;
        // 分割为[l, j]:小于等于基准  [j + 1, r]:大于基准
        // 或者[l,i - 1]:小于基准 [i, r]:大于等于基准
        while (i <= j){
            // 两个while比较i，j
            // 左指针前进到>=基准
            while (nums[i] < pivot) i++;
            // 右指针退到<=基准
            while (nums[j] > pivot) j--;
            // 如果还没有相遇,就交换
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
            // 如果nums[i]=nums[j]=pivot的情况下需要手动退出，因为这个时候没有进行加减操作，会死循环
            else if (i == j) break;
        }
        // 目标位置在右边区间
        if (target <= j) return targetSelect(nums, l, j, target);
        else return targetSelect(nums, j + 1, r, target);
    }

}
