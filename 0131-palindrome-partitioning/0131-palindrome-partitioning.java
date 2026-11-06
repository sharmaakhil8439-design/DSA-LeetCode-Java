class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> current=new ArrayList<>();
        solve(0, s,ans,current);
        return ans;
        
    }
    void solve(int index, String s, List<List<String>> ans,List<String> current){
        if(index==s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<s.length();++i){
            if(isPalindrome(s,index,i)){
                current.add(s.substring(index, i+1));
                solve(i+1, s,ans,current);
                current.remove(current.size()-1);
            }
        }

    }

    boolean isPalindrome(String s,int start ,int end ){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }

        }
        return true;
    }
}