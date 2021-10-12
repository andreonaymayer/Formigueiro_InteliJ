package entities;

import java.util.List;

public class Formigueiro {
    private int estoque = 0;
    private int estoqueMax = 10;
    private Matriz matriz;
    public int i = 2;
    public int j = 1;

    public Formigueiro(Matriz matriz) {
        this.matriz = matriz;
    }

    public List<Integer> center() {

        matriz.matriz[i][j] = matriz.formigueiro;
        return List.of(i,j);
    }

}
