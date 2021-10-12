package com.company;

import entities.Formiga;
import entities.Formigueiro;
import entities.Matriz;
import entities.Obstaculos;
import entities.ReservatorioAlimento;

public class Main {

    public static void main(String[] args) {
        Matriz matriz = new Matriz();
        ReservatorioAlimento reservatorioAlimento = new ReservatorioAlimento(matriz);
        //Obstaculos obstaculos = new Obstaculos();
        Formigueiro formigueiro = new Formigueiro(matriz);
        Formiga formiga = new Formiga();

        formigueiro.center();
        reservatorioAlimento.definirPadrao(matriz);
        //obstaculos.definirPadrao(matriz);


        System.out.println(matriz.imprimeMatriz());
        System.out.println("________________________________________________________- fim");
        formiga.caminhar(0,5,formigueiro,matriz);
        System.out.println(matriz.imprimeMatriz());
        System.out.println("________________________________________________________- fim");

    }
}
