package com.company;

import entities.Formiga;
import entities.Formigueiro;
import entities.Matriz;
import entities.ReservatorioAlimento;

public class Main {

    public static void main(String[] args) {
        Matriz matriz = new Matriz();
        ReservatorioAlimento reservatorioAlimento = new ReservatorioAlimento(matriz);
        Formiga formiga = new Formiga(matriz);
        Formigueiro formigueiro = new Formigueiro(matriz);
        reservatorioAlimento.definirPadrao(matriz);

        System.out.println(matriz.imprimeMatriz());
        System.out.println("________________________________________________________- fim");
        formiga.caminhar(0,5,formigueiro);
        System.out.println(matriz.imprimeMatriz());
        System.out.println("________________________________________________________- fim");

    }
}
