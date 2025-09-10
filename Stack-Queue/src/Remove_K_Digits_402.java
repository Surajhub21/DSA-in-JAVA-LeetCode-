import java.util.Stack;

public class Remove_K_Digits_402 {

    public static String removeKdigits(String num, int k) {
        if(num.isEmpty() || num.length() == k) return "0";
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);

            while(!s.isEmpty() && k > 0 && (s.peek() - '0') > (c - '0'))
            {
                s.pop();
                k--;
            }

            s.push(c);
        }
        /*
        if the no is like 123456
        then pop from the last
         */
        while(k > 0) {
            s.pop();
            k--;
        }

        if(s.isEmpty()) return "0";

        StringBuilder str = new StringBuilder();
        while(!s.isEmpty()){
            str.append(s.peek());
            s.pop();
        }

        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == '0'){
                str.deleteCharAt(i);
            }
            else{
                break;
            }
        }

        return str.reverse().isEmpty() ? "0" : str.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("143" , 3));
    }
}
