package com.ninjaapps.checkers.view.game.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Author: Daniel
 */
@Component
class Tablica
{
    public int fields[][];

    @PostConstruct
    public void initializeFields() {
        fields = new int[8][8];
        this.clearFields();
    }

    public void clearFields()
    {
        for (int j = 0; j < 8; j++)
        {
            for (int i = 0; i < 8; i++)
            {
                fields[i][j] = 0;
            }
        }
    }

    public void showFields()
    {
        for (int j = 0; j < 8; j++)
        {
            for (int i = 0; i < 8; i++)
            {
                System.out.print(fields[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void transpozycja()
    {
        int tmp_pole[][] = new int[8][8];
        for (int j = 0; j < 8; j++)
        {
            for (int i = 0; i < 8; i++)
            {
                tmp_pole[j][i] = fields[i][j];
            }
        }
        fields = tmp_pole;
    }
}


