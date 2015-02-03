public class Decode_Ways {
	public int numDecodings(String s) {
        if (s == null || s.length() < 1)
            return 0;
        int[] opt = new int[s.length()+1];
        //base
        opt[0] = 1;
        opt[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) == '0') {
                if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2') {
                    opt[i] += opt[i-2];
                }
                else
                    opt[i] = 0;
            }
            else {
                opt[i] += opt[i-1];
                //aperantly i'm not paying attention to this.
                if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '6' && s.charAt(i-2) == '2') {
                    opt[i] += opt[i-2];
                }
                if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9' && s.charAt(i-2) == '1') {
                    opt[i] += opt[i-2];
                }
            }
        }
        return opt[s.length()];
    }
}