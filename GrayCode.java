import java.util.ArrayList;

public class GrayCode {
	public List<Integer> graycode(int n) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(0);
		int i = 1;
		while (n-- != 0) {
			for (int k = ret.size()-1; k >= 0; k--) {
				ret.add(ret.get(k)+i);
			}
			i *= 2;
		}
		return ret;
	}
	//recent add 2015
	//no need to explain again the amazing of bit manipulation
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < (int)Math.pow(2,n); i++) {
            ret.add((i>>1)^i);
        }
        return ret;
    }

}