package com.ninjaapps.checkers.view.game.old;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Pawns implements Serializable {
    //1 kolor jasny
    //2 kolor ciemny
    //3 damka jasna
    //4 damka ciemna
    //5 bicie jasny
    //6 bicie ciemny
    public int[][] rozstawienie;
    public int poprzedniKolor;
    public int poprzedniX;
    public int poprzedniY;
    static boolean jasny = true;
    static boolean ciemny = false;
    public boolean kolejka = true;
    //1 pionek z
    public int[][] mozliweBicia = new int[8][8];

    public Pawns() {
        UstawPionki();
    }

    public void UstawPionki() {
        for (int i = 0; i < mozliweBicia.length; i++) {
            for (int j = 0; j < mozliweBicia.length; j++) {
                mozliweBicia[i][j] = 0;
            }
        }
        rozstawienie = new int[8][8];
        for (int i = 0; i < rozstawienie.length; i++) {
            for (int j = 0; j < rozstawienie.length; j++) {
                if (j < 3) {
                    if ((i + j) % 2 == 1)
                        rozstawienie[i][j] = 2;
                    else
                        rozstawienie[i][j] = 0;
                } else if (j > 4) {
                    if ((i + j) % 2 == 1)
                        rozstawienie[i][j] = 1;
                    else
                        rozstawienie[i][j] = 0;
                }
            }
        }
    }

    public void Ruch(int x, int y, boolean kolor) {
        rozstawienie[x][y] = poprzedniKolor;
        rozstawienie[poprzedniX][poprzedniY] = 0;
        if (kolor == jasny && y == 0)
            rozstawienie[x][y] = 3;
        else if (kolor == ciemny && y == 7)
            rozstawienie[x][y] = 4;

    }

    public boolean SprawdzRuch(int x, int y, boolean kolor) {
        if (kolor == jasny) {
            if (rozstawienie[poprzedniX][poprzedniY] == 1) {
                if (rozstawienie[x][y] == 0 && ((poprzedniX == x + 1 || poprzedniX == x - 1) && poprzedniY == y + 1))
                    return true;
                    //else if(rozstawienie[x+1][y+1]==)
                else
                    return false;
            } else {
                if (rozstawienie[x][y] == 0) {
                    int roznica = poprzedniX - x;
                    if (poprzedniY - y == roznica || poprzedniY - y == -roznica)
                        return true;
                    else
                        return false;
                } else
                    return false;
            }
        } else {
            if (rozstawienie[poprzedniX][poprzedniY] == 2) {
                if (rozstawienie[x][y] == 0 && ((poprzedniX == x + 1 || poprzedniX == x - 1) && poprzedniY == y - 1))
                    return true;
                else
                    return false;
            } else {
                if (rozstawienie[x][y] == 0) {
                    int roznica = poprzedniX - x;
                    if (poprzedniY - y == roznica || poprzedniY - y == -roznica)
                        return true;
                    else
                        return false;
                } else
                    return false;
            }
        }
    }

    public boolean SprawdzBicia(boolean kolor) {
        if (kolor == jasny) {
            boolean bicie = false;
            for (int i = 0; i < rozstawienie.length; i++) {
                for (int j = 0; j < rozstawienie.length; j++) {
//                    if(rozstawienie[i][j]==1 && (rozstawienie[i+1][j+1]==2 || rozstawienie[i+1][j-1]==2
//                            || rozstawienie[i-1][j+1]==2 || rozstawienie[i-1][j-1]==2))
//                        bicie = true;
                    //kolor jasny
                    //bicia pionków
                    if (rozstawienie[i][j] == 1) {
                        if (i > 1 && j > 1 && i < 6 && j < 6) {
                            if ((rozstawienie[i + 1][j + 1] == 2 || rozstawienie[i + 1][j + 1] == 4) && rozstawienie[i + 2][j + 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i + 1][j - 1] == 2 || rozstawienie[i + 1][j - 1] == 4) && rozstawienie[i + 2][j - 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i - 1][j + 1] == 2 || rozstawienie[i - 1][j + 1] == 4) && rozstawienie[i - 2][j + 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i - 1][j - 1] == 2 || rozstawienie[i - 1][j - 1] == 4) && rozstawienie[i - 2][j - 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 0 || i == 1) && j > 1 && j < 6) {
                            if ((rozstawienie[i + 1][j + 1] == 2 || rozstawienie[i + 1][j + 1] == 4) && rozstawienie[i + 2][j + 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i + 1][j - 1] == 2 || rozstawienie[i + 1][j - 1] == 4) && rozstawienie[i + 2][j - 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 6 || i == 7) && j > 1 && j < 6) {
                            if ((rozstawienie[i - 1][j - 1] == 2 || rozstawienie[i - 1][j - 1] == 4) && rozstawienie[i - 2][j - 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i - 1][j + 1] == 2 || rozstawienie[i - 1][j + 1] == 4) && rozstawienie[i - 2][j + 2] == 0) {
                                bicie = true;
                            }
                        } else if ((j == 0 || j == 1) && i > 1 && i < 6) {
                            if ((rozstawienie[i - 1][j + 1] == 2 || rozstawienie[i - 1][j + 1] == 4) && rozstawienie[i - 2][j + 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i + 1][j + 1] == 2 || rozstawienie[i + 1][j + 1] == 4) && rozstawienie[i + 2][j + 2] == 0) {
                                bicie = true;
                            }

                        } else if ((j == 6 || j == 7) && i > 1 && i < 6) {
                            if ((rozstawienie[i - 1][j - 1] == 2 || rozstawienie[i - 1][j - 1] == 4) && rozstawienie[i - 2][j - 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i + 1][j - 1] == 2 || rozstawienie[i + 1][j - 1] == 4) && rozstawienie[i + 2][j - 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 0 || i == 1) && (j == 0 || j == 1)) {
                            if ((rozstawienie[i + 1][j + 1] == 2 || rozstawienie[i + 1][j + 1] == 4) && rozstawienie[i + 2][j + 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 6 || i == 7) && (j == 0 || j == 1)) {
                            if ((rozstawienie[i - 1][j + 1] == 2 || rozstawienie[i - 1][j + 1] == 4) && rozstawienie[i - 2][j + 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 0 || i == 1) && (j == 6 || j == 7)) {
                            if ((rozstawienie[i + 1][j - 1] == 2 || rozstawienie[i + 1][j - 1] == 4) && rozstawienie[i + 2][j - 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 6 || i == 7) && (j == 6 || j == 7)) {
                            if ((rozstawienie[i - 1][j - 1] == 2 || rozstawienie[i - 1][j - 1] == 4) && rozstawienie[i - 2][j - 2] == 0) {
                                bicie = true;
                            }
                        }
                    }
                    //bicia damek
                }

            }
            return bicie;

        } else {
            boolean bicie = false;
            for (int i = 0; i < rozstawienie.length; i++) {
                for (int j = 0; j < rozstawienie.length; j++) {
//                    if(rozstawienie[i][j]==1 && (rozstawienie[i+1][j+1]==2 || rozstawienie[i+1][j-1]==2
//                            || rozstawienie[i-1][j+1]==2 || rozstawienie[i-1][j-1]==2))
//                        bicie = true;
                    if (rozstawienie[i][j] == 2) {
                        if (i > 1 && j > 1 && i < 6 && j < 6) {
                            if ((rozstawienie[i + 1][j + 1] == 1 || rozstawienie[i + 1][j + 1] == 3) && rozstawienie[i + 2][j + 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i + 1][j - 1] == 1 || rozstawienie[i + 1][j - 1] == 3) && rozstawienie[i + 2][j - 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i - 1][j + 1] == 1 || rozstawienie[i - 1][j + 1] == 3) && rozstawienie[i - 2][j + 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i - 1][j - 1] == 1 || rozstawienie[i - 1][j - 1] == 3) && rozstawienie[i - 2][j - 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 0 || i == 1) && j > 1 && j < 6) {
                            //System.out.print("i = " + i);
                            if ((rozstawienie[i + 1][j + 1] == 1 || rozstawienie[i + 1][j + 1] == 3) && rozstawienie[i + 2][j + 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i + 1][j - 1] == 1 || rozstawienie[i + 1][j - 1] == 3) && rozstawienie[i + 2][j - 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 6 || i == 7) && j > 1 && j < 6) {
                            //System.out.print("i = " + i);
                            if ((rozstawienie[i - 1][j - 1] == 1 || rozstawienie[i - 1][j - 1] == 3) && rozstawienie[i - 2][j - 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i - 1][j + 1] == 1 || rozstawienie[i - 1][j + 1] == 3) && rozstawienie[i - 2][j + 2] == 0) {
                                bicie = true;
                            }
                        } else if ((j == 0 || j == 1) && i > 1 && i < 6) {
                            if ((rozstawienie[i - 1][j + 1] == 1 || rozstawienie[i - 1][j + 1] == 3) && rozstawienie[i - 2][j + 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i + 1][j + 1] == 1 || rozstawienie[i + 1][j + 1] == 3) && rozstawienie[i + 2][j + 2] == 0) {
                                bicie = true;
                            }

                        } else if ((j == 6 || j == 7) && i > 1 && i < 6) {
                            if ((rozstawienie[i - 1][j - 1] == 1 || rozstawienie[i - 1][j - 1] == 3) && rozstawienie[i - 2][j - 2] == 0) {
                                bicie = true;
                            } else if ((rozstawienie[i + 1][j - 1] == 1 || rozstawienie[i + 1][j - 1] == 3) && rozstawienie[i + 2][j - 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 0 || i == 1) && (j == 0 || j == 1)) {
                            if ((rozstawienie[i + 1][j + 1] == 1 || rozstawienie[i + 1][j + 1] == 3) && rozstawienie[i + 2][j + 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 6 || i == 7) && (j == 0 || j == 1)) {
                            if ((rozstawienie[i - 1][j + 1] == 1 || rozstawienie[i - 1][j + 1] == 3) && rozstawienie[i - 2][j + 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 0 || i == 1) && (j == 6 || j == 7)) {
                            if ((rozstawienie[i + 1][j - 1] == 1 || rozstawienie[i + 1][j - 1] == 3) && rozstawienie[i + 2][j - 2] == 0) {
                                bicie = true;
                            }
                        } else if ((i == 6 || i == 7) && (j == 6 || j == 7)) {
                            if ((rozstawienie[i - 1][j - 1] == 1 || rozstawienie[i - 1][j - 1] == 3) && rozstawienie[i - 2][j - 2] == 0) {
                                bicie = true;
                            }
                        }
                    }
                }
            }
            return bicie;
        }
    }

    public boolean Bicie(int x, int y, boolean kolor) {
        for (int i = 0; i < mozliweBicia.length; i++) {
            for (int j = 0; j < mozliweBicia.length; j++) {
                mozliweBicia[i][j] = 0;

            }

        }
        boolean bicie = false;

        if (kolor == jasny) {
            if (rozstawienie[x][y] == 1) {
                if (x > 1 && x < 6 && y > 1 && y < 6) {
                    if ((rozstawienie[x + 1][y + 1] == 2 || rozstawienie[x + 1][y + 1] == 4) && rozstawienie[x + 2][y + 2] == 0) {
                        mozliweBicia[x + 2][y + 2] = 1;
                        bicie = true;
                    } else if ((rozstawienie[x + 1][y - 1] == 2 || rozstawienie[x + 1][y - 1] == 4) && rozstawienie[x + 2][y - 2] == 0) {
                        mozliweBicia[x + 2][y - 2] = 1;
                        bicie = true;
                    } else if ((rozstawienie[x - 1][y + 1] == 2 || rozstawienie[x - 1][y + 1] == 4) && rozstawienie[x - 2][y + 2] == 0) {
                        mozliweBicia[x - 2][y + 2] = 1;
                        bicie = true;
                    } else if ((rozstawienie[x - 1][y - 1] == 2 || rozstawienie[x - 1][y - 1] == 4) && rozstawienie[x - 2][y - 2] == 0) {
                        mozliweBicia[x - 2][y - 2] = 1;
                        bicie = true;
                    }
                }
                //sytuacje brzegowe
                else if ((x == 0 || x == 1) && y > 1 && y < 6) {
                    if ((rozstawienie[x + 1][y + 1] == 2 || rozstawienie[x + 1][y + 1] == 4) && rozstawienie[x + 2][y + 2] == 0) {
                        mozliweBicia[x + 2][y + 2] = 1;
                        bicie = true;
                    } else if ((rozstawienie[x + 1][y - 1] == 2 || rozstawienie[x + 1][y - 1] == 4) && rozstawienie[x + 2][y - 2] == 0) {
                        mozliweBicia[x + 2][y - 2] = 1;
                        bicie = true;
                    }
                } else if ((x == 6 || x == 7) && y > 1 && y < 6) {
                    //System.out.print("i = " + i);
                    if ((rozstawienie[x - 1][y - 1] == 2 || rozstawienie[x - 1][y - 1] == 4) && rozstawienie[x - 2][y - 2] == 0) {
                        mozliweBicia[x - 2][y - 2] = 1;
                        bicie = true;
                    } else if ((rozstawienie[x - 1][y + 1] == 2 || rozstawienie[x - 1][y + 1] == 4) && rozstawienie[x - 2][y + 2] == 0) {
                        mozliweBicia[x - 2][y + 2] = 1;
                        bicie = true;
                    }
                } else if ((y == 0 || y == 1) && x > 1 && x < 6) {
                    if ((rozstawienie[x - 1][y + 1] == 2 || rozstawienie[x - 1][y + 1] == 4) && rozstawienie[x - 2][y + 2] == 0) {
                        mozliweBicia[x - 2][y + 2] = 1;
                        bicie = true;
                    } else if ((rozstawienie[x + 1][y + 1] == 2 || rozstawienie[x + 1][y + 1] == 4) && rozstawienie[x + 2][y + 2] == 0) {
                        mozliweBicia[x + 2][y + 2] = 1;
                        bicie = true;
                    }

                } else if ((y == 6 || y == 7) && x > 1 && x < 6) {
                    if ((rozstawienie[x - 1][y - 1] == 2 || rozstawienie[x - 1][y - 1] == 4) && rozstawienie[x - 2][y - 2] == 0) {
                        mozliweBicia[x - 2][y - 2] = 1;
                        bicie = true;
                    } else if ((rozstawienie[x + 1][y - 1] == 2 || rozstawienie[x + 1][y - 1] == 4) && rozstawienie[x + 2][y - 2] == 0) {
                        mozliweBicia[x + 2][y - 2] = 1;
                        bicie = true;
                    }
                }
                //nowy kod
                else if ((x == 0 || x == 1) && (y == 0 || y == 1)) {
                    if ((rozstawienie[x + 1][y + 1] == 2 || rozstawienie[x + 1][y + 1] == 4) && rozstawienie[x + 2][y + 2] == 0) {
                        mozliweBicia[x + 2][y + 2] = 1;
                        bicie = true;
                    }
                } else if ((x == 6 || x == 7) && (y == 0 || y == 1)) {
                    if ((rozstawienie[x - 1][y + 1] == 2 || rozstawienie[x - 1][y + 1] == 4) && rozstawienie[x - 2][y + 2] == 0) {
                        mozliweBicia[x - 2][y + 2] = 1;
                        bicie = true;
                    }
                } else if ((x == 0 || x == 1) && (y == 6 || y == 7)) {
                    if ((rozstawienie[x + 1][y - 1] == 2 || rozstawienie[x + 1][y - 1] == 4) && rozstawienie[x + 2][y - 2] == 0) {
                        mozliweBicia[x + 2][y - 2] = 1;
                        bicie = true;
                    }
                } else if ((x == 6 || x == 7) && (y == 6 || y == 7)) {
                    if ((rozstawienie[x - 1][y - 1] == 2 || rozstawienie[x - 1][y - 1] == 4) && rozstawienie[x - 2][y - 2] == 0) {
                        mozliweBicia[x - 2][y - 2] = 1;
                        bicie = true;
                    }
                }
            }
        } else {
            if (rozstawienie[x][y] == 2) {
                if (x > 1 && x < 6 && y > 1 && y < 6) {
                    if ((rozstawienie[x + 1][y + 1] == 1 || rozstawienie[x + 1][y + 1] == 3) && rozstawienie[x + 2][y + 2] == 0) {
                        mozliweBicia[x + 2][y + 2] = 2;
                        bicie = true;
                    } else if ((rozstawienie[x + 1][y - 1] == 1 || rozstawienie[x + 1][y - 1] == 3) && rozstawienie[x + 2][y - 2] == 0) {
                        mozliweBicia[x + 2][y - 2] = 2;
                        bicie = true;
                    } else if ((rozstawienie[x - 1][y + 1] == 1 || rozstawienie[x - 1][y + 1] == 3) && rozstawienie[x - 2][y + 2] == 0) {
                        mozliweBicia[x - 2][y + 2] = 2;
                        bicie = true;
                    } else if ((rozstawienie[x - 1][y - 1] == 1 || rozstawienie[x - 1][y - 1] == 3) && rozstawienie[x - 2][y - 2] == 0) {
                        mozliweBicia[x - 2][y - 2] = 2;
                        bicie = true;
                    }

                }
                //nowy kod
                else if ((x == 0 || x == 1) && y > 1 && y < 6) {
                    if ((rozstawienie[x + 1][y + 1] == 1 || rozstawienie[x + 1][y + 1] == 3) && rozstawienie[x + 2][y + 2] == 0) {
                        mozliweBicia[x + 2][y + 2] = 2;
                        bicie = true;
                    } else if ((rozstawienie[x + 1][y - 1] == 1 || rozstawienie[x + 1][y - 1] == 3) && rozstawienie[x + 2][y - 2] == 0) {
                        mozliweBicia[x + 2][y - 2] = 2;
                        bicie = true;
                    }
                } else if ((x == 6 || x == 7) && y > 1 && y < 6) {
                    //System.out.print("i = " + i);
                    if ((rozstawienie[x - 1][y - 1] == 1 || rozstawienie[x - 1][y - 1] == 3) && rozstawienie[x - 2][y - 2] == 0) {
                        mozliweBicia[x - 2][y - 2] = 2;
                        bicie = true;
                    } else if ((rozstawienie[x - 1][y + 1] == 1 || rozstawienie[x - 1][y + 1] == 3) && rozstawienie[x - 2][y + 2] == 0) {
                        mozliweBicia[x - 2][y + 2] = 2;
                        bicie = true;
                    }
                } else if ((y == 0 || y == 1) && x > 1 && x < 6) {
                    if ((rozstawienie[x - 1][y + 1] == 1 || rozstawienie[x - 1][y + 1] == 3) && rozstawienie[x - 2][y + 2] == 0) {
                        mozliweBicia[x - 2][y + 2] = 2;
                        bicie = true;
                    } else if ((rozstawienie[x + 1][y + 1] == 1 || rozstawienie[x + 1][y + 1] == 3) && rozstawienie[x + 2][y + 2] == 0) {
                        mozliweBicia[x + 2][y + 2] = 2;
                        bicie = true;
                    }

                } else if ((y == 6 || y == 7) && x > 1 && x < 6) {
                    if ((rozstawienie[x - 1][y - 1] == 1 || rozstawienie[x - 1][y - 1] == 3) && rozstawienie[x - 2][y - 2] == 0) {
                        mozliweBicia[x - 2][y - 2] = 2;
                        bicie = true;
                    } else if ((rozstawienie[x + 1][y - 1] == 1 || rozstawienie[x + 1][y - 1] == 3) && rozstawienie[x + 2][y - 2] == 0) {
                        mozliweBicia[x + 2][y - 2] = 2;
                        bicie = true;
                    }
                }
                //nowy kod
                else if ((x == 0 || x == 1) && (y == 0 || y == 1)) {
                    if ((rozstawienie[x + 1][y + 1] == 1 || rozstawienie[x + 1][y + 1] == 3) && rozstawienie[x + 2][y + 2] == 0) {
                        mozliweBicia[x + 2][y + 2] = 2;
                        bicie = true;
                    }
                } else if ((x == 6 || x == 7) && (y == 0 || y == 1)) {
                    if ((rozstawienie[x - 1][y + 1] == 1 || rozstawienie[x - 1][y + 1] == 3) && rozstawienie[x - 2][y + 2] == 0) {
                        mozliweBicia[x - 2][y + 2] = 2;
                        bicie = true;
                    }
                } else if ((x == 0 || x == 1) && (y == 6 || y == 7)) {
                    if ((rozstawienie[x + 1][y - 1] == 1 || rozstawienie[x + 1][y - 1] == 3) && rozstawienie[x + 2][y - 2] == 0) {
                        mozliweBicia[x + 2][y - 2] = 2;
                        bicie = true;
                    }
                } else if ((x == 6 || x == 7) && (y == 6 || y == 7)) {
                    if ((rozstawienie[x - 1][y - 1] == 1 || rozstawienie[x - 1][y - 1] == 3) && rozstawienie[x - 2][y - 2] == 0) {
                        mozliweBicia[x - 2][y - 2] = 2;
                        bicie = true;
                    }
                }
            }
        }
        return bicie;
    }

    public void Zbij(int x, int y, boolean kolejka) {
        if (kolejka == jasny) {
            if (mozliweBicia[x][y] == 1) {
                if (poprzedniX > x && poprzedniY > y) {
                    rozstawienie[x + 1][y + 1] = 0;
                    rozstawienie[poprzedniX][poprzedniY] = 0;
                    rozstawienie[x][y] = 1;
                } else if (poprzedniX > x && poprzedniY < y) {
                    rozstawienie[x + 1][y - 1] = 0;
                    rozstawienie[poprzedniX][poprzedniY] = 0;
                    rozstawienie[x][y] = 1;
                } else if (poprzedniX < x && poprzedniY > y) {
                    rozstawienie[x - 1][y + 1] = 0;
                    rozstawienie[poprzedniX][poprzedniY] = 0;
                    rozstawienie[x][y] = 1;
                } else if (poprzedniX < x && poprzedniY < y) {
                    rozstawienie[x - 1][y - 1] = 0;
                    rozstawienie[poprzedniX][poprzedniY] = 0;
                    rozstawienie[x][y] = 1;
                }
                if (kolejka == jasny && y == 0)
                    rozstawienie[x][y] = 3;
                else if (kolejka == ciemny && y == 7)
                    rozstawienie[x][y] = 4;
            }
        } else {
            if (mozliweBicia[x][y] == 2) {
                if (poprzedniX > x && poprzedniY > y) {
                    rozstawienie[x + 1][y + 1] = 0;
                    rozstawienie[poprzedniX][poprzedniY] = 0;
                    rozstawienie[x][y] = 2;
                } else if (poprzedniX > x && poprzedniY < y) {
                    rozstawienie[x + 1][y - 1] = 0;
                    rozstawienie[poprzedniX][poprzedniY] = 0;
                    rozstawienie[x][y] = 2;
                } else if (poprzedniX < x && poprzedniY > y) {
                    rozstawienie[x - 1][y + 1] = 0;
                    rozstawienie[poprzedniX][poprzedniY] = 0;
                    rozstawienie[x][y] = 2;
                } else if (poprzedniX < x && poprzedniY < y) {
                    rozstawienie[x - 1][y - 1] = 0;
                    rozstawienie[poprzedniX][poprzedniY] = 0;
                    rozstawienie[x][y] = 2;
                }
                if (kolejka == jasny && y == 0)
                    rozstawienie[x][y] = 3;
                else if (kolejka == ciemny && y == 7)
                    rozstawienie[x][y] = 4;
            }
        }
    }
}
