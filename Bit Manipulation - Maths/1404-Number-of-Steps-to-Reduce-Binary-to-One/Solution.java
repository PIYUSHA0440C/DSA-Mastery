class Solution {
    public int numSteps(String s) {
        int count = 0, carry = 0;
        for(int i = s.length() - 1; i > 0; i--){
            if((s.charAt(i) - '0') + carry == 1){
                count += 2;
                carry = 1;
            } else {
                count += 1;
            }
        }

        return count + carry;
    }
}

// class Solution {
//     public int numSteps(String s) {
//         int num = number(s);
//         int count = 0;
//         while(num > 1){
//             if(num % 2 == 0){
//                 num /= 2;
//             } else{
//                 num += 1;
//             }
//             count++;
//         }

//         return count;
//     }
//     int number(String str){
//         int num = 0;
//         int bitValue = 1;
//         for(int i = str.length() - 1; i >= 0; i--){
//             if(str.charAt(i) == '1'){
//                 num += bitValue;
//             }
//             bitValue *= 2;
//         }
//         return num;
//     }
// }
