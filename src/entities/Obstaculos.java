package entities;

import java.util.Random;

public class Obstaculos {

    public void sorter(Matriz matriz) {
        for (int x = 0; x < 20; x++) {
            Random random = new Random();
            int i = random.nextInt(15) + 0;
            int j = random.nextInt(20) + 0;
            if (matriz.verifyCell(i, j)) {
                matriz.defineCell(i, j, matriz.obstaculo);
            } else {
                x--;
            }
        }
    }

    public void definirPadrao(Matriz matriz){
        matriz.defineCell(0, 1, matriz.obstaculo);
        matriz.defineCell(2, 3, matriz.obstaculo);
    }
}
