public class LC_48 {
    public void rotate(int[][] matrix){
        int left = 0;
        int right = matrix.length - 1;
        while(left < right){
            for (int i = 0; i < right - left; i++){
                int tmp = matrix[left][left + i];
                //左边从下到上补上边。
                matrix[left][left + i] = matrix[right - i][left];
                //下边从右到左补左边。
                matrix[right - i][left] = matrix[right][right - i];
                //右边从上到下补下边。
                matrix[right][right - i] = matrix[left + i][right];
                //最后上边补右边。
                matrix[left + i][right] = tmp;
            }
            left++;
            right--;
        }
    }
}
