import java.util.Stack;

class ValidParenthesis{
    public boolean isValidParenthesis(String s){
        char[] data=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(char c:data){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char popped=stack.pop();
                if(!((popped=='('&&c==')')||(popped=='{'&&c=='}')||(popped=='['&&c==']'))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

public class Main{
    public static void main(String[] args) {
        ValidParenthesis vp=new ValidParenthesis();
        String s="({[]})";
        boolean res=vp.isValidParenthesis(s);
if(res){
    System.out.println("valid");
}else{
    System.out.println("invalid");
}
    }
}