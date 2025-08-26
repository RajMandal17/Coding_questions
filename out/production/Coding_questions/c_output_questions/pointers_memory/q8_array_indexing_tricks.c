// What is the output of the following code?
#include <stdio.h>

int main() {
    int arr[3] = {10, 20, 30};
    int *p = arr;
    printf("%d %d %d", arr[1], *(p+1), 1[arr]);

    // arr[1] is the second element of the array, which is 20.
    // *(p+1) dereferences the pointer p after moving it one element forward, which also gives 20.
    // 1[arr] is equivalent to arr[1], which is also 20.
    return 0;
}
// Write your answer below:
// Output: 20 20 20