package entities;

public class Formigueiro {
    private int estoque = 0;
    private int estoqueMax = 10;
    private Matriz matriz;
    public int i = 0;
    public int j = 0;

    public Formigueiro(Matriz matriz) {
        this.matriz = matriz;
        i = matriz.getLinhas() / 2;
        j = matriz.getColunas() / 2;
        matriz.matriz[i][j] = matriz.formigueiro;
    }

    public void center(){

        matriz.matriz[i][j]=matriz.formigueiro;
    }

}
