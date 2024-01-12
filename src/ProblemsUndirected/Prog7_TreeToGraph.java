package ProblemsUndirected;

import java.util.*;

public class Prog7_TreeToGraph {
    public static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode level_1_1 = new TreeNode(5);
        TreeNode level_1_2 = new TreeNode(3);
        TreeNode level_2_1 = new TreeNode(4);
        TreeNode level_2_2 = new TreeNode(10);
        TreeNode level_2_3 = new TreeNode(6);
        TreeNode level_3_1 = new TreeNode(9);
        TreeNode level_3_2 = new TreeNode(2);

        root.left = level_1_1;
        root.right = level_1_2;

        level_1_1.left = null;
        level_1_1.right = level_2_1;

        level_1_2.left = level_2_2;
        level_1_2.right = level_2_3;

        level_2_1.left = level_3_1;
        level_2_1.right = level_3_2;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        convertToGraph(root,adj);
        System.out.println(adj.size());
        System.out.println();
        for(Map.Entry<Integer,List<Integer>> entry : adj.entrySet()){
            System.out.println(entry.getKey() + " -> "+ entry.getValue().toString());
        }
        System.out.println("Amount of time = " + amountOfTime(root,3));
    }
    public static int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        convertToGraph(root,adj);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(start);
        set.add(start);

        int time = -1;
        while(!queue.isEmpty()){
            time++;
            int size = queue.size();
            while(size > 0) {
                Integer p = queue.poll();
                if(adj.containsKey(p)) {
                    for (Integer i : adj.get(p)) {
                        if (!set.contains(i)) {
                            queue.add(i);
                            set.add(i);
                        }
                    }
                }
                size--;
            }
        }
        return time;
    }

    private static void convertToGraph(TreeNode root, Map<Integer, List<Integer>> adj) {
        if(root == null){
            return;
        }
        if(root.left != null){
            adj.computeIfAbsent(root.val,k-> new ArrayList<>()).add(root.left.val);
            adj.computeIfAbsent(root.left.val,k-> new ArrayList<>()).add(root.val);
        }
        if(root.right != null){
            adj.computeIfAbsent(root.val,k->new ArrayList<>()).add(root.right.val);
            adj.computeIfAbsent(root.right.val,k->new ArrayList<>()).add(root.val);
        }
        convertToGraph(root.left,adj);
        convertToGraph(root.right,adj);
    }
}
