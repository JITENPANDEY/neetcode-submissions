class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        strs.forEach(s -> {
            sb.append(s.length()).append("#").append(s);
        });
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans  = new ArrayList<>();
        int lastPointer = 0;
        for(int i = 0;i<str.length();) {
            while(str.charAt(i) != '#'){
                i++;
            }
            int len = Integer.parseInt(str.substring(lastPointer, i));
            i++;
            StringBuilder sb = new StringBuilder();
            while(len>0){
                sb.append(str.charAt(i));
                i++;
                len--;
            }
            lastPointer = i;
            ans.add(sb.toString());
        }
        return ans;
    }
}
