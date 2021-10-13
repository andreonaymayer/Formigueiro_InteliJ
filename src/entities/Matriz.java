package entities;

public class Matriz {
    private int linhas = 5;
    private int colunas = 7;
    public int matriz[][] = new int[linhas][colunas];
    public int vazio = 1;
    public int formigueiro = 2;
    public int reservatorio = 3;
    public int obstaculo = 4;
    public int caminho = 5;
    public int formigaRastreadora = 6;
    public int formigaCortadora = 7;
    public int formigaTransportadora = 8;
    public int todasFormigasEReservatorio = 9;
    public int formigaRastreadoraEReservatorio = 10;
    public int formigaRastreadoraECortadoraEReservatorio = 11;
    public int formigaTransportadoraEAlimento = 12;
    public int formigaCortadoraEAlimento = 13;
    public int alimento = 14;

    public Matriz() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                this.matriz[i][j] = vazio;
            }
        }
    }

    public boolean verifyCell(int i, int j) {
        if (matriz[i][j] == vazio) {
            return true;
        } else
            return false;
    }

    public int verifyState(int i, int j){
        return matriz[i][j];
    }

    public boolean temObstaculo(int i, int j) {
        if (matriz[i][j] == obstaculo) {
            return true;
        } else
            return false;
    }

    public void defineCell(int i, int j, int valor) {
        this.matriz[i][j] = valor;
    }

    public String imprimeMatriz() {
        String legenda = "R = Reservatorio | - = Obstaculo | F = Formigueiro | # = Caminho " +
                "| Y = Formiga Rastreadora | W = Formiga Cortadora | T = Formiga transportadora | A = Alimento" + "\n";
        String textReturn = "";
        for (int i = 0; i < linhas; i++) {
            textReturn += "|";
            for (int j = 0; j < colunas; j++) {
                switch (matriz[i][j]) {
                    case 1: //vazio
                        textReturn += "        ";
                        break;
                    case 2: //formigueiro
                        textReturn += "   F    ";
                        break;
                    case 3: //reservatorio
                        textReturn += " R      ";
                        break;
                    case 4: //obstaculo
                        textReturn += "   -    ";
                        break;
                    case 5: //caminho
                        textReturn += "   #    ";
                        break;
                    case 6: //Formiga Rastreadora
                        textReturn += "   Y    ";
                        break;
                    case 7: //Formiga Cortadora
                        textReturn += "   W    ";
                        break;
                    case 8: //Formiga Transportadora
                        textReturn += "   T    ";
                        break;
                    case 9: //TodasAsFormigas
                        textReturn += "R W T Y ";
                        break;
                    case 10: //formiga rastreadora e reservatorio
                        textReturn += "  R Y   ";
                        break;
                    case 11: //rastreadora, cortadora e reservatorio
                        textReturn += " R Y W  ";
                        break;
                    case 12: //formiga transportadora e alimento
                        textReturn += "   T A  ";
                        break;
                    case 13: //Formiga cortadora e alimento
                        textReturn += "   W A  ";
                        break;
                }
                textReturn += "|";
            }
            textReturn += "\n";
        }
        return legenda + textReturn;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
}
