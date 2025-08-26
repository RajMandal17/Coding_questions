// What is the output of the following code?
#include <stdio.h>

int main() {
    char arr[4] = {'h', 'i', '!', '!'};
    printf("%s", arr);
    return 0;
// Write your answer below:
// Output: hi!!     

// Explanation:
// - The `arr` is a character array initialized with the characters 'h', 'i', '!', and '!'.
// - When you use `%s` in `printf`, it expects a null-terminated string.
// - Since `arr` does not have a null terminator (`'\0'`),
//  it will print the characters until it encounters a null terminator in memory.
// - The output will be "hi!!" followed by whatever characters are in memory after the '!'
//  characters until a null terminator is found.     
