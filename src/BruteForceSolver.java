
public class BruteForceSolver {

    //O(n!)
    public static QueenBoard solveBruteForce(int n) {
        int[] initial = new int[n];
        for (int i = 0; i < n; i++) {
            initial[i] = i; // cada valor representa a linha da rainha na coluna i
        }

        QueenBoard best = null;

        do {
            QueenBoard candidate = new QueenBoard(n);
            System.arraycopy(initial, 0, candidate.queens, 0, n);
            if (candidate.getConflicts() == 0) {
                best = candidate;
                break;
            }
        } while (nextPermutation(initial));

        return best;
    }

    // Gera próxima permutação entre 
    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        for (int k = i + 1, l = arr.length - 1; k < l; k++, l--) {
            temp = arr[k];
            arr[k] = arr[l];
            arr[l] = temp;
        }

        return true;
    }
}