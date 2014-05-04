package com.bestsoft.checkers.view.game.model;

import com.bestsoft.checkers.log.AutowiredLogger;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Author: Daniel
 */
@Component
class Tablica
{
    @AutowiredLogger
    private Logger logger;

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
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < 8; j++)
        {

            for (int i = 0; i < 8; i++)
            {
                sb.append(fields[i][j]).append(" ");
            }
            logger.info(sb.toString());
            sb = new StringBuilder();
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


