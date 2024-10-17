class Solution {
    public int numberOfChild(int n, int k) { 
        int divide = k / (n - 1);
        int modulus = k % (n - 1);

        if (divide % 2 == 0) {
            return modulus;
        } else {
            return n - 1 - modulus;
        }
    }
}