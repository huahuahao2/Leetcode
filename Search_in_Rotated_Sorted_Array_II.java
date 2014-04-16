
public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] A, int target) {//has to be O(n)
        for(int i = 0; i<A.length;i++) {
            if(A[i] ==  target)
            return true;
        }
        return false;
    }

}
