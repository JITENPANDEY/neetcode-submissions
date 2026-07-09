class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, maxFreq = 0, ans = 0;
        while(j<s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            int charFreq = map.get(s.charAt(j));
            maxFreq = Math.max(maxFreq, charFreq);

            int totalReplacement = (j-i+1) - maxFreq;

            if(totalReplacement <= k) { //valid window
                ans = Math.max(ans,(j-i+1));
                j++;
            }
            else { // invalid window - shrink
                if(map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i),  map.get(s.charAt(i))-1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
