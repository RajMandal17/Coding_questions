// What is the output of the following code?
#include <stdio.h>

int main() {
    int arr[] = {1, 2, 3, 4};
    int *p = arr;
    printf("%d %d %d", sizeof(arr), sizeof(p), sizeof(*p));
    return 0;
}
// Write your answer below:
// Output: 16,8,4




// sizeof(arr)

// arr is an array of 4 integers.
// On most systems, sizeof(int) is 4 bytes.
// So, sizeof(arr) = 4 elements × 4 bytes = 16.
// sizeof(p)

// p is a pointer to int.
// On a 64-bit Linux system, a pointer is typically 8 bytes.
// So, sizeof(p) = 8.
// sizeof(*p)

// *p is the value pointed to by p, which is an int.
// So, sizeof(*p) = sizeof(int) = 4.