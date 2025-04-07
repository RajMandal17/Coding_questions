import java.util.Scanner;

public class reverseString{

    public static void main(String[] args) {
        
    Scanner scanner = new Scanner(System.in);
    System.out.println("please enter String");
    String str = scanner.nextLine();         //note for string

    System.out.println(reverseString(str));


    }

    public  static String reverseString(String str){

        char[] chr = str.toCharArray();   //convert string to char[] array
        int left = 0;
        int right = chr.length-1;

        while(left<right){
         char temp = chr[right];
         chr[right] = chr[left];
         chr[left]=temp;
         
         right--;
         left++;

        }

        return new String(chr);  //conver char to String
    }
}