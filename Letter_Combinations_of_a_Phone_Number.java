import java.util.Hashtable;
import java.util.ArrayList;
public class Letter_Combinations_of_a_Phone_Number {
	public static Hashtable<Character, String> a;
	public static ArrayList<String> ret;
	public static void main(String[] args) {
		//int[] num = {1,1,1,0};
		System.out.println(letterCombinations("").toString());
	}
    public static ArrayList<String> letterCombinations(String digits) {
    	ret = new ArrayList<String>();
    	StringBuffer cur = new StringBuffer("");
    	a = new Hashtable<Character, String>();
    	a.put('0', "");
    	a.put('2', "abc");
    	a.put('3', "def");
    	a.put('4', "ghi");
    	a.put('5', "jkl");
    	a.put('6', "mno");
    	a.put('7', "pqrs");
    	a.put('8', "tuv");
    	a.put('9', "wxyz");
    	a.put('*', "+");
    	a.put('0', " ");
    	a.put('#', "");
    	if (digits.length() == 0){
    		ret.add("");
    		return ret;
    	}
    	DFS(digits, 0, cur);
    	return ret;
    }
    public static void DFS(String digits, int i, StringBuffer cur) {
    	for (int j = 0; j < a.get(digits.charAt(i)).length(); j++) {
    		cur.append(a.get(digits.charAt(i)).charAt(j));
    		if(i == digits.length()-1) {
    			//cur.toString()
    			ret.add(cur.toString());
    		}
    		else
    			DFS(digits, i+1, cur);
    		cur.deleteCharAt(cur.length()-1);
    		
    	}
    }
}
