class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] m : matrix) {
            if (target >= m[0] && target <= m[m.length-1]) {
                int left = 0, right = m.length-1;
                while (left <= right) {
                    int mid = left + ((right-left)/2);
                    if (target == m[mid]) {
                        return true;
                    } else if (target < m[mid]) {
                        right = mid-1;
                    } else {
                        left = mid+1;
                    }
                }
            }
        }
        return false;
    }
}
