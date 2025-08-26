// What is the output of the following code?
#include <stdio.h>

int main() {
    char str[] = "hello";
    printf("%c %c %c", str[1], 2[str], *(str+3));
    return 0;
}
// Write your answer below:
// Output: e l l    




// Explanation:
// - `str[1]` accesses the second character of the string, which is 'e'.
// - `2[str]` is equivalent to `str[2]`, which accesses the third character of the string, 'l'.
// - `*(str+3)` dereferences the pointer to the fourth character of the string, which is also 'l'.
// Therefore, the output is "e l l".        