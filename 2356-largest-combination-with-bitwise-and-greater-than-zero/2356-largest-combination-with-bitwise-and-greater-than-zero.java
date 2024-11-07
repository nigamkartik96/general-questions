class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0;
        int ans[] = new int[32];
        Arrays.fill(ans, 0);

        for (int candidate : candidates) {
            int pos = 1;
            while (candidate > 0) {
                if (candidate % 2 == 1) {
                    ans[pos]++;
                }
                candidate = candidate >> 1;
                pos++;
            }
        }

        for (int i = 0; i < 32; i++) {
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}