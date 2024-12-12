class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int gift : gifts) {
            pq.add(gift);
        }

        while (k-- > 0) {
            pq.add((int) Math.sqrt(pq.poll()));
        }
        long ans = 0;
        for (int num : pq) {
            ans += num;
        }

        return ans;
    }
}