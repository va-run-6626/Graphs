package ProblemsDirected.TopologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prog7_AlienDictonary {
    public static void main(String[] args) {
        String[] dict = {
                "ahhfiblcafelghehcadcilfkec",
                "dd",
                "dhclbbdliceedgflflkdlec",
                "dk",
                "ebkfklagilhliljac",
                "eblfhgecdchkkihicghakahkdg",
                "ecjdiibjfcblgl",
                "fdkbfkgahkeajdccjhgfabhdjde",
                "fglcbejiijfdcdadaeegagflcgfkhhhafaeeghebfhcgbj",
                "fldjdclh",
                "gbfbcafddiieicchlbhlbklcgejl",
                "gg",
                "ggjdlieiklffbkhhlcglfcghidehhaheihfflehi",
                "hbichfhgfkigaackjhbdegjackadhkikcdbchgkdgkbgfd",
                "hhgbeekcgcbccfdhfkkgalidfedchldhjgjeehcg",
                "ialbi",
                "iclgjigddh",
                "jdbfjjhflaigghgkfheaiad",
                "jlafh",
                "jlge",
                "kcgdgegijggejjajfajal",
                "lfadijikilhfadegj",
                "lkh"
        };
        int k = 12;
        System.out.println("The Ordering is : "+ solve(dict,dict.length,k));
    }
    private static String solve(String[] dict, int N, int K){
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(adj);
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            ans.append((char)(it + (int)('a')));
        }

        return ans.toString();
    }

    private static List<Integer> topoSort(List<List<Integer>> adj) {
        int V = adj.size();
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }
}
