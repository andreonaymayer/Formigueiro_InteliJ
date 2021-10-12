package entities;

import java.util.ArrayList;

public class FormigaRastreadora{
    private ArrayList rotasEncontradas = new ArrayList();
    private Matriz matriz;
    private ReservatorioAlimento reservatorioAlimento;
    public int i;
    public int j;


    public FormigaRastreadora(Matriz matriz, ReservatorioAlimento reservatorioAlimento) {
        this.matriz = matriz;
        this.reservatorioAlimento = reservatorioAlimento;
    }

}
