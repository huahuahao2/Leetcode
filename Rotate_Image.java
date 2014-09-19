import java.util.Arrays;
class Rotate_Image {
	public static void main(String[] args) {
		int matrix[][] = new int[7][7];
		int num = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = num++;
			}
		}
		for(int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        //System.out.println(Arrays.toString(matrix));
        rotate(matrix);
        for(int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        //System.out.println(matrix);

	}
    public static void rotate(int[][] matrix) {
        //int[] temp = new int[matrix.length-1];
        for (int m = 0; m < matrix.length/2; m++) {
        	//int cursor = matrix.length - m*2 - 1;
	        for (int i = m; i < matrix.length - m - 1; i++) {
	        	int temp = matrix[m][i];
	        	matrix[m][i] = matrix[matrix.length - 1 -i][m];
	        	matrix[matrix.length - 1 -i][m] = matrix[matrix.length - 1 - m][matrix.length - 1 - i];
	        	matrix[matrix.length - 1 - m][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - m];
	        	matrix[i][matrix.length - 1 - m] = temp;
	        }
        }
    }
}