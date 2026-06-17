//1. Reverse a String
//
//Write a function to reverse a string without using built-in reverse methods.
//
//        Input: "hello" → Output: "olleh"

class ReverseStringFunc{
    public String reverseString(String s){
        char[] chars=s.toCharArray();
        int i=0;
        int j=chars.length-1;
        while(i<j){
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
        i++;
        j--;

        }
        return new String(chars);
    }
}
public class ReverseString {
    public static void main(String[] args) {
 ReverseStringFunc reverse=new ReverseStringFunc();
 String s="Vishal";
 String res=reverse.reverseString(s);
        System.out.println(res);
    }
}
