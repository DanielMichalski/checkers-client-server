package view.game;

import org.springframework.stereotype.Component;

@Component
public class Board {
    public static final int WIDTH = 8;

    public static final int HEIGHT = 8;

    private int[][] fields;

    public void init() {
        initializeBoard();
    }

    public void initializeBoard() {
        fields = new int[WIDTH][HEIGHT];

        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = (j + i) % 2;
            }
        }
    }

    public void printFields() {
        for (int[] field : fields) {
            for (int i : field) {
                System.out.print(i + "\t");
            }
            System.out.print("\n");
        }
    }

    public int[][] getFields() {
        return fields;
    }
}
