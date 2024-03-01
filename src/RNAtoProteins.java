import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RNAtoProteins {

    // each 3 nucleotides correspond to one amino acid
    // {A, C, G, U}

    //HashMap<String, Character> codonMap = new HashMap<>();




        private static final HashMap<String, Character> codonMap = new HashMap<>();
static {
            codonMap.put("UUU", 'F');
            codonMap.put("UUC", 'F');
            codonMap.put("UUA", 'L');
            codonMap.put("UUG", 'L');
            codonMap.put("CUU", 'L');
            codonMap.put("CUC", 'L');
            codonMap.put("CUA", 'L');
            codonMap.put("CUG", 'L');
            codonMap.put("AUU", 'I');
            codonMap.put("AUC", 'I');
            codonMap.put("AUA", 'I');
            codonMap.put("AUG", 'M');
            codonMap.put("GUU", 'V');
            codonMap.put("GUC", 'V');
            codonMap.put("GUA", 'V');
            codonMap.put("GUG", 'V');
            codonMap.put("UCU", 'S');
            codonMap.put("UCC", 'S');
            codonMap.put("UCA", 'S');
            codonMap.put("UCG", 'S');
            codonMap.put("CCU", 'P');
            codonMap.put("CCC", 'P');
            codonMap.put("CCA", 'P');
            codonMap.put("CCG", 'P');
            codonMap.put("ACU", 'T');
            codonMap.put("ACC", 'T');
            codonMap.put("ACA", 'T');
            codonMap.put("ACG", 'T');
            codonMap.put("GCU", 'A');
            codonMap.put("GCC", 'A');
            codonMap.put("GCA", 'A');
            codonMap.put("GCG", 'A');
            codonMap.put("UAU", 'Y');
            codonMap.put("UAC", 'Y');
            codonMap.put("UAA", '.');
            codonMap.put("UAG", '.');
            codonMap.put("CAU", 'H');
            codonMap.put("CAC", 'H');
            codonMap.put("CAA", 'Q');
            codonMap.put("CAG", 'Q');
            codonMap.put("AAU", 'N');
            codonMap.put("AAC", 'N');
            codonMap.put("AAA", 'K');
            codonMap.put("AAG", 'K');
            codonMap.put("GAU", 'D');
            codonMap.put("GAC", 'D');
            codonMap.put("GAA", 'E');
            codonMap.put("GAG", 'E');
            codonMap.put("UGU", 'C');
            codonMap.put("UGC", 'C');
            codonMap.put("UGA", '.');
            codonMap.put("UGG", 'W');
            codonMap.put("CGU", 'R');
            codonMap.put("CGC", 'R');
            codonMap.put("CGA", 'R');
            codonMap.put("CGG", 'R');
            codonMap.put("AGU", 'S');
            codonMap.put("AGC", 'S');
            codonMap.put("AGA", 'R');
            codonMap.put("AGG", 'R');
            codonMap.put("GGU", 'G');
            codonMap.put("GGC", 'G');
            codonMap.put("GGA", 'G');
            codonMap.put("GGG", 'G');
        }
    public static String proteinstranscription(String codon) {
        StringBuilder strings = new StringBuilder();
        Stack<Character> stack = new Stack<>();


        //sees if its on eof these
        for (char c : codon.toCharArray()) {
            if (!"ACGU".contains(String.valueOf(c))) {
                throw new IllegalArgumentException("Invalid nucleotide: " + c);
            }

            stack.push(c); // pushes current nucleotides onto the stack

            if (stack.size() == 3) { // if it cointains 3 nucleotides
                StringBuilder s = new StringBuilder(); // builds the codon
                while (!stack.isEmpty()) { // put it in s from the stack
                    s.append(stack.pop()); // Build codon in correct order
                }
                String amino = s.toString(); // codon to string

                // look for correspoding amino for the codon in the hashmap
                char aminoAcid = codonMap.getOrDefault(amino, '.'); // Use '?' for unknown codons

                if (aminoAcid == '.') {
                    break; // Stop codon, end
                }

                strings.append(aminoAcid);
            }
        } if (codon.length() % 3 != 0) { // check if length is a mult of 3 or add .
            strings.append('.');
        }
        return strings.toString();
        }














        /*if (codon.length() % 3 != 0) { // check length is mult of 3
            System.out.println("Invalid codon length: " + codon.length());
            return null;
        }

        StringBuilder s = new StringBuilder();
        for (char c : codon.toCharArray()) {
            if (c != 'A' && c != 'C' && c != 'G' && c != 'U') {
                System.out.println("Invalid nucleotide: " + c);
                return null;
            }
            stack.push(c);
        }

        //if (stack.size() == 3) {
            //s.setLength(0); // reset strings
            while (!stack.isEmpty()) {
                //s.insert(0, stack.pop()); // the codon is correct
                s.setLength(0); // reset strings
                //codon is complete
                for (int i = 0; i < 3; i++) {
                    s.insert(0, stack.pop());
                }
            String codonStr = s.toString();
            Character aminoAcid = codonMap.getOrDefault(codonStr, '.');
            strings.append(aminoAcid);// // Append the amino acid to the result
            //s.setLength(0); // reset strings

        }

        return strings.toString();
    }
        //return strings.toString();

*/

    public static void main(String[] args) {
       // HashMap<String, Character> codonMap = new HashMap<>();
        String sampleinput1 = "AGCUGGGAAACGUAGGCCUA";
        String sampleoutput1 = proteinstranscription(sampleinput1);
        System.out.println("sample 1: " + sampleoutput1);

        String sampleinput2 = "UAAAGAGAAGCCAGC";
        String sampleoutput2 = proteinstranscription(sampleinput2);
        System.out.println("sample 2: " + sampleoutput2);
    }
    }





