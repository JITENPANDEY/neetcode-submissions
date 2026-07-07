class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        for(String s : strs) {
            int[] count = new int[26];
            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int cnt : count) {
                sb.append('#').append(cnt);
            }
            group.computeIfAbsent(sb.toString(), k -> new ArrayList<String>()).add(s);
        }

        return new ArrayList<>(group.values());
    }
}
