package PathProblems;
import java.util.*;
public class Prog3_WordLadderII {
    public static void main(String[] args) {
        String begWord = "bat";
        String endWord = "coz";
        List<String> wordList = new ArrayList<>();
        wordList.add("pat"); wordList.add("bot"); wordList.add("pot"); wordList.add("poz"); wordList.add("coz");
        List<List<String>> ans = solve(begWord,endWord,wordList);
        for(List<String> i : ans){
            System.out.println(i);
        }
    }

    private static List<List<String>> solve(String begWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        ArrayList<String> l1 = new ArrayList<>();
        l1.add(begWord);
        queue.add(l1);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(begWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();

        while (!queue.isEmpty()){
            List<String> out = queue.poll();
            if(out.size() > level){
                level++;
                for(String s : usedOnLevel){
                    set.remove(s);
                }
                usedOnLevel.clear();
            }
            String word = out.get(out.size()-1);
            if(word.equals(endWord)){
                if(ans.isEmpty()){
                    ans.add(out);
                }else if(ans.get(0).size() == out.size()){
                    ans.add(out);
                }
            }
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char rep = word.charAt(i);
                    sb.setCharAt(i,ch);
                    String replacedWord = sb.toString();
                    if(set.contains(replacedWord)){
                        List<String> temp = new ArrayList<>(out);
                        temp.add(replacedWord);
                        queue.add(temp);
                        usedOnLevel.add(replacedWord);
                    }
                    sb.setCharAt(i,rep);
                }
            }
        }
        return ans;
    }
}
