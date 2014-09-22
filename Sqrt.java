class Sqrt {
	public static void main(String[] args) {
		System.out.println(sqrt(5));
		System.out.println(sqrt(6));
		System.out.println(sqrt(7));
		System.out.println(sqrt(8));
		System.out.println(sqrt(9));
		System.out.println(sqrt(10));
		System.out.println(sqrt(2147483647));
	}
	//could be done by bit manipulation.
	public static int sqrt(int x) {
		//46340 is the sqrt of maximum integer
		int m = x;
		if (x > 46340) {
			m = 46340;
		}
		if (x < 0) {
			return -1;
		}
        return binarySearch(x, 0, m);
    }
    public static int binarySearch(int x, int i, int j) {
    	if (j < i) {
    		return j;
    	}
    	int square = ((i + j) / 2) * ((i + j) / 2);
    	if (square > x) {
    		return binarySearch(x, i, (i+j)/2-1);
    	}
    	else if (square == x) {
    		return (i + j) / 2;
    	}
    	else {
    		return binarySearch(x, (i+j)/2+1, j);
    	}
    }
}