class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int nm[][] = new int[rows][cols];

        // Step 1: copy matrix into nm
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                nm[r][c] = matrix[r][c];
            }
        }

        // Step 2: apply zero logic
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {

                    // row zero
                    for (int i = 0; i < cols; i++) {
                        nm[r][i] = 0;
                    }

                    // column zero
                    for (int i = 0; i < rows; i++) {
                        nm[i][c] = 0;
                    }
                }
            }
           
   }
    for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = nm[r][c];
        }

       
    }
}
}

   