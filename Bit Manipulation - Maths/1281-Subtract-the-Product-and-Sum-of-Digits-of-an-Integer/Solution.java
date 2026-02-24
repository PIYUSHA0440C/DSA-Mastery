class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while(n != 0){
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }

        return product - sum;
    }
}

// class Solution {
//     public int subtractProductAndSum(int n) {
//         return product(n) - sum(n); 
//     }

//     int product(int n){
//         int product = 1;
//         while(n != 0){
//             int digit = n % 10;
//             product *= digit;
//             n /= 10;
//         }
//         return product;
//     }

//     int sum(int n){
//         int sum = 0;
//         while(n != 0){
//             int digit = n % 10;
//             sum += digit;
//             n /= 10;
//         }
//         return sum;
//     }
// }
