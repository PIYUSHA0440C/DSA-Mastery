class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        
        StringBuilder sb = new StringBuilder(); 
        int carry = 0;

        while(len1 >= 0 || len2 >= 0 || carry > 0){
            int sum = carry;

            if(len1 >= 0 && len2 < 0){
                sum += (num1.charAt(len1--) - '0');
            } else if(len2 >= 0 && len1 < 0){
                sum += (num2.charAt(len2--) - '0');
            } else if(len1 >= 0 && len2 >= 0) {
                sum += (num1.charAt(len1--) - '0') + (num2.charAt(len2--) - '0');
            }

            sb.append(sum % 10); 
            carry = sum / 10;  
        }

        return sb.reverse().toString(); 
    }
}


// class Solution {
//     public String addStrings(String num1, String num2) {
//         int len1 = num1.length() - 1;
//         int len2 = num2.length() - 1;
//         int[] arr = new int[len1 + len2 + 1];
//         int len = arr.length - 1;
//         int carry = 0;

//         while(len1 >= 0 || len2 >= 0){
//             if(len1 < 0){
//                 arr[len] = num2.charAt(len2);
//             } else if(len2 < 0){
//                 arr[len] = num1.charAt(len1);
//             } else{
//                 int sum = (num1.charAt(len1) - '0') + (num2.charAt(len2) - '0');
//                 if(sum + carry > 9){
//                     carry += 1;
//                     arr[len] = sum + carry % 2;
//                 } else{
//                     arr[len] = sum + carry;
//                     carry = 0;
//                 }
//             }
//             len--;
//             len1--;
//             len2--;
//         }
//         String str = "";
//         for(int i : arr){
//             str += i;
//         }
//         return str;
//     }
// }
