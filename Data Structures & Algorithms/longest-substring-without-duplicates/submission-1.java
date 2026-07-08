class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;
        while(j<s.length()) {
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                ans = Math.max(ans, j-i+1);
                j++;
            }
        }
        return ans;
    }
}
