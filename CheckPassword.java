import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;
public class CheckPassword {
    public static void CheckPasswordvalid(char str[],int n,int min){
        HashMap<String,Boolean>map=new HashMap<>();
        if(n<min){
            System.out.println("invalid");
            return;
        }
        if(Character.isDigit(str[0])){
            System.out.println("invalid");
            return;
        }
        for(char val:str){
            if((int)val==32 || val=='+'){
                System.out.println("invalid");
                return;
            }
        }
        for(char val:str){
            if((Character.isDigit(val))){
                map.put("digit", true);
                break;
            }  
        }
        for(char val:str){
            if((Character.isUpperCase(val))){
                map.put("upper", true);
                break;
            }  
        }
        for(char val:str){
            if((Character.isAlphabetic(val))){
                map.put("alphabetic", true);
                break;
            }   
        }
        if(!map.containsKey("digit")|| !map.containsKey("alphabetic")||
        !map.containsKey("upper")){
                System.out.println("invalid");
                return;
        }
        System.out.println("valid");


    }
      public static void main(String[] args) {
        String passWord;
        int min;
        try ( Scanner sc=new Scanner(System.in)) {
            System.out.print("enter min value:");
            min=sc.nextInt();
            System.out.print("enter your password:");
            passWord=sc.next();
            CheckPasswordvalid(passWord.toCharArray(),passWord.length(),min);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

      }
}
