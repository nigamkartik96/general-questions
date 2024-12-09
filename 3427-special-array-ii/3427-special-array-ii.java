class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int[] voilator = new int[nums.length];
        Arrays.fill(voilator, 0);

        for (int i =  1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                voilator[i] = voilator[i - 1] + 1;
            } else {
                voilator[i] = voilator[i - 1];
            }
        }

        for (int[] query: queries) {
            ans.add(voilator[query[0]] == voilator[query[1]]);
        }

        boolean[] array = new boolean[ans.size()];
        int i = 0;
        for (boolean an: ans) {
            array[i++] = an;
        }

        return array;
    }
}