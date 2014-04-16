
public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
    	int count = 0;
    	boolean last = false;
        for(int i = s.length()-1; i >= 0; i--) {
        	if(last && s.charAt(i) == ' ') {
        		break;
        	}
        	else if(last && s.charAt(i) != ' ') {
        		count++;
        	}        	
        	else if(!last && s.charAt(i)!=' ') {
        		last = true;
        		count = 1;
        	}
        }

        return count;
    }
}
