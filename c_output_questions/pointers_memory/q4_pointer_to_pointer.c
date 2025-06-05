// What is the output of the following code?
#include <stdio.h>

int main() {
    int x = 100;
    int *p1 = &x;   // p1 points to x, so *p1 = x
    int **p2 = &p1;
    **p2 = 200;
     // p2 points to p1, so *p2 = p1, and **p2 = x
    printf("%d %d %d", x, *p1, **p2 ,*p2);
    // x = 200, *p1 = 200, **p2 = 200, *p2 = p1 (address of x)

    return 0;
}
// Write your answer below:
// Output: // 
// p1 is a pointer to an integer, and it is assigned the address of x.
// So, p1 = &x; means p1 holds the address of x.

// *p1 dereferences the pointer, so *p1 gives you the value stored at the
//  address p1 points to, which is the value of x.


// p2 is a pointer to p1 (so p2 holds the address of p1).
// When you write **p2:

// The first * dereferences p2, giving you p1 (the address of x).
// The second * dereferences p1, giving you the value of x.