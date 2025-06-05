import java.util.Scanner;

public class WordCount {
    
    public static void main(String[] arr){
        System.out.println("Enter the word :");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        countword(str);

    }

    public static void countword(String str){

        str = str.toLowerCase().replaceAll("[^a-zA-Z]", "");
        String[] words = str.split("\\s+");

        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        
        System.out.println("The number of words in the string is: " + count);
        System.out.println("The number of characters in the string is: " + str.length());
        System.out.println("The number of letters in the string is: " + str.replaceAll("[^a-zA-Z]", "").length());
        System.out.println("The number of digits in the string is: " + str.replaceAll("[^0-9]", "").length());
    }
}
