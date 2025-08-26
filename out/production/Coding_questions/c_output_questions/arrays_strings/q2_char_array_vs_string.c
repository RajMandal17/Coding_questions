// What is the output of the following code?
#include <stdio.h>

int main() {
    char arr[5] = {'a', 'b', 'c', 'd', '\0'};
    printf("%s %c", arr, arr[3]);
    return 0;
// Write your answer below:
// Output: abcd d

// Explanation:
// - `arr` is a character array initialized with the characters 'a', 'b', 'c', 'd', and a null terminator '\0'.
// - When you use `%s` in `printf`, it prints the string starting from the first character until it encounters the null terminator.
// - Therefore, `printf("%s", arr)` prints "abcd".