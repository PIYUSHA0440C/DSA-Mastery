class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");
        int pLen = pattern.length();
        int sLen = strArray.length;

        if(pLen != sLen) return false;

        Map<Character, String> map = new HashMap<>();

        for(int i = 0; i < pLen; i++){
            char ch = pattern.charAt(i);
            String str = strArray[i];

            if(!map.containsKey(ch)){
                if(map.containsValue(str)) return false;
                map.put(ch, str);

            } 
            else if(!map.get(ch).equals(str)) return false;
        }


        return true;
    }
}
