class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        return countSteps(num, count);
    }

    int countSteps(int num, int count){
        if(num == 0) return count;

        if(num % 2 == 0) return countSteps(num / 2, ++count);
        else return countSteps(num - 1, ++count);
    }
}
