class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] voilator = new int[nums.length];

        for (int i =  1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                voilator[i] = voilator[i - 1] + 1;
            } else {
                voilator[i] = voilator[i - 1];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (voilator[queries[i][0]] == voilator[queries[i][1]])
                ans[i] = true;
        }
        return ans;
    }
}