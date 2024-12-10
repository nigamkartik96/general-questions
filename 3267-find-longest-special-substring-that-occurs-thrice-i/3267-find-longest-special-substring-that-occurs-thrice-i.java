class Solution {
    boolean checkForValidString(int mid, String s) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // Generate a string of repeated characters of length `mid`.
            char[] chars = new char[mid];
            Arrays.fill(chars, ch);
            String text = new String(chars);

            // Count overlapping occurrences of `text` in `s`.
            int count = 0;
            for (int i = 0; i <= s.length() - mid; i++) {
                if (s.substring(i, i + mid).contains(text)) {
                    count++;
                    if (count >= 3) {
                        return true; // Found at least 3 occurrences.
                    }
                }
            }
        }
        return false;
    }

    public int maximumLength(String s) {
        int ans = -1;
        int low = 0;
        int high = s.length(); // The max length of the substring to check.

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (checkForValidString(mid, s)) {
                ans = mid;  // Update answer to the current valid `mid`.
                low = mid; // Search for a larger `mid`.
            } else {
                high = mid; // Search for a smaller `mid`.
            }
        }

        return ans;
    }
}