// What is the output of the following code?
#include <stdio.h>

void fun(int arr[], int n) { 
                                // arr is treated as a pointer to the first element 
                                // of the array, so sizeof(arr) gives the size of a pointer, not the array. 
                                // On most systems, this is 8 bytes (64-bit architecture).
    printf("%d ", sizeof(arr));
}

int main() {
    int arr[5] = {1, 2, 3, 4, 5};
    printf("%d ", sizeof(arr));
    fun(arr, 5);
    return 0;
}
// Write your answer below:
// Output:  20 8
