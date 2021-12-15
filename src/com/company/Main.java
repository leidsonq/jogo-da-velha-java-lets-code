package com.company;
import com.company.entidades.Jogo;

public class Main {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        int cont = 0;

        jogo.configurarJogadores();
        jogo.mostrarGabaritoDePosicoes();

        while (!jogo.checarVencedor() && cont < 9){
            jogo.adicionarJogada();
            cont++;
        }

        if (cont == 9 && !jogo.checarVencedor()) {
            System.out.println("Não há vencedor nessa partida!!!");
        } else {
            jogo.informarVencedor();
        }
    }

}
