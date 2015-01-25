public class Find_Peak_Element {
	public int findPeakElement2(int[] num) {
		if (num.length == 0) {
			return -1;
		}
		if (num.length == 1|| num[0]>num[1]) {
			return 0;
		}
        for (int i = 1; i < num.length; i++) {
        	if (num[i-1] < num[i]) {
        		if (i+1 < num.length) {
        			if (num[i+1] < num[i]) {
        				return i;
        			}
        		}
        		else {
        			return i;
        		}
        	}
        }
        return -1;
    }
    public int findPeakElement(int[] num) {
        return findPeakElement(num, 0, num.length - 1);
    }
    public int findPeakElement(int[] num, int i, int j) {
        if (i == j)
            return i;
        int mid = (i+j)/2;
        if (mid != 0) {
            if (num[mid-1] > num[mid])
                return findPeakElement(num, i, mid-1);
        }
        if (mid != num.length - 1) {
            if (num[mid] < num[mid + 1])
                return findPeakElement(num, mid+1, j);
        }
        return mid;
    }
}