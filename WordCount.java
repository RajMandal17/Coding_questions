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
    }
}
