package entities;

public class Formiga {
    public int nome;
    public Formigueiro formigueiro;
    public int colunaAtual = 0;
    public int linhaAtual = 0;
    public int colunaAnterior;
    public int linhaAnterior;
    public Matriz matriz;


    public Formiga(Matriz matriz, Formigueiro formigueiro) {
        this.matriz = matriz;
        this.formigueiro = formigueiro;
        this.colunaAtual = formigueiro.j;
        this.linhaAtual = formigueiro.i;
        this.colunaAnterior = formigueiro.j;
        this.linhaAnterior = formigueiro.i;
    }

    public void irReservatorio(ReservatorioAlimento reservatorioAlimento) {
        //for (int i=0; i < reservatorioAlimento.quantidadeNoMapa; i++) {
        int i = 0;
        caminhar(reservatorioAlimento.locals[i][0], reservatorioAlimento.locals[i][1], matriz.formigaRastreadora);
        i = 1;
        caminhar(reservatorioAlimento.locals[i][0], reservatorioAlimento.locals[i][1], matriz.formigaRastreadora);
    }

    public void caminhar(int enderecoX, int enderecoY, int qualFormiga) {
        int fim = 0;
        boolean subiuOuDesceu = false;
        int counter = 0;

        while (fim == 0) {
            System.out.println("Counter: "+counter+" | Atual (" + linhaAtual + "," + colunaAtual + ") | Destino (" + enderecoX + "," + enderecoY + ")"+" | Anterior (" + linhaAnterior + "," + colunaAnterior + ")");
            if (!subiuOuDesceu) {
                if (precisaSubir(enderecoX)) {
                    sobe(linhaAtual, colunaAtual, qualFormiga);
                    rastro();
                } else {
                    if (precisaDescer(enderecoX)) {
                        desce(linhaAtual, colunaAtual, qualFormiga);
                        rastro();
                    } else {
                        subiuOuDesceu = true;
                        System.out.println("terminou de descer ou subir");
                    }
                }
            }
            if (subiuOuDesceu) {
                if (precisaDireita(enderecoY)) {
                    direita(linhaAtual, colunaAtual,qualFormiga);
                    rastro();
                } else {
                    if (precisaEsquerda(enderecoY)) {
                        esquerda(linhaAtual, colunaAtual, qualFormiga);
                        rastro();
                    } else{
                        fim = chegouNoDestino(qualFormiga,enderecoY);
                    }
                }
            }
            System.out.println(matriz.imprimeMatriz());
            counter++;
        }
    }

    public int chegouNoDestino(int qualFormiga,int destinoY) {
        if((colunaAtual == destinoY)&(colunaAnterior - 1 >=0)){
            this.colunaAnterior--;
            rastro();
        }
        if((colunaAtual == destinoY)&(colunaAnterior + 1 < matriz.getColunas())){
            this.colunaAnterior++;
            rastro();
            this.colunaAnterior++;
            rastro();
        }
        formigaReservatorio(qualFormiga);
        colunaAtual = formigueiro.j;
        linhaAtual = formigueiro.i;
        return 1;
    }

    public void formigaReservatorio(int qualFormiga) {
        if (qualFormiga == matriz.formigaRastreadora) {
            matriz.matriz[linhaAtual][colunaAtual] = matriz.formigaRastreadoraEReservatorio;
        }
        if (qualFormiga == matriz.formigaCortadora) {
            matriz.matriz[linhaAtual][colunaAtual] = matriz.formigaRastreadoraECortadoraEReservatorio;
        }
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

    public int sobe(int linhaAtual, int colunaAtual, int qualFormiga) {
        if (linhaAtual - 1 >= 0) {
            if (matriz.verifyCell(linhaAtual - 1, colunaAtual)) {
                this.linhaAnterior = linhaAtual;
                this.colunaAnterior = colunaAtual;
                this.linhaAtual = linhaAtual - 1;
                matriz.matriz[this.linhaAtual][colunaAtual] = qualFormiga;
                return -1; // subiu
            }
            return matriz.verifyState(linhaAtual - 1, colunaAtual);
        }
        return 0; //não fez nada
    }

    public int desce(int linhaAtual, int colunaAtual, int qualFormiga) { //é o endereço atual como parametro
        if (linhaAtual + 1 < matriz.getLinhas()) {
            if (matriz.verifyCell(linhaAtual + 1, colunaAtual)) {
                this.linhaAnterior = linhaAtual;
                this.colunaAnterior = colunaAtual;
                this.linhaAtual = linhaAtual + 1;
                if(matriz.verifyState(linhaAnterior,colunaAtual)!=matriz.formigueiro){ // colocar os outros tipos que n podem ser sobrepostos
                    matriz.matriz[linhaAnterior][colunaAnterior] = matriz.caminho;
                }
                matriz.matriz[this.linhaAtual][colunaAtual] = qualFormiga;
                return -1; //desceu
            }
            return matriz.verifyState(linhaAtual + 1, colunaAtual);
        }
        return 0; //nao fez nada
    }

    public int direita(int linhaAtual, int colunaAtual, int qualFormiga) {
        if (colunaAtual + 1 < matriz.getColunas()) {
            if (matriz.verifyCell(linhaAtual, colunaAtual + 1)) {
                this.linhaAnterior = linhaAtual;
                this.colunaAnterior = colunaAtual;
                this.colunaAtual = colunaAtual + 1;
                if(matriz.verifyState(linhaAnterior,colunaAnterior)==qualFormiga){ // colocar os outros tipos que n podem ser sobrepostos
                    matriz.matriz[linhaAnterior][colunaAnterior] = matriz.caminho;
                }
                matriz.matriz[linhaAtual][this.colunaAtual] = qualFormiga;
                return -1;
            }
            this.colunaAtual = colunaAtual + 1;
            return matriz.verifyState(linhaAtual, colunaAtual + 1);
        }
        return 0;
    }

    public void rastro() {
        boolean naoOcupaOFormigueiro = !(formigueiro.i == this.linhaAnterior) & !(formigueiro.j == this.linhaAnterior);
        if (naoOcupaOFormigueiro) {
            matriz.matriz[this.linhaAnterior][this.colunaAnterior] = matriz.caminho;
        }
    }



    public int esquerda(int linhaAtual, int colunaAtual, int qualFormiga) {
        if (colunaAtual - 1 >= 0) {
            if (matriz.verifyCell(linhaAtual, colunaAtual - 1)) {
                this.linhaAnterior = linhaAtual;
                this.colunaAnterior = colunaAtual;
                this.colunaAtual = colunaAtual - 1;
                matriz.matriz[linhaAtual][this.colunaAtual] = qualFormiga;
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