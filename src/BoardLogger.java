public class BoardLogger {

    private int bestConflicts;
    private int attemptsSinceLastImprovement;

    public void startLogging(double temp, QueenBoard initialBoard) {
        this.bestConflicts = initialBoard.getConflicts();
        this.attemptsSinceLastImprovement = 0;

        System.out.println("Starting Simulated Annealing...\n");
        System.out.println("Initial State:");
        System.out.println("Temperature: " + String.format("%.2f", temp));
        System.out.println("Conflicts: " + bestConflicts);
        initialBoard.printBoard();
        System.out.println("---------------------------------------");
    }

    public void logImprovement(double temp, QueenBoard board) {
        int currentConflicts = board.getConflicts();
        System.out.println("Improvement found!");
        System.out.println("Temperature: " + String.format("%.2f", temp));
        System.out.println("Conflicts: " + currentConflicts);
        board.printBoard();
        System.out.println("Attempts till improvement: " + attemptsSinceLastImprovement);
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
