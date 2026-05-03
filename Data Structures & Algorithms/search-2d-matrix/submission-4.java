class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Since the matrix is ordered,
        // we can binary search through the rows first,
        // to find the row where 'target' could be,
        // meaning row[0] <= target <= row[row.length-1],
        // we discard rows where 'target' > row[row.length-1]
        // or 'target' < row[0]
        int top = 0;
        int bottom = rows-1;
        while (top <= bottom) {
            int row = top + (bottom-top)/2;
            if (target > matrix[row][cols-1]) {
                top = row+1;
            } else if (target < matrix[row][0]) {
                bottom = row-1;
            } else {
                break;
            }
        }

        // Security check
        if (!(top <= bottom)) return false;

        // If we found a row where 'target' could be
        // we do a binary search through the columns
        // to search for 'target'

        // we need to compute the row again
        // because it was computed in the previous while
        int row = top + (bottom-top)/2;
        int left = 0;
        int right = cols-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target < matrix[row][mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        // This is O(log(m) + log(n))
        // which reduces to O(log(m*n))

        return false;
    }
}
