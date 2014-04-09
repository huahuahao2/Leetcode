/*convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*/
public class ZigZag_Conversion {
	public static void main(String[] args) {
		System.out.println(convert2("PAYPALISHIRING", 3));
	}

	public static String convert(String s, int nRows) {/*more straight forward, but O(n2)*/
		StringBuffer sc[] = new StringBuffer[nRows];
		StringBuffer scvt = new StringBuffer();
		if (nRows == 1)
			return s;
		for (int j = 0; j < nRows; j++) {
			for (int i = 0; i < s.length(); i++) {
				if (i%(nRows*2-2) == j || i%(nRows*2-2) == nRows*2-2-j)
					scvt.append(s.charAt(i));
			}
		}
		return scvt.toString();
	}
	public static String convert2(String s, int nRows) {/*O(n)*/
		StringBuffer sc[] = new StringBuffer[nRows];
		StringBuffer scvt = new StringBuffer();
		for (int i = 0; i < nRows; i++)
			sc[i] = new StringBuffer();
		if (nRows == 1)
			return s;
		for (int i = 0; i < s.length(); i++) {
			int j = i % (nRows * 2 - 2) > nRows * 2 - 2 - i % (nRows * 2 - 2) ? nRows
					* 2 - 2 - i % (nRows * 2 - 2)
					: i % (nRows * 2 - 2);
			sc[j].append(s.charAt(i));
		}
		for (int i = 0; i < nRows; i++)
			scvt.append(sc[i].toString());
		return scvt.toString();
	}
}
