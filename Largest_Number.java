public class Largest_Number {
    public String largestNumber(int[] num) {
        String[] num_s = new String[num.length];
        int j = 0;
        for (int i : num) {
            num_s[j++] = Integer.toString(i);
        }
        //bubble sort
        for (int i = 0; i < num.length; i++) {
            for (j = 0; j < num.length; j++) {
                if (compareNumber(num_s[i],num_s[j]) == 1) {
                    String temp = num_s[i];
                    num_s[i] = num_s[j];
                    num_s[j] = temp;
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for (String s : num_s ) {
            ret.append(s);
        }
        return ret.toString().charAt(0) == '0'? "0" : ret.toString();
    }
    public int compareNumber(String a, String b) {
        int i = 0;
        //rotate comparing
        while((i < b.length()||i<a.length()) && b.charAt(i%b.length())==a.charAt(i%a.length()))
            i++;
        if(a.charAt(i%a.length()) > b.charAt(i%b.length()))
            return 1;
        else if (a.charAt(i%a.length()) == b.charAt(i%b.length()))
            return 0;
        else
            return -1;
    }
}
