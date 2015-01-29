public class Find_Minimum_in_Rotated_Sorted_Array {
	//even though time complexity is the same 
    public int findMin_I(int[] num) {
        int i = 0, j = num.length -1;
        while(i < j && num[i] > num[j]) {
            int mid = (i + j)/2;
            if (num[i] > num[mid]) {
                j = mid;
                continue;
            }
            if (num[mid] > num[j]) {
                i = mid+1;
                continue;
            }
        }
        return num[i];
    }
    public int findMin_II(int[] num){
        int i = 0, j = num.length -1;
        while(i < j && num[i] >= num[j]) {

            int mid = (i + j)/2;
            if (num[i] > num[mid]) {
                j = mid;
                continue;
            }
            if (num[mid] > num[j]) {
                i = mid+1;
                continue;
            }
            while(i < j && num[i+1] == num[i])
                i++;
            j--;
        }
        return num[i];
    }
}