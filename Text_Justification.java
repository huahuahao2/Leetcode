import java.util.List;
import java.util.LinkedList;

public class Text_Justification {
	
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new LinkedList<String>();
        int start = 0, i = 0, cur = 0;
        while (start < words.length) {
            for(i = start, cur = 0; i < words.length; i++) {
                cur += words[i].length();
                if (cur+i-start > L) {
                    cur -= words[i].length();
                    i--;
                    break;
                }
            }
            //
            int gap = 1, left = 0;
            if(i != start && i != words.length) {
                gap = (L-cur)/(i-start);
                left = (L-cur)%(i-start);
            }
            if (i == words.length) 
                i--;
            StringBuilder sb = new StringBuilder();
            for(int j = start; j < i; j++) {
                sb.append(words[j]);
                for(int k = 0; k < gap; k++) {
                    sb.append(" ");
                }
                if(left > 0) {
                    sb.append(" ");
                    left--;
                }
            }
            sb.append(words[i]);
            left = L-sb.length();
            while(left > 0) {
                sb.append(" ");
                left--;
            }
            ret.add(sb.toString());
            
            start = i+1;
        }
        return ret;
    }

}