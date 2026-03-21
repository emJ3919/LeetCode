public class LC_283 {
    public void moveZero(int[] nums){
        int current_index = 0;
        for (int index = 0; index < nums.length; index += 1){
            if (nums[index] != 0){
                nums[current_index] = nums[index];
                current_index++;
            }
        }
        for (int index = current_index; index < nums.length; index += 1){
            nums[index] = 0;
        }
    }
}
