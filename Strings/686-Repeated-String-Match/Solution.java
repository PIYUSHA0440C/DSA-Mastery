class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        int bLen = b.length();
        
        StringBuilder sb = new StringBuilder("");
        
        while(sb.length() <= bLen){
            sb.append(a);
            count++;
            if(sb.indexOf(b) >= 0) return count;
        }
        
        sb.append(a);
        count++;
        if(sb.indexOf(b) >= 0) return count;

        return -1;
    }
}
