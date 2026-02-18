class Solution {
    public int findComplement(int num) {
        int n=num;
        int mask=0;
        
        if(num==0){
            return 1;
        }
        while(n>0){
            mask = (mask<<1) | 1;
            n=n>>1;
        }
        return (~num) & mask;
    }
}
