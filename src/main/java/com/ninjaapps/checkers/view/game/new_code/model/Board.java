package com.ninjaapps.checkers.view.game.new_code.model;

import org.springframework.stereotype.Component;

/**
 * Author: Daniel
 */
@Component
public class Board extends Tablica {
    @Override
    public void clearFields() {
        int k = 1;
        for (int j = 0; j < 8; j++) {
            k = (k + 1) % 2;
            for (int i = 0; i < 8; i++) {
                fields[i][j] = k;
                k = (k + 1) % 2;
            }
        }
    }

    public void start() {
        clearFields();

        // player 1
        for (int j = 5; j < 8; j++)
            for (int i = 0; i < 8; i++)
                if (fields[i][j] == 1) fields[i][j] = 2;
        //	player 2

        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 8; i++)
                if (fields[i][j] == 1) fields[i][j] = 3;

    }
}
