class Solution {
    public boolean isPalindrome(String s) {
        String exp = "abcdefghijklmnopqrstuvwxyz1234567890";
        s = s.toLowerCase();
        int i = 0, j = s.length()-1;
        while(i<j){
            while(i<j && exp.indexOf(s.charAt(i))== -1) {
                i++;
            }
            while(i<j && exp.indexOf(s.charAt(j))== -1) {
                j--;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
