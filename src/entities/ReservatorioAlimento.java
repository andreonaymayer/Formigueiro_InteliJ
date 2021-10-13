package entities;

import java.util.Random;

public class ReservatorioAlimento {
    public Matriz matriz;
    public int quantidadeNoMapa = 2;
    public int estoqueReservatorio = 3;
    public int alimentoCortado = 0;
    int[][] locals = new int[quantidadeNoMapa][3];
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
            locals[x][0] = i;
            locals[x][1] = j;
            locals[x][2] = estoqueReservatorio;
            if (matriz.verifyCell(i, j)) {
                matriz.defineCell(i, j, name);
            } else {
                x--;
            }
        }
    }

    public void definirPadrao(Matriz matriz){
        matriz.defineCell(0, 0, name);
        locals[0][0] = 0;
        locals[0][1] = 0;
        locals[0][2] = estoqueReservatorio;
        matriz.defineCell(4, 9, name);
        locals[1][0] = 4;
        locals[1][1] = 9;
        locals[1][2] = estoqueReservatorio;
    }
}

