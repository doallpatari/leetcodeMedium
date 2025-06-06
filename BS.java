
public class BS {
        public boolean searchMatrix(int[][] matrix, int target) {
        int ro = 0, col = matrix[0].length-1;

        while(ro < matrix.length && col >=0){
            int num = matrix[ro][col];
            if(num == target)return true;
            else if (num > target) col--;
            else ro++;
        }
        return false;
    }
}