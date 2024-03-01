import java.util.HashMap;
import java.util.Stack;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ]
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a
 * closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}
 * and ()
 */
public class BalancedBrackets {
    public static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hash = new HashMap<>();
        hash.put('(', ')');
        hash.put('{', '}');
        hash.put('[', ']');

        for(char c : s.toCharArray()){
            if(hash.containsKey(c)){
                stack.push(c);
            } else if (!stack.isEmpty() && hash.get(stack.peek()) == c) {
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args){
        System.out.println(isBalanced("{[(])}")); // NO one
        System.out.println(isBalanced("[()]")); // Yes one
        System.out.println(isBalanced("{{[[(())]]}}")); // Yes
    }







}
