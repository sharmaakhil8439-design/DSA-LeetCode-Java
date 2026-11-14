class Solution {
    public int countPrimeSetBits(int left, int right) {

        int ans = 0;

        for(int i = left; i <= right; i++) {

            int num = i;
            int count = 0;

            // Count set bits
            while(num != 0) {
                if((num & 1) == 1) {
                    count++;
                }
                num = num >> 1;
            }

            // Check prime
            if(isPrime(count)) {
                ans++;
            }
        }

        return ans;
    }

    boolean isPrime(int n) {

        if(n <= 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}