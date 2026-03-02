class Solution {
    public List<String> letterCombinations(String digits) {
        return pad("", digits);
    }

    List<String> pad(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();

        // Logic for 7, 8, and 9 to handle the non-uniform mapping (pqrs, tuv, wxyz)
        int start = (digit - 2) * 3;
        if (digit > 7) start++;
        
        int end = start + 3;
        if (digit == 7 || digit == 9) end++;

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            list.addAll(pad(p + ch, up.substring(1)));
        }
        return list;
    }
}
