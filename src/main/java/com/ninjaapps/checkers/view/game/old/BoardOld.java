package com.ninjaapps.checkers.view.game.old;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BoardOld {
    @Value("${board.width}")
    private int width;

    @Value("${board.height}")
    private int height;

    private int[][] fields;

    public void init() {
        initializeBoard();
    }

    public void initializeBoard() {
        fields = new int[width][height];

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
