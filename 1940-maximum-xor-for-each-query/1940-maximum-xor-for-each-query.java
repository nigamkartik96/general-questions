class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;

        int[] prefix = new int[len]; 
        prefix[0] = nums[0];

        for (int i = 1; i < len; i ++) {
            prefix[i] = prefix[i - 1] ^ nums[i];
        }
        int ans[] = new int[len];
        int max = (int)Math.pow(2, maximumBit);
        for (int i = len - 1, j = 0; i >= 0; i--, j++) {
            ans[j] = (~prefix[i]) + max;
        }

        return ans;
    }
}