package entities;

public class Formiga {
    public int nome;
    public int colunaAtual = 0;
    public int linhaAtual = 0;
    public Matriz matriz;

    public Formiga(Matriz matriz) {
        this.matriz = matriz;
    }

    public void caminhar(int enderecoX, int enderecoY, Formigueiro formigueiro) {
        this.colunaAtual = formigueiro.j;
        this.linhaAtual = formigueiro.i;
        enderecoX = 0;
        enderecoY = 0;
        int fim = 0;
        boolean subiuOuDesceu = false;


        //direita(linhaAtual,colunaAtual);
        while (fim == 0) {
            System.out.println("Atual (" + linhaAtual + "," + colunaAtual + ") | Destino (" + enderecoX + "," + enderecoY + ")");
            if (!subiuOuDesceu) {
                System.out.println("Subiu desceu falso");
                if (precisaSubir(enderecoX)) {
                    System.out.println("Subiu");
                    sobe(linhaAtual, colunaAtual);
                } else {
                    System.out.println("nao Subiu ");
                    if (precisaDescer(enderecoX)) {
                        System.out.println("desceu");
                        desce(linhaAtual, colunaAtual);
                    } else {
                        subiuOuDesceu = true;
                        System.out.println("terminou de descer ou subir");
                    }
                }
            }
            if (subiuOuDesceu) {
                if (precisaDireita(enderecoY)) {
                    direita(linhaAtual, colunaAtual);
                    System.out.println("Foi para a direita");

                } else {
                    if (precisaEsquerda(enderecoY)) {
                        System.out.println("Foi para a esquerda");
                        esquerda(linhaAtual, colunaAtual);
                    } else
                        fim = chegouNoDestino();
                }
            }
        }
        System.out.println(matriz.imprimeMatriz());
    }

    public int chegouNoDestino(){
        return 1;
    }

    public boolean atual(int destinoX, int destinoY) {
        boolean x = destinoX == this.linhaAtual;
        boolean y = destinoY == this.colunaAtual;
        return x & y;
    }

    public boolean precisaSubir(int destinoX) {
        return linhaAtual > destinoX;
    }

    public boolean precisaDescer(int destinoX) {
        return linhaAtual < destinoX;
    }

    public boolean precisaDireita(int destinoY) {
        return colunaAtual < destinoY;
    }

    public boolean precisaEsquerda(int destinoY) {
        return colunaAtual > destinoY;
    }

    public int sobe(int linhaAtual, int colunaAtual) {
        if (linhaAtual - 1 >= 0) {
            if (matriz.verifyCell(linhaAtual - 1, colunaAtual)) {
                this.linhaAtual = linhaAtual - 1;
                matriz.matriz[this.linhaAtual][colunaAtual] = matriz.caminho;
                return -1; // subiu
            }
            return matriz.verifyState(linhaAtual - 1, colunaAtual);
        }
        return 0; //não fez nada
    }

    public int desce(int linhaAtual, int colunaAtual) { //é o endereço atual como parametro
        if (linhaAtual + 1 < matriz.getLinhas()) {
            if (matriz.verifyCell(linhaAtual + 1, colunaAtual)) {
                this.linhaAtual = linhaAtual + 1;
                matriz.matriz[this.linhaAtual][colunaAtual] = matriz.caminho;
                return -1; //desceu
            }
            return matriz.verifyState(linhaAtual + 1, colunaAtual);
        }
        return 0; //nao fez nada
    }

    public int direita(int linhaAtual, int colunaAtual) {
        if (colunaAtual + 1 < matriz.getColunas()) {
            if (matriz.verifyCell(linhaAtual, colunaAtual + 1)) {
                this.colunaAtual = colunaAtual + 1;
                matriz.matriz[linhaAtual][this.colunaAtual] = matriz.caminho;
                return -1;
            }
            this.colunaAtual = colunaAtual + 1;
            return matriz.verifyState(linhaAtual, colunaAtual + 1);
        }
        return 0;
    }

    public int esquerda(int linhaAtual, int colunaAtual) {
        if (colunaAtual - 1 >= 0) {
            if (matriz.verifyCell(linhaAtual, colunaAtual - 1)) {
                this.colunaAtual = colunaAtual - 1;
                matriz.matriz[linhaAtual][this.colunaAtual] = matriz.caminho;
                return -1;
            }
            this.colunaAtual = colunaAtual - 1;
            return matriz.verifyState(linhaAtual, colunaAtual - 1);
        }
        return 0;
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



