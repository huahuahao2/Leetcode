// bit manipulation
public class Single_Number_II {
    public int singleNumber(int[] A) {
    	int single=0;
    	for(int i:A) 
    		single^=i;
    	return single;
    }
}
