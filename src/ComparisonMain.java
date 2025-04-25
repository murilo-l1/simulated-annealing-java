public class ComparisonMain {

    public static void main(String[] args) {
        int n = 13; //numero de rainhas e dimensao tabuleiro

        double initialTemp = 10; // grau de aleatoriedade e aceitação de mínimos locais
        double coolingRate = 0.99;// grau de resfriamento: quanto maior, mais tentativas e maior probabilidade de achar o mínimo de conflitos
        double minTemp = 0.001; // condicaco de parada, um número menor indica que ele vai testar por mais tempo

        System.out.println("=== SIMULATED ANNEALING ===");
        long startAnnealing = System.nanoTime();
        QueenBoard annealingResult = SimulatedAnnealingSolver.solve(n, initialTemp, coolingRate, minTemp, new BoardLogger());
        long endAnnealing = System.nanoTime();

        System.out.println("\n=== SIMULATED ANNEALING ===");
        System.out.println("Tempo: " + (endAnnealing - startAnnealing) / 1_000_000.0 + " ms");
        System.out.println("Conflitos finais: " + annealingResult.getConflicts());
        annealingResult.printBoard();

        System.out.println("\n=== FORÇA BRUTA ===");
        long startBrute = System.nanoTime();
        QueenBoard bruteResult = BruteForceSolver.solveBruteForce(n);
        long endBrute = System.nanoTime();
        System.out.println("Tempo: " + (endBrute - startBrute) / 1_000_000.0 + " ms");
        System.out.println("Conflitos finais: " + bruteResult.getConflicts());
        bruteResult.printBoard();
    }
}
