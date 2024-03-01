import java.util.HashMap;
import java.util.Stack;

public class DNAtoRNA {
    public static String transcription(String dna){
        Stack<Character> stack = new Stack<>();
        StringBuilder rna = new StringBuilder();

        for(char c : dna.toCharArray()){
            switch(c){
                case 'A' :
                    stack.push('U');
                    break;
                case 'C' :
                    stack.push('G');
                    break;
                case 'G':
                    stack.push('C');
                    break;
                case 'T':
                    stack.push('A');
                    break;

            }
        }
        while(!stack.isEmpty()){
            rna.append(stack.pop());
        }
        return rna.toString();
    }

    public static void main(String[] args){
        String trans = "ATGGCC";
        String rna = transcription(trans);
        System.out.println("DNA: " + trans);
        System.out.println("RNA: " + rna);

    }
}
