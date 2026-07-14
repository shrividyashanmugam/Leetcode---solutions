class Solution {
    public double calpow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double half = calpow(x, n / 2);

        if (n % 2 == 1) {
            return half * half*x;
        } else {
            return half * half;
        }
    }

    public double myPow(double x, int n) {
        long N = n;  // promote to long
        if (N >= 0) {
            return calpow(x, N);
        } else {
            return 1.0 / calpow(x, -N);
        }
    }
}