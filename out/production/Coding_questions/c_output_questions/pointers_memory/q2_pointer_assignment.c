// What is the output of the following code?
#include <stdio.h>

int main() {
    int a = 5, b = 10;
    int *p1 = &a, *p2 = &b;
    *p1 = *p2;
    printf("%d %d", a, b);
    return 0;
}
// Write your answer below:
// Output: 10 10