public class Main {
    public static void main(String[] args) {
        final BoardLogger logger = new BoardLogger();

        int n = 10;
        double initialTemp = 1000;
        double coolingRate = 0.99;
        double minTemp = 0.01;

        final QueenBoard board = new QueenBoard(n);

        logger.testBoard(initialTemp, coolingRate, minTemp, board);
    }

}
