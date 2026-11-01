class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        solve(n,0,0,"");
        return ans;
    }
   void solve(int n, int open, int close, String current) {
    if (open == n && close == n) {
        ans.add(current);
        return;
    }
    if (open < n) {
        solve(n, open + 1, close, current + "(");
    }
    if (close < open) {
        solve(n, open, close + 1, current + ")");
    }
}
}