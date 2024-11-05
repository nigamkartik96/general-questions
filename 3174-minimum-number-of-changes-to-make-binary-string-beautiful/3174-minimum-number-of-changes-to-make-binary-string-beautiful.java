class Solution {
    public int minChanges(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1 ; i+=2) {
            if (chars[i] != chars[i + 1]) count++;
        }

        return count;
    }
}