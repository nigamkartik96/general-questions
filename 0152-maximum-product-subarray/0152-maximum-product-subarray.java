class Solution {
    public int maxProduct(int[] nums) {
        int currMin = 1;
        int currMax = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currMin = 1;
                currMax = 1;
                ans = Math.max(ans, 0);
                continue;
            }

            int temp = currMax * nums[i];
            currMax = Math.max(nums[i], Math.max(currMin * nums[i], temp));
            currMin = Math.min(nums[i], Math.min(currMin * nums[i], temp));

            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}