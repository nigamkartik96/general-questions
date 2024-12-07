class Solution {
    int maxOperationsNeeded(int[] nums, int mid) {
        int ans = 0;

        for (int num : nums) {
            int operations = ((int)Math.ceil(num / (double)mid)) - 1;
            ans += operations;
        }

        return ans;
    }


    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int operations = maxOperationsNeeded(nums, mid);

            if (operations <= maxOperations) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}