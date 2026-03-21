public class LC_240 {

    public boolean solution1(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solution2(int[][] matrix, int target){
        int n = matrix[0].length;
        for(int[] nums: matrix){
            int l = 0;
            int r = n - 1;
            int mid;
            while (l <= r){
                mid = (l + r) / 2;
                if(nums[mid] == target){
                    return true;
                }else if (nums[mid] <= target){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public boolean solution3(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int col = n - 1;
        int row = 0;
        while(row >= 0 && col >= 0 && col < n && row < m){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}
