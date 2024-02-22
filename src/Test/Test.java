package Test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = {
                1,4,4,1,3,5,5,3
        };
        int[] pattern = {1,0,-1};
        int answer = solve(nums,pattern);
        System.out.println(answer);
    }

    private static int solve(int[]nums,int[]pattern) {
       int window = pattern.length+1;
       int count = 0;
       for(int i = 0; i < nums.length- pattern.length; i++){
           boolean isMatch = true;
           for(int k = 0; k < pattern.length; k++){
               if(pattern[k] == 1 && nums[i + k + 1] > nums[i + k]){
                   continue;
               }else if(pattern[k] == 0 && nums[i + k + 1] == nums[i + k]){
                   continue;
               }else if(pattern[k] == -1 && nums[i + k + 1] < nums[i + k]){
                   continue;
               }else{
                   isMatch = false;
                   break;
               }
           }
           if(isMatch) count++;
       }
        return count;
    }
}
