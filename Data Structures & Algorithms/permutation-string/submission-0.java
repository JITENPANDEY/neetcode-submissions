class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        if(len1>len2) return false;

        int[] freqS1 = new int[26];
        for(char c : s1.toCharArray()){
            freqS1[c-'a']++;
        }

        int i=0, j = 0;
        int[] window = new int[26];
        while(j<len2){
            window[s2.charAt(j)-'a']++;

            while((j - i + 1) > len1){
                window[s2.charAt(i)-'a']--;
                i++;
            }
            if(Arrays.equals(freqS1, window)){
                return true;
            }
            j++;
        }
        return false;
    }
}
