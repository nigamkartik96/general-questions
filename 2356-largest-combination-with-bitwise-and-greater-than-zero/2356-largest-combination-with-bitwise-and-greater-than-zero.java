class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int candidate : candidates) {
            int pos = 1;
            while (candidate > 0) {
                if (candidate % 2 == 1) {
                    map.put(pos, map.getOrDefault(pos, 0) + 1);
                }
                candidate = candidate >> 1;
                pos++;
            }
        }

        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        return max;
    }
}