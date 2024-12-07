class Solution {
    public int countHomogenous(String s) {
        int low = 0;
        long ans = 0;
        int mod = 1000000007;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(low) != s.charAt(i)) {
                int n = i - low;
                ans = (ans + ((long)n * (n + 1) / 2) % mod) % mod;
                low = i;
            }
        }

        int n = s.length() - low;
        ans = (ans + ((long)n * (n + 1) / 2) % mod) % mod;

        return (int)ans;
    }
}