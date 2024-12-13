class Solution {
    static class Pair {
        public int val;
        public int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public int getVal() {
            return this.val;
        }
    }

    public long findScore(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingInt((Pair node) -> node.val)
                .thenComparingInt(node -> node.index)
        );

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }

        Set<Integer> set = new HashSet<>();
        long ans = 0L;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (!set.contains(pair.getIndex())) {
                set.add(pair.getIndex() - 1);
                set.add(pair.getIndex() + 1);
                set.add(pair.getIndex());
                ans += pair.getVal();
            }
        }

        return ans;
    }
}