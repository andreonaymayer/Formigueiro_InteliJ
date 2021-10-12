package entities;

import java.util.ArrayList;
import java.util.Random;

public class ReservatorioAlimento {
    public ArrayList locals = new ArrayList();
    public Matriz matriz;
    public int quantidadeNoMapa = 2;
    private int name;


    public ReservatorioAlimento(Matriz matriz) {
        this.matriz = matriz;
        this.name = matriz.reservatorio;
    }

    public void sorter(Matriz matriz) {
        for (int x = 0; x < quantidadeNoMapa; x++) {
            Random random = new Random();
            int i = random.nextInt(matriz.getLinhas()) + 0;
            int j = random.nextInt(matriz.getColunas()) + 0;
            ArrayList coordenadasETamanho = new ArrayList();
            coordenadasETamanho.add(i);
            coordenadasETamanho.add(j);
            coordenadasETamanho.add(3);
            this.locals.add(coordenadasETamanho);
            if (matriz.verifyCell(i, j)) {
                matriz.defineCell(i, j, name);
            } else {
                x--;
            }
        }
    }

    public void definirPadrao(Matriz matriz){
        matriz.defineCell(0, 0, name);
        matriz.defineCell(4, 5, name);
    }

    public ArrayList acessoLocal(int i, int j) {
        ArrayList retorno = new ArrayList();
        for (int x = 0; x < locals.size(); x++) {
            for (int i1 = 0; i1 < matriz.getLinhas(); i1++) {
                for (int j1 = 0; j1 < matriz.getLinhas(); j1++) {
                    if (i == i1 & j == j1) {
                        retorno.add(i1);
                        retorno.add(j1);
                    }
                }
            }
        }
        return retorno;
    }
}
