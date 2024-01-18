package PathProblems;

import java.util.*;

public class Prog2_WordLadderI {
    public static void main(String[] args) {
        String begWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot"); wordList.add("dot"); wordList.add("dog"); wordList.add("lot"); wordList.add("log");
        wordList.add("cog");

        System.out.println("Shortest transformation sequence length : " + solve(begWord,endWord,wordList));
    }
    private static class Pair{
        String word;
        int seqLength;
        public Pair(String word, int seqLength){
            this.word = word;
            this.seqLength = seqLength;
        }
    }
    private static int solve(String begWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begWord,1));
        if(set.contains(begWord)){
            set.remove(begWord);
        }
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String word = p.word;
            int seqLength = p.seqLength;
            if(word.equals(endWord)){
                return seqLength;
            }
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char rep = sb.charAt(i);
                    sb.setCharAt(i,ch);
                    String trans = sb.toString();
                    if(set.contains(trans)){
                        set.remove(trans);
                        queue.add(new Pair(trans,seqLength+1));
                    }
                    sb.setCharAt(i,rep);
                }
            }
        }
        return 0;
    }
}
