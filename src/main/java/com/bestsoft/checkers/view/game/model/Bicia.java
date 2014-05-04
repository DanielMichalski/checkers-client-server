package com.bestsoft.checkers.view.game.model;

import org.springframework.stereotype.Component;

/**
 * Author: Daniel
 */
@Component
public class Bicia extends Tablica {
    public boolean isItRequired;

    private int getBeats(int x, int y, Board p) {
        int wynik = 0;

        if (p.fields[x][y] == 2) {
            if (x > 1 && y > 1 && (p.fields[x - 1][y - 1] == 3
                    || p.fields[x - 1][y - 1] == 5) && p.fields[x - 2][y - 2] == 1)
                wynik = wynik + 1;

            if (x < 6 && y > 1 && (p.fields[x + 1][y - 1] == 3
                    || p.fields[x + 1][y - 1] == 5) && p.fields[x + 2][y - 2] == 1)
                wynik = wynik + 2;

            if (x > 1 && y < 6 && (p.fields[x - 1][y + 1] == 3
                    || p.fields[x - 1][y + 1] == 5) && p.fields[x - 2][y + 2] == 1)
                wynik = wynik + 4;

            if (x < 6 && y < 6 && (p.fields[x + 1][y + 1] == 3
                    || p.fields[x + 1][y + 1] == 5) && p.fields[x + 2][y + 2] == 1)
                wynik = wynik + 8;
        } else if (p.fields[x][y] == 3) {
            if (x > 1 && y < 6 && (p.fields[x - 1][y + 1] == 2
                    || p.fields[x - 1][y + 1] == 4) && p.fields[x - 2][y + 2] == 1)
                wynik = wynik + 1;

            if (x < 6 && y < 6 && (p.fields[x + 1][y + 1] == 2
                    || p.fields[x + 1][y + 1] == 4) && p.fields[x + 2][y + 2] == 1)
                wynik = wynik + 2;

            if (x > 1 && y > 1 && (p.fields[x - 1][y - 1] == 2
                    || p.fields[x - 1][y - 1] == 4) && p.fields[x - 2][y - 2] == 1)
                wynik = wynik + 4;

            if (x < 6 && y > 1 && (p.fields[x + 1][y - 1] == 2
                    || p.fields[x + 1][y - 1] == 4) && p.fields[x + 2][y - 2] == 1)
                wynik = wynik + 8;
        } else if (p.fields[x][y] == 4) {
            int i = 0;
            int j = 0;
            while (x + i > 1 && y + j > 1) {
                if ((p.fields[x + i - 1][y + j - 1] == 3 || p.fields[x + i - 1][y + j - 1] == 5)
                        && p.fields[x + i - 2][y + j - 2] == 1) {
                    wynik = wynik + 1;
                    break;
                } else if (p.fields[x + i - 1][y + j - 1] != 1) {
                    break;
                } else {
                    --i;
                    --j;
                }
            }

            i = 0;
            j = 0;

            while (x + i < 6 && y + j > 1) {
                if ((p.fields[x + i + 1][y + j - 1] == 3 || p.fields[x + i + 1][y + j - 1] == 5)
                        && p.fields[x + i + 2][y + j - 2] == 1) {
                    wynik = wynik + 2;
                    break;
                } else if (p.fields[x + i + 1][y + j - 1] != 1) {
                    break;
                } else {
                    ++i;
                    --j;
                }
            }

            i = 0;
            j = 0;

            while (x + i > 1 && y + j < 6) {
                if ((p.fields[x + i - 1][y + j + 1] == 3 || p.fields[x + i - 1][y + j + 1] == 5)
                        && p.fields[x + i - 2][y + j + 2] == 1) {
                    wynik = wynik + 4;
                    break;
                } else if (p.fields[x + i - 1][y + j + 1] != 1) {
                    break;
                } else {
                    --i;
                    ++j;
                }
            }

            i = 0;
            j = 0;

            while (x + i < 6 && y + j < 6) {
                if ((p.fields[x + i + 1][y + i + 1] == 3 || p.fields[x + i + 1][y + j + 1] == 5)
                        && p.fields[x + j + 2][y + j + 2] == 1) {
                    wynik = wynik + 8;
                    break;
                } else if (p.fields[x + i + 1][y + j + 1] != 1) {
                    break;
                } else {
                    ++i;
                    ++j;
                }
            }

        } else if (p.fields[x][y] == 5) {
            int i = 0;
            int j = 0;
            while (x + i > 1 && y + j > 1) {
                if ((p.fields[x + i - 1][y + j - 1] == 2 || p.fields[x + i - 1][y + j - 1] == 4)
                        && p.fields[x + i - 2][y + j - 2] == 1) {
                    wynik = wynik + 4;
                    break;
                } else if (p.fields[x + i - 1][y + j - 1] != 1) {
                    break;
                } else {
                    --i;
                    --j;
                }
            }

            i = 0;
            j = 0;

            while (x + i < 6 && y + j > 1) {
                if ((p.fields[x + i + 1][y + j - 1] == 2 || p.fields[x + i + 1][y + j - 1] == 4)
                        && p.fields[x + i + 2][y + j - 2] == 1) {
                    wynik = wynik + 8;
                    break;
                } else if (p.fields[x + i + 1][y + j - 1] != 1) {
                    break;
                } else {
                    ++i;
                    --j;
                }
            }

            i = 0;
            j = 0;

            while (x + i > 1 && y + j < 6) {
                if ((p.fields[x + i - 1][y + j + 1] == 2 || p.fields[x + i - 1][y + j + 1] == 4)
                        && p.fields[x + i - 2][y + j + 2] == 1) {
                    wynik = wynik + 1;
                    break;
                } else if (p.fields[x + i - 1][y + j + 1] != 1) {
                    break;
                } else {
                    --i;
                    ++j;
                }
            }

            i = 0;
            j = 0;

            while (x + i < 6 && y + j < 6) {
                if ((p.fields[x + i + 1][y + i + 1] == 2 || p.fields[x + i + 1][y + j + 1] == 4)
                        && p.fields[x + j + 2][y + j + 2] == 1) {
                    wynik = wynik + 2;
                    break;
                } else if (p.fields[x + i + 1][y + j + 1] != 1) {
                    break;
                } else {
                    ++i;
                    ++j;
                }
            }

        }

        if (wynik != 0) isItRequired = true;

        return wynik;
    }

    public void sprawdz_bicia(int gracz, Board p) {
        clearFields();
        isItRequired = false;

        for (int j = 0; j < 8; j++)
            for (int i = 0; i < 8; i++)
                if ((gracz + 1) == p.fields[i][j] || (gracz + 3) == p.fields[i][j]) {
                    this.fields[i][j] = getBeats(i, j, p);
                } else {
                    this.fields[i][j] = 0;
                }
    }

    public void sprawdz_bicia(int gracz, Board p, int x, int y) {
        clearFields();
        isItRequired = false;

        this.fields[x][y] = getBeats(x, y, p);
    }
}
