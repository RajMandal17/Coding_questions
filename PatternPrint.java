public class PatternPrint {

    public static void main(String[] args){

        String str = "RajCode";
        int len = str.length();

        for(int i=0 ; i< len/2;i++){
            for(int j=0; j<i ; j++){
                System.out.print(" ");
            }
            System.out.println(str.charAt(i));

            for(int j=0; j<len-i-1; j++){
                System.out.print(" ");
            }
            System.out.println(str.charAt(i));
        }
    }
    
}
