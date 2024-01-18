package PathProblems;
import java.util.*;
class comp implements Comparator < List < String >> {

    public int compare(List < String > a, List < String > b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++)
            x += a.get(i);
        for (int i = 0; i < b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}
public class Prog4_WordLadderIIOptimized {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        List<String> wordList = new ArrayList() {
            {
                add("des");
                add("der");
                add("dfr");
                add("dgt");
                add("dfs");
            }
        };

        Solution obj = new Solution();
        List < List < String >> ans = obj.findLadders(startWord, targetWord, wordList);

        // If no transformation sequence is possible.
        if (ans.isEmpty())
            System.out.println(-1);
        else {

            Collections.sort(ans, new comp());
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
class Solution {
    String b;
    HashMap < String, Integer > mpp;
    List < List < String >> ans;
    private void dfs(String word, List < String > seq) {
        if (word.equals(b)) {
            List < String > dup = new ArrayList < > (seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps = mpp.get(word);
        int sz = word.length();
        for (int i = 0; i < sz; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char[] replacedCharArray = word.toCharArray();
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);
                if (mpp.containsKey(replacedWord) && mpp.get(replacedWord) + 1 == steps) {
                    seq.add(replacedWord);
                    dfs(replacedWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List< String > wordList) {
        Set < String > st = new HashSet < String > ();
        int len = wordList.size();
        for (String s : wordList) {
            st.add(s);
        }
        Queue < String > q = new LinkedList < > ();
        b = beginWord;
        q.add(beginWord);
        mpp = new HashMap < > ();
        mpp.put(beginWord, 1);
        int sizee = beginWord.length();
        st.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek();
            int steps = mpp.get(word);
            q.remove();
            if (word.equals(endWord)) break;
            for (int i = 0; i < sizee; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord)) {
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        mpp.put(replacedWord, steps + 1);
                    }
                }
            }
        }
        ans = new ArrayList < > ();
        if (mpp.containsKey(endWord)) {
            List < String > seq = new ArrayList < > ();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }
}
