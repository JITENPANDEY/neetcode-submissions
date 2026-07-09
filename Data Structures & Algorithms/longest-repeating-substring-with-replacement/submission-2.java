class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, maxFreq = 0, ans = 0;
        while(j<s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while((j-i+1) - maxFreq > k) { //invalid window - shrink
                map.put(s.charAt(i),  map.get(s.charAt(i))-1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
