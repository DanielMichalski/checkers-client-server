package com.bestsoft.checkers.view.game.model;

import com.bestsoft.checkers.log.AutowiredLogger;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Author: Daniel
 */
@Component
public class Moves extends Tablica {
    @AutowiredLogger
    private Logger logger;

    private int oldX;

    private int oldY;

    private int gracz;

    public void init() {
        this.set_gracz(0);
    }

    public void klikniecie(int x, int y, Board p, Bicia b) {
        b.sprawdz_bicia(gracz, p);

        if (this.fields[x][y] == 0) {
            this.clearFields();
            if (p.fields[x][y] > 1) //jeżeli w polu znajduje się pionek
            {
                this.fields[x][y] = 1; //obecnie zaznaczony pionek

                //jeżeli jest to pionek gracza 1
                if (p.fields[x][y] == 2 && this.gracz == 1) {
                    if (x > 0 && y > 0 && p.fields[x - 1][y - 1] == 1 && !b.isItRequired)
                        this.fields[x - 1][y - 1] = 2;

                    if (x < 7 && y > 0 && p.fields[x + 1][y - 1] == 1 && !b.isItRequired)
                        this.fields[x + 1][y - 1] = 2;

                    if (x > 1 && y > 1 && (p.fields[x - 1][y - 1] == 3
                            || p.fields[x - 1][y - 1] == 5) && p.fields[x - 2][y - 2] == 1) {
                        this.fields[x - 2][y - 2] = 3;
                    }

                    if (x < 6 && y > 1 && (p.fields[x + 1][y - 1] == 3
                            || p.fields[x + 1][y - 1] == 5) && p.fields[x + 2][y - 2] == 1) {
                        this.fields[x + 2][y - 2] = 3;
                    }

                    if (x > 1 && y < 6 && (p.fields[x - 1][y + 1] == 3
                            || p.fields[x - 1][y + 1] == 5) && p.fields[x - 2][y + 2] == 1) {
                        this.fields[x - 2][y + 2] = 3;
                    }

                    if (x < 6 && y < 6 && (p.fields[x + 1][y + 1] == 3
                            || p.fields[x + 1][y + 1] == 5) && p.fields[x + 2][y + 2] == 1) {
                        this.fields[x + 2][y + 2] = 3;
                    }

                }
                //jeżeli jest to pionek racza 2
                else if (p.fields[x][y] == 3 && this.gracz == 2) {
                    if (x > 0 && y < 7 && p.fields[x - 1][y + 1] == 1 && !b.isItRequired)
                        this.fields[x - 1][y + 1] = 2;

                    if (x < 7 && y < 7 && p.fields[x + 1][y + 1] == 1 && !b.isItRequired)
                        this.fields[x + 1][y + 1] = 2;

                    if (x > 1 && y < 6 && (p.fields[x - 1][y + 1] == 2
                            || p.fields[x - 1][y + 1] == 4) && p.fields[x - 2][y + 2] == 1) {
                        this.fields[x - 2][y + 2] = 3;
                    }

                    if (x < 6 && y < 6 && (p.fields[x + 1][y + 1] == 2
                            || p.fields[x + 1][y + 1] == 4) && p.fields[x + 2][y + 2] == 1) {
                        this.fields[x + 2][y + 2] = 3;
                    }

                    if (x > 1 && y > 1 && (p.fields[x - 1][y - 1] == 2
                            || p.fields[x - 1][y - 1] == 4) && p.fields[x - 2][y - 2] == 1) {
                        this.fields[x - 2][y - 2] = 3;
                    }

                    if (x < 6 && y > 1 && (p.fields[x + 1][y - 1] == 2
                            || p.fields[x + 1][y - 1] == 4) && p.fields[x + 2][y - 2] == 1) {
                        this.fields[x + 2][y - 2] = 3;
                    }
                }
                //jeżeli jest to damka gracza 1 lub gracza 2
                else if ((p.fields[x][y] == 4 && this.gracz == 1)
                        || (p.fields[x][y] == 5 && this.gracz == 2)) {
                    int i = 0;
                    int j = 0;
                    int add = (gracz == 1) ? 1 : 0;

                    while (!b.isItRequired && x + i > 0 && y + j > 0) {
                        if (p.fields[x + i - 1][y + j - 1] == 1) {
                            this.fields[x + i - 1][y + j - 1] = 2;
                            --i;
                            --j;
                        } else break;
                    }

                    i = 0;
                    j = 0;

                    while (!b.isItRequired && x + i < 7 && y + j > 0) {
                        if (p.fields[x + i + 1][y + j - 1] == 1) {
                            this.fields[x + i + 1][y + j - 1] = 2;
                            ++i;
                            --j;
                        } else break;
                    }

                    i = 0;
                    j = 0;

                    while (!b.isItRequired && x + i > 0 && y + j < 7) {
                        if (p.fields[x + i - 1][y + j + 1] == 1) {
                            this.fields[x + i - 1][y + j + 1] = 2;
                            --i;
                            ++j;
                        } else break;
                    }

                    i = 0;
                    j = 0;

                    while (!b.isItRequired && x + i < 7 && y + j < 7) {
                        if (p.fields[x + i + 1][y + j + 1] == 1) {
                            this.fields[x + i + 1][y + j + 1] = 2;
                            ++i;
                            ++j;
                        } else break;
                    }

                    boolean bij = false;
                    i = 0;
                    j = 0;

                    while (x + i > 0 && y + j > 0) {
                        if (p.fields[x + i - 1][y + j - 1] == 1) {
                            if (bij) this.fields[x + i - 1][y + j - 1] = 3;
                            --i;
                            --j;
                        } else if (p.fields[x + i - 1][y + j - 1] == 2 + add || p.fields[x + i - 1][y + j - 1] == 4 + add) {
                            if (!bij) {
                                bij = true;
                                --i;
                                --j;
                            } else break;
                        } else break;
                    }

                    bij = false;
                    i = 0;
                    j = 0;

                    while (x + i < 7 && y + j > 0) {
                        if (p.fields[x + i + 1][y + j - 1] == 1) {
                            if (bij) this.fields[x + i + 1][y + j - 1] = 3;
                            ++i;
                            --j;
                        } else if (p.fields[x + i + 1][y + j - 1] == 2 + add || p.fields[x + i + 1][y + j - 1] == 4 + add) {
                            if (!bij) {
                                bij = true;
                                ++i;
                                --j;
                            } else break;
                        } else break;
                    }

                    bij = false;
                    i = 0;
                    j = 0;

                    while (x + i > 0 && y + j < 7) {
                        if (p.fields[x + i - 1][y + j + 1] == 1) {
                            if (bij) this.fields[x + i - 1][y + j + 1] = 3;
                            --i;
                            ++j;
                        } else if (p.fields[x + i - 1][y + j + 1] == 2 + add || p.fields[x + i - 1][y + j + 1] == 4 + add) {
                            if (!bij) {
                                bij = true;
                                --i;
                                ++j;
                            } else break;
                        } else break;
                    }

                    bij = false;
                    i = 0;
                    j = 0;

                    while (x + i < 7 && y + j < 7) {
                        if (p.fields[x + i + 1][y + j + 1] == 1) {
                            if (bij) this.fields[x + i + 1][y + j + 1] = 3;
                            ++i;
                            ++j;
                        } else if (p.fields[x + i + 1][y + j + 1] == 2 + add || p.fields[x + i + 1][y + j + 1] == 4 + add) {
                            if (!bij) {
                                bij = true;
                                ++i;
                                ++j;
                            } else break;
                        } else break;
                    }
                }

                this.showFields();
            }

            oldX = x;
            oldY = y;
        }/*
        else if (this.fields[x][y] == 1)
		{
			this.clearFields();
		}*/ else if (this.fields[x][y] == 2) {
            p.fields[x][y] = p.fields[oldX][oldY];
            p.fields[oldX][oldY] = 1;
            this.clearFields();
            zamien_pionki_na_damki(p);
            this.zmiana_gracza();
        } else if (this.fields[x][y] == 3) {
            p.fields[x][y] = p.fields[oldX][oldY];
            int i = oldX;
            int j = oldY;
            int add_i = (oldX < x) ? 1 : -1;
            int add_j = (oldY < y) ? 1 : -1;
            int kill_x = i + add_i;
            int kill_y = j + add_j;
            while (kill_x != x && kill_y != y) {
                p.fields[kill_x][kill_y] = 1;
                kill_x += add_i;
                kill_y += add_j;
               logger.info("kiler : " + kill_x + " " + kill_y);
            }
            p.fields[oldX][oldY] = 1;
            this.clearFields();
            b.sprawdz_bicia(gracz, p, x, y);
            if (!b.isItRequired) {
                zamien_pionki_na_damki(p);
                this.zmiana_gracza();
            } else {
                klikniecie(x, y, p, b);
            }
        }

        b.sprawdz_bicia(gracz, p);
    }

    public void set_gracz(int gracz) {
        this.gracz = gracz;
        logger.info("Gracz " + this.gracz);
    }

    public int getPlayerNumber() {
        return this.gracz;
    }

    public void zmiana_gracza() {
        if (this.gracz == 1) {
            this.set_gracz(2);
        } else if (this.gracz == 2) {
            this.set_gracz(1);
        }
    }

    public void zamien_pionki_na_damki(Board p) {
        if (gracz == 1) {
            for (int i = 0; i < 8; i++)
                if (p.fields[i][0] == 2) p.fields[i][0] = 4;
        } else if (gracz == 2) {
            for (int i = 0; i < 8; i++)
                if (p.fields[i][7] == 3) p.fields[i][7] = 5;
        }
        p.showFields();
    }

}

