package com.company;

import entities.Formiga;
import entities.Formigueiro;
import entities.Matriz;
import entities.ReservatorioAlimento;


public class Main {

    public static void main(String[] args) {
        Matriz matriz = new Matriz();
        ReservatorioAlimento reservatorioAlimento = new ReservatorioAlimento(matriz);
        Formigueiro formigueiro = new Formigueiro(matriz);
        Formiga formiga = new Formiga(matriz,formigueiro);
        reservatorioAlimento.definirPadrao(matriz);
        formiga.irReservatorio(reservatorioAlimento);
        System.out.println(matriz.imprimeMatriz());
        System.out.println("________________________________________________________- fim");
    }
}
