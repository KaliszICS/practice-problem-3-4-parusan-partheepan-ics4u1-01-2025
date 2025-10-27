import java.util.ArrayList;

public class PracticeProblem {

    public static void main(String args[]) {
        // Test the function
        int[] result1 = recaman(6);
        System.out.print("n=6: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static int[] recaman(int n) {
        // Return empty array for 0 or negative numbers
        if (n <= 0) {
            return new int[0];
        }
        
        ArrayList<Integer> sequence = new ArrayList<>();
        // Start generating from term 1 (skip the 0 if examples don't include it)
        generateRecaman(n, sequence, 1);
        
        // Convert ArrayList to array
        int[] result = new int[sequence.size()];
        for (int i = 0; i < sequence.size(); i++) {
            result[i] = sequence.get(i);
        }
        return result;
    }
    
    private static void generateRecaman(int n, ArrayList<Integer> sequence, int termIndex) {
        // Base case: when we've generated enough terms
        if (sequence.size() >= n) {
            return;
        }
        
        if (termIndex == 1) {
            // First term is 1 (according to examples)
            sequence.add(1);
        } else {
            int lastTerm = sequence.get(termIndex - 2); // -2 because we start from index 1
            int potentialNext = lastTerm - termIndex;
            
            // Check if we can use subtraction (must be positive and not in sequence)
            if (potentialNext > 0 && !sequence.contains(potentialNext)) {
                sequence.add(potentialNext);
            } else {
                // Otherwise use addition
                sequence.add(lastTerm + termIndex);
            }
        }
        
        // Recursive call to generate next term
        generateRecaman(n, sequence, termIndex + 1);
    }
}