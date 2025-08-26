// What is the output of the following code?
#include <stdio.h>

int main() {
    int arr[] = {10, 20, 30};
    int *p = arr;
    printf("%d %d", *p++, *p);
    return 0;
}
// Write your answer below:
// Output: 10 20 
