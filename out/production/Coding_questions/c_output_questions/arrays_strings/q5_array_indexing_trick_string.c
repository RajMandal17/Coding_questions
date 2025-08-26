// What is the output of the following code?
#include <stdio.h>

int main() {
    char s[] = "welcome";
    printf("%c %c %c", 5[s], s[5], *(s+5));
    return 0;
}
// Write your answer below:
// Output:c c c  

// Explanation:
// - `5[s]` is equivalent to `s[5]`, which accesses the sixth character of the string "welcome", which is 'c'.
// - `s[5]` directly accesses the sixth character of the string, which is also 'c'.
// - `*(s+5)` dereferences the pointer to the sixth character of the string, which is also 'c'.
// Therefore, the output is "c c c".