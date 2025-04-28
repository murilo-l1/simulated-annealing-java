public class ComparisonMain {

    public static void main(String[] args) {
        int n = 12;

        double initialTemp = 10;
        double coolingRate = 0.99;
        double minTemp = 0.001;

        System.out.println("=== SIMULATED ANNEALING ===");
        long startAnnealing = System.nanoTime();
        QueenBoard annealingResult = SimulatedAnnealingSolver.solve(n, initialTemp, coolingRate, minTemp, new BoardLogger());
        long endAnnealing = System.nanoTime();

        System.out.println("\n=== SIMULATED ANNEALING ===");
        System.out.println("Exec. time: " + (endAnnealing - startAnnealing) / 1_000_000.0 + " ms");
        System.out.println("Found conflicts: " + annealingResult.getConflicts());
        annealingResult.printBoard();

        System.out.println("\n=== BRUTE FORCE ===");
        long startBrute = System.nanoTime();
        QueenBoard bruteResult = BruteForceSolver.solveBruteForce(n);
        long endBrute = System.nanoTime();
        System.out.println("Exec. time: " + (endBrute - startBrute) / 1_000_000.0 + " ms");
        System.out.println("Found conflicts: " + bruteResult.getConflicts());
        bruteResult.printBoard();
    }

}
