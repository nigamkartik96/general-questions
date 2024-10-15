class Solution {
    public long minimumSteps(String s) {
        int length = s.length();
        int black = length - 1;
        int white = 0;
        long swaps = 0;

        while (black >= white) {
            char blackChar = s.charAt(black);
            char whiteChar = s.charAt(white);

            if (blackChar == whiteChar) {
                if (whiteChar == '1') {
                    black--;
                } else {
                    white++;
                }
            } else {
                if (whiteChar == '1') {
                    swaps += black - white;
                }
                black--;
                white++;
            }
        }

        return swaps;
    }
}