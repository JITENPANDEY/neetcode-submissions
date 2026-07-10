class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length(), len2 = t.length();

        if (len1 < len2) return "";
        if (s.equals(t)) return s;

        // Frequency map of required characters
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE, start = 0;

        // counter = number of unique characters whose required frequency is satisfied
        int counter = 0;

        while (j < len1) {

            // Expand window by adding right character
            char rightChar = s.charAt(j);
            mapS.put(rightChar, mapS.getOrDefault(rightChar, 0) + 1);

            // Requirement for this character just got satisfied
            if (mapT.containsKey(rightChar)
                    && mapT.get(rightChar).equals(mapS.get(rightChar))) {
                counter++;
            }

            // Window is valid -> try to minimize it
            while (counter == mapT.size()) {

                // Update minimum window
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char leftChar = s.charAt(i);

                // Removing this character will break the requirement
                if (mapT.containsKey(leftChar)
                        && mapT.get(leftChar).equals(mapS.get(leftChar))) {
                    counter--;
                }

                // Shrink window from left
                mapS.put(leftChar, mapS.get(leftChar) - 1);
                i++;
            }

            j++;
        }
        return minLen == Integer.MAX_VALUE? "" : s.substring(start, start + minLen);
        
    }
}
