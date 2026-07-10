class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length(), len2 = t.length();

        if(len1<len2) return "";
        if(s.equals(t)) return s;
        
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for(char c : t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c, 0) +1);
        }

        int i=0,j=0, minLen = Integer.MAX_VALUE, start = 0, counter = 0;
        while(j<len1){
            char rightChar = s.charAt(j);
            mapS.put(rightChar, mapS.getOrDefault(rightChar, 0) + 1); 

            if(mapT.containsKey(rightChar) && mapT.get(rightChar) == mapS.get(rightChar)) { 
                counter++;
            }

            while(counter == mapT.size()) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }
                char leftChar = s.charAt(i);
                if(mapT.containsKey(leftChar) && mapT.get(leftChar) == mapS.get(leftChar)){
                    counter--;
                }
                mapS.put(leftChar, mapS.getOrDefault(leftChar, 0) - 1); 
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE? "" : s.substring(start, start + minLen);
        
    }
}
