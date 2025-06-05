// What is the output of the following code?
#include <stdio.h>

int main() {
    int arr[3] = {1, 2, 3};
    int *p = arr;
    printf("%d %d %d", *p, *(p+1), p[2]);
                // arr[0] , *(arr[0] + 1), arr[2]
    return 0;
}
// Write your answer below:
// Output:1 2 3
