// What is the output of the following code?
#include <stdio.h>

int main() {
    char arr[] = "abcde";
    printf("%lu %lu", sizeof(arr), sizeof("abcde"));
    return 0;
}
// Write your answer below:
// Output:  6 6

// Explanation:
// - `sizeof(arr)` gives the size of the array `arr`, which is initialized with the string "abcde".
//  The null terminator ('\0') is automatically added at the end of a string literal in C.
// - The string "abcde" has 5 characters plus a null terminator '\0', making it 6 bytes in total.
// - Therefore, `sizeof(arr)` returns 6. 




// - `sizeof("abcde")` also gives the size of the string literal "abcde", which is similarly 6 bytes (5 characters + null terminator).
// - Thus, both `sizeof(arr)` and `sizeof("abcde")` return 6.
// - The output is "6 6".