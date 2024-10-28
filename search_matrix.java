package dsatask2;
public class search_matrix {
    public static  boolean searchMatrix(int[][] matrix, int target) {
        boolean b = false;
        for (int i = 0; i < matrix.length; i++) {
            b = helper(matrix, i, 0, matrix[0].length - 1, target);
            if (b) {
                return true;
            }
        }
        return false;
    }

    public static boolean helper(int[][] matrix, int row, int si, int ei, int target) {
        if (ei - si < 0) {
            return false; // Handle case where the search range is invalid
        }
        if (si == ei) {
            return matrix[row][si] == target;
        }
        int mid = si + (ei - si) / 2;
        if (matrix[row][mid] == target) {
            return true;
        } else if (matrix[row][mid] < target) {
            return helper(matrix, row, mid + 1, ei, target);
        } else {
            return helper(matrix, row, si, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60},
            {60, 70, 80, 90}
        };
        int target1 = 3;
        boolean found1 = searchMatrix(matrix, target1);
        System.out.println("Target " + target1 + " found: " + found1);

        int target2 = 13;
        boolean found2 = searchMatrix(matrix, target2);
        System.out.println("Target " + target2 + " found: " + found2);
    }
}
