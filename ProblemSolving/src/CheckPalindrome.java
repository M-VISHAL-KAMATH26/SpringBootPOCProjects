//Check Palindrome
//
//Check if a given string is a palindrome (ignore spaces and case).
//
//Input: "racecar" → Output: true
class ValidPalindrome{
    public boolean checkPalindromefunc(String s){
        String s1=s.toLowerCase().replaceAll("[^a-z0-9]","");
        int i=0;
        int j=s1.length()-1;
        while(i<j){
        if(s1.charAt(i)!=s1.charAt(j)) {
          return false;
        }
        i++;j--;
        }
        return true;
    }
}
public class CheckPalindrome {
    public static void main(String[] args) {
        ValidPalindrome vp=new ValidPalindrome();
        String s ="aabaa";
        System.out.println(vp.checkPalindromefunc(s));
    }
}
