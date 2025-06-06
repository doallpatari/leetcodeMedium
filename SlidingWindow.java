import java.util.HashSet;
import java.util.Set;


public class SlidingWindow {
        public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0;i<k;i++)    
            sum += nums[i];

        int maxSum = sum;
        for(int i=k;i<nums.length;i++){
            sum = sum + nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum/k;
    }

        public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)return 0;
        Set<Character> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        int l = 0, r=0;
        while(r < s.length()){
            while(l<r && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }

    class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() ==0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE,startIndex =0;
        for (char c :t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        while (end < chS.length) {
            if (map[chS[end++]]-- >0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE? new String():
                new String(chS,startIndex,minLen);
    }
}
}