
public class TwoPointers {
        public int[] twoSumII(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<r){
            int sum =  nums[l] + nums[r];
            if(sum == target) return new int[]{l+1, r+1};
            else if(sum > target)r--;
            else l++;
        }
        return new int[]{-1, -1};
    }

    public int containerWithMostWater(int[] height) {
        int l=0, r=height.length-1;
        int max = Integer.MIN_VALUE;
        while(l<r){
            max = Math.max(max, Math.min(height[l], height[r])*(r-l));
            if(height[l]<=height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}