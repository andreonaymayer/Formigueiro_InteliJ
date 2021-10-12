package entities;

public class Formiga {
    public int nome;
    int colunaAtual = 0;
    int linhaAtual = 0;

    public void caminhar(int i, int j, Formigueiro formigueiro, Matriz matriz) {
        int linha = formigueiro.i - i;
        int coluna = formigueiro.j - j;


//caminha para a direita
        for (int x = formigueiro.i; x < matriz.getLinhas(); x++) {
            boolean caminhouLinha = false;
            for (int y = formigueiro.j; y < j; y++) {
                if (matriz.matriz[x][y] == 1) {
                    matriz.defineCell(x, y, matriz.caminho);
                    colunaAtual = y;
                    linhaAtual = x;
                    caminhouLinha = true;
                }
                if (matriz.matriz[x][y] == 3) {
                    matriz.matriz[x][y] = 10;
                    return;
                }
            }
            if (caminhouLinha) {

                desce(matriz);
                return;
            }
        }
    }

    void desce (Matriz matriz){
        for (int i = linhaAtual; i < matriz.getLinhas(); i++){
            if (matriz.matriz[i][colunaAtual] == 1) {
                matriz.defineCell(i, colunaAtual, matriz.caminho);
            }
            if (matriz.matriz[i][colunaAtual] == 3) {
                matriz.matriz[i][colunaAtual] = 10;
                return;
            }
        }
    }

}

/*

    0         1         2      3         4        5
0|   R    |        |        |        |        |        |
1|        |        |        |        |        |        |
2|        |   F    |        |   R    |        |        |
3|        |        |        |        |        |        |
4|        |        |        |        |        |        |

*/



