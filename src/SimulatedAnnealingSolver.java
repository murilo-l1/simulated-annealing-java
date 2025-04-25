public class SimulatedAnnealingSolver {

    /**
     *
     * A cada iteração, o algoritmo gera um vizinho do tabuleiro atual e decide se aceita ou não essa nova
     * configuração com base na diferença de conflitos e na temperatura atual. Mesmo que o novo estado seja pior,
     * ele pode ser aceito com uma certa probabilidade (que diminui conforme a temperatura esfria)
     *
     * O processo continua enquanto a temperatura estiver acima de um valor mínimo e ainda existirem conflitos.
     * O melhor tabuleiro encontrado durante a execução é armazenado e retornado ao final.
     *
     * @param size Tamanho do tabuleiro (número de rainhas).
     * @param initialTemp Temperatura inicial do sistema.
     * @param coolingRate Fator de resfriamento da temperatura
     * @param minTemp Temperatura mínima para encerrar a execução.
     * @return Um QueenBoard representando a melhor solução encontrada
     */
    public static QueenBoard solve(int size, double initialTemp, double coolingRate, double minTemp) {
        QueenBoard current = new QueenBoard(size);
        QueenBoard best = current;
        double temp = initialTemp;

        while (temp > minTemp && best.getConflicts() > 0) {
            QueenBoard neighbor = current.generateNeighbor();
            int delta = neighbor.getConflicts() - current.getConflicts();

            if (delta < 0 || Math.random() < Math.exp(-delta / temp)) {
                current = neighbor;
                if (current.getConflicts() < best.getConflicts()) {
                    best = current;
                }
            }

            temp *= coolingRate;
        }

        return best;
    }

}
