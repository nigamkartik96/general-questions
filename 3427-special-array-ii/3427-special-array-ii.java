class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] voilator = new int[nums.length];
        Arrays.fill(voilator, 0);

        for (int i =  1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                voilator[i] = voilator[i - 1] + 1;
            } else {
                voilator[i] = voilator[i - 1];
            }
        }
        int i = 0;
        for (int[] query: queries) {
            ans[i++] = (voilator[query[0]] == voilator[query[1]]);
        }
        return ans;
    }
}