package entities;

public class Formiga {
    public int nome;
    public int colunaAtual = 0;
    public int linhaAtual = 0;
    public Matriz matriz;

    public Formiga(Matriz matriz) {
        this.matriz = matriz;
    }

    public void caminhar(int caminhoX, int caminhoY, Formigueiro formigueiro) {
        colunaAtual = formigueiro.j;
        linhaAtual = formigueiro.i;
        System.out.println(sobe(linhaAtual,colunaAtual));
        System.out.println(desce(linhaAtual,colunaAtual));
    }

    public boolean sobe(int caminhoX, int caminhoY) {
        if (caminhoX - 1 >= 0) {
            if (matriz.verifyCell(caminhoX - 1, caminhoY)) {
                linhaAtual = caminhoX-1;
                matriz.matriz[linhaAtual][caminhoY]=matriz.caminho;
                return true;
            }
        }
        return false;
    }

    public boolean desce(int caminhoX, int caminhoY) {
        if (caminhoX + 1 < matriz.getLinhas()) {
            if (matriz.verifyCell(caminhoX + 1, caminhoY)) {
                linhaAtual = caminhoX+1;
                matriz.matriz[linhaAtual][caminhoY]=matriz.caminho;
                return true;
            }
        }
        return false;
    }
}


//caminha para a direita
/*        for (int x = formigueiro.i; x < matriz.getLinhas(); x++) {
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
    }*/


/*

    0         1         2      3         4        5
0|   R    |        |        |        |        |        |
1|        |        |        |        |        |        |
2|        |   F    |        |   R    |        |        |
3|        |        |        |        |        |        |
4|        |        |        |        |        |        |

*/



