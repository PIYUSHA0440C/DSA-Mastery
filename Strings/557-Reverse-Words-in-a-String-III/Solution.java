class Solution {
    static void reverse(char[] charArray, int start, int end){
        while(start < end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int len = s.length();

        int start = 0;

        for(int end = 0; end <= len; end++){
            if(end == len || charArray[end] == ' '){
                reverse(charArray, start, end - 1);
                start = end + 1;
            }
        }
        return new String(charArray);





        // StringBuilder reverse = new StringBuilder();
        // String[] str = s.split(" ");
        // for(String word : str){
        //     StringBuilder tempStr = new StringBuilder(word).reverse();
        //     reverse.append(tempStr).append(" ");
        // }

        // reverse.deleteCharAt(reverse.length() - 1);

        // return reverse.toString();
    }

    
}
