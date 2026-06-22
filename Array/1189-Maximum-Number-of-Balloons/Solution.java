class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] frequencies = new int[5];
        int minimum = text.length();
        
        for(int i = 0; i < text.length(); i++){
            switch(text.charAt(i)){
                case 'b': frequencies[0]++;
                            break;
                case 'a': frequencies[1]++;
                            break;
                case 'l': frequencies[2]++;
                            break;
                case 'o': frequencies[3]++;
                            break;
                case 'n': frequencies[4]++;
            }
        }

        frequencies[2] >>= 1;
        frequencies[3] >>= 1;

        for(int frequency : frequencies){
            if(frequency < minimum) minimum = frequency;
        }

        return minimum;

    }
}
