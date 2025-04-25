public class BoardLogger {

    public void testBoard(double initialTemp, double coolingRate, double minTemp, QueenBoard initialBoard) {

        double temp = initialTemp;
        int bestConflicts = initialBoard.getConflicts();
        int attemptsSinceLastImprovement = 0;

        System.out.println("Iniciando Simulated Annealing...\n");
        System.out.println("Estado inicial:");
        System.out.println("Temperatura: " + String.format("%.2f", temp));
        System.out.println("Conflitos: " + bestConflicts);
        initialBoard.printBoard();
        System.out.println("---------------------------------------");

        while (temp > minTemp && bestConflicts > 0) {
            QueenBoard neighbor = initialBoard.generateNeighbor();
            int neighborConflicts = neighbor.getConflicts();
            attemptsSinceLastImprovement++;

            if (this.calculateAcceptanceProbability(bestConflicts, neighborConflicts, temp) > Math.random()) {
                initialBoard = neighbor;

                if (neighborConflicts < bestConflicts) {
                    bestConflicts = neighborConflicts;

                    System.out.println("Temperatura: " + String.format("%.2f", temp));
                    System.out.println("Conflitos: " + bestConflicts);
                    initialBoard.printBoard();
                    System.out.println("Tentativas até melhoria: " + attemptsSinceLastImprovement);
                    System.out.println("---------------------------------------");

                    attemptsSinceLastImprovement = 0;
                }
            }

            temp *= coolingRate;
        }

        System.out.println("\nSolução final:");
        initialBoard.printBoard();
        System.out.println("Conflitos restantes: " + bestConflicts);
    }

    private double calculateAcceptanceProbability(int currentConflicts, int neighborConflicts, double temp) {
        if (neighborConflicts < currentConflicts) {
            return 1.0;
        }
        return Math.exp((currentConflicts - neighborConflicts) / temp);
    }

}
