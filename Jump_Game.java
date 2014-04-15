
public class Jump_Game {
    public boolean canJump(int[] A) {
    	int cur = 0;
    	while (cur >=0 && cur < A.length) {
    		if(cur == A.length-1)
    			break;
    		if (A[cur] == 0)
    			return false;
    		cur += A[cur];
    	}
    	return true;
    }
}
