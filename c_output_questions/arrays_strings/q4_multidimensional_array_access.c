// What is the output of the following code?
#include <stdio.h>

int main() {
    int arr[2][3] = {{1, 2, 3}, {4, 5, 6}};
    printf("%d %d %d", arr[1][0], *(*(arr+1)), *(arr[1]+2));
    return 0;
// Write your answer below:
// Output: 4 4 6

}
// Explanation: 
// - `arr[1][0]` accesses the first element of the second row, which is 4.
// - `*(*(arr+1))` dereferences the pointer to the second row, which gives the first element of that row, also 4.
// - `*(arr[1]+2)` accesses the third element of the second row, which is 6.
// Therefore, the output is "4 4 6".