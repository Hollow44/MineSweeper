import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char cell = '.';
        char mine = 'X';
        int minesAroundCell = 0;

        char[][] field = {
                {cell,cell,cell,cell,cell,cell,cell,cell,cell},
                {cell,cell,cell,cell,cell,cell,cell,cell,cell},
                {cell,cell,cell,cell,cell,cell,cell,cell,cell},
                {cell,cell,cell,cell,cell,cell,cell,cell,cell},
                {cell,cell,cell,cell,cell,cell,cell,cell,cell},
                {cell,cell,cell,cell,cell,cell,cell,cell,cell},
                {cell,cell,cell,cell,cell,cell,cell,cell,cell},
                {cell,cell,cell,cell,cell,cell,cell,cell,cell},
                {cell,cell,cell,cell,cell,cell,cell,cell,cell}
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int grid = 9;

        int minesQuantity = scanner.nextInt();

        for (int i = 1; i <= minesQuantity; i++) {
            int row;
            int col;
            do {
                row = random.nextInt(grid);
                col = random.nextInt(grid);
            } while (field[row][col] != cell);

            field[row][col] = mine;
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[j].length; j++) {
                try {
                    if (field[i][j] != mine) {
                        if (field[i - 1][j - 1] == mine) {
                            minesAroundCell++;
                            field[i][j] = (char) (minesAroundCell + '0');
                        } if (field[i - 1][j] == mine) {
                            minesAroundCell++;
                            field[i][j] = (char) (minesAroundCell + '0');
                        } if (field[i - 1][j + 1] == mine) {
                            minesAroundCell++;
                            field[i][j] = (char) (minesAroundCell + '0');
                        } if (field[i][j - 1] == mine) {
                            minesAroundCell++;
                            field[i][j] = (char) (minesAroundCell + '0');
                        } if (field[i][j + 1] == mine) {
                            minesAroundCell++;
                            field[i][j] = (char) (minesAroundCell + '0');
                        } if (field[i + 1][j - 1] == mine) {
                            minesAroundCell++;
                            field[i][j] = (char) (minesAroundCell + '0');
                        } if (field[i + 1][j] == mine) {
                            field[i][j] = (char) (minesAroundCell + '0');
                        } if (field[i+ 1][j + 1] == mine) {
                            field[i][j] = (char) (minesAroundCell + '0');
                        }
                        if (minesAroundCell == 0) {
                            field[i][j] = cell;
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("Index is out of bound: " + e.getMessage());
                }
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}