class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int maxFrequency = 0;
        int maxLength = 0;
        int n = s.length();

        int right = 0, left = 0;

        while (right < n) {
            int i = s.charAt(right) - 'A';
            hash[i] ++;
            maxFrequency = Math.max(maxFrequency, hash[i]);

            while ((right - left + 1) - maxFrequency > k) {
                hash[s.charAt(left) - 'A']--;
                left ++;
                maxFrequency = 0;
                for (Integer val : hash) {
                    maxFrequency = Math.max(maxFrequency, val);
                }
            }
            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }
        return maxLength;
    }  
}