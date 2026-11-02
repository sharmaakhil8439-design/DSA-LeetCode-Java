class Solution {

    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        long a = power(5, even);
        long b = power(4, odd);

        return (int)((a * b) % MOD);
    }

    long power(long base, long exp) {

        long ans = 1;

        while (exp > 0) {

            if (exp % 2 == 1) {
                ans = (ans * base) % MOD;
                exp--;
            } else {
                base = (base * base) % MOD;
                exp = exp / 2;
            }
        }

        return ans;
    }
}