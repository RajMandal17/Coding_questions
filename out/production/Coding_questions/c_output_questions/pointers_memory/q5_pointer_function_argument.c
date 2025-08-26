// What is the output of the following code?
#include <stdio.h>

void update(int *p) {  //*p = &a = 7;
    *p = *p + 5;
}

int main() {
    int a = 7;
    update(&a);    *p = &a;
    printf("%d", a);
    return 0;
}
// Write your answer below:
// Output: 12
