public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] bills1 = {5, 5, 5, 10, 20};
        System.out.println("Test Case 1: " + lemonadeChange(bills1)); // Expected: true

        // Test Case 2
        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println("Test Case 2: " + lemonadeChange(bills2)); // Expected: false

        // Test Case 3 (Edge Case: No change needed)
        int[] bills3 = {5, 5, 5};
        System.out.println("Test Case 3: " + lemonadeChange(bills3)); // Expected: true

        // Test Case 4 (Edge Case: Insufficient change early)
        int[] bills4 = {5, 10, 20};
        System.out.println("Test Case 4: " + lemonadeChange(bills4)); // Expected: false
    }
}