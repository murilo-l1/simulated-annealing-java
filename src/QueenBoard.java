import java.util.Random;

public class QueenBoard {
    public final int[] queens; // índice: coluna, valor: linha
    private final Random rand = new Random();

    public QueenBoard(int size) {
        queens = new int[size];
        for (int i = 0; i < size; i++) {
            queens[i] = rand.nextInt(size);
        }
    }

    // procura por conflito na coluna da rainha e nas suas diagonais
    public int getConflicts() {
        int conflicts = 0;
        int n = queens.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (queens[i] == queens[j] || Math.abs(queens[i] - queens[j]) == Math.abs(i - j)) {
                    conflicts++;
                }
            }
        }
        return conflicts;
    }

    /**
     * Cria instância de QueenBoard copiando a configuração atual
     * de rainhas, e então move uma única rainha (escolhida aleatoriamente) para
     * uma nova linha (também escolhida aleatoriamente) dentro da mesma coluna.
     *
     * @return Um novo QueenBoard representando um estado vizinho do atual.
     */
    public QueenBoard generateNeighbor() {
        QueenBoard neighbor = new QueenBoard(queens.length);
        System.arraycopy(this.queens, 0, neighbor.queens, 0, queens.length);

        int col = rand.nextInt(queens.length);
        int newRow = rand.nextInt(queens.length);
        neighbor.queens[col] = newRow;

        return neighbor;
    }

    public void printBoard() {
        for (int row = 0; row < queens.length; row++) {
            for (int col = 0; col < queens.length; col++) {
                System.out.print(queens[col] == row ? " Q " : " . ");
            }
            System.out.println();
        }
    }

}
