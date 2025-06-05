// What is the output of the following code?
#include <stdio.h>

void update(int *p) {
    *p = *p + 5;
}

int main() {
    int a = 7;
    update(&a);
    printf("%d", a);
    return 0;
}
// Write your answer below:
// Output:
