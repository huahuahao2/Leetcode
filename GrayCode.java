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
}