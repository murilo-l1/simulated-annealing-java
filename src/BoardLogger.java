public class BoardLogger {

    private int bestConflicts;
    private int attemptsSinceLastImprovement;

    public void startLogging(double temp, QueenBoard initialBoard) {
        this.bestConflicts = initialBoard.getConflicts();
        this.attemptsSinceLastImprovement = 0;

        System.out.println("Iniciando Simulated Annealing...\n");
        System.out.println("Estado inicial:");
        System.out.println("Temperatura: " + String.format("%.2f", temp));
        System.out.println("Conflitos: " + bestConflicts);
        initialBoard.printBoard();
        System.out.println("---------------------------------------");
    }

    public void logImprovement(double temp, QueenBoard board) {
        int currentConflicts = board.getConflicts();
        System.out.println("Melhoria encontrada!");
        System.out.println("Temperatura: " + String.format("%.2f", temp));
        System.out.println("Conflitos: " + currentConflicts);
        board.printBoard();
        System.out.println("Tentativas até melhoria: " + attemptsSinceLastImprovement);
        System.out.println("---------------------------------------");
        this.bestConflicts = currentConflicts;
        this.attemptsSinceLastImprovement = 0;
    }

    public void incrementAttempts() {
        this.attemptsSinceLastImprovement++;
    }

    public int getBestConflicts() {
        return bestConflicts;
    }
}
