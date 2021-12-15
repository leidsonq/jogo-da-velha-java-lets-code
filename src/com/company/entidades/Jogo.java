package com.company.entidades;

import java.util.Scanner;

public class Jogo {
    Scanner leitor = new Scanner(System.in);
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Jogador jogador1 = new Jogador();
    private Jogador jogador2 = new Jogador();
    private Jogador jogadorAtual = jogador1;
    private int opcao;
    private int posicao;

    public void configurarJogadores() {
        System.out.println("Informe o nome do jogador 1:");
        jogador1.setNome(leitor.next());
        System.out.println(jogador1.getNome()+" informe a opção: digite 1 para O ou 2 para X");
        opcao = leitor.nextInt();
        validarOpcao();
        System.out.println("Informe o nome do jogador 2:");
        jogador2.setNome(leitor.next());
        definirOpcoesJogadores();
        System.out.println(jogador1.getNome()+" joga com "+jogador1.getOpcao()+ " e "+jogador2.getNome()+"  joga com "+jogador2.getOpcao());
    }

    public void definirOpcoesJogadores() {
        if (opcao == 1) {
            jogador1.setOpcao('O');
            jogador2.setOpcao('X');
        } else {
            jogador2.setOpcao('O');
            jogador1.setOpcao('X');
        }
    }

    public void validarOpcao() {
        while (opcao != 1 && opcao != 2) {
            System.out.println(jogador1.getNome()+" informe uma opção válida: 1 para O ou 2 para X");
            opcao = leitor.nextInt();
        }
    }

    public void mostrarGabaritoDePosicoes() {
        System.out.println("Gabarito de posições:");
        tabuleiro.mostrarPosicoes();
    }

    public void adicionarJogada(){
        System.out.println(jogadorAtual.getNome()+" informe a posição para adicionar o "+jogadorAtual.getOpcao());
        posicao = leitor.nextInt();
        validarJogada();
    }

    public void validarJogada() {
        validarPosicao();
        verificarDisponibilidadePosicao();
        tabuleiro.atualizarTabuleiro(posicao, jogadorAtual.getOpcao());
        setJogadorAtual(jogadorAtual);
        tabuleiro.construirTabuleiro(tabuleiro.getDados());
    }

    public void validarPosicao() {
        while (posicao < 1 || posicao > 9) {
            System.out.println(jogadorAtual.getNome()+" informe uma posição válida!");
            posicao = leitor.nextInt();
        }
    }

    public void verificarDisponibilidadePosicao() {
        while (!tabuleiro.verificarDisponibilidadePosicao(posicao, jogadorAtual.getOpcao())) {
            System.out.println("Posição já preenchida. Favor informar uma posição disponível!");
            posicao = leitor.nextInt();
        }
    }

    public Boolean checarVencedor() {
        if(tabuleiro.checarVencedor()) return true;
        else return false;
    }

    public void informarVencedor(){
        if(tabuleiro.checarVencedor()) {
            setJogadorAtual(jogadorAtual);
            System.out.println("O jogador "+jogadorAtual.getNome()+" é o vencedor!!!!");
        }
    }

    public void setJogadorAtual(Jogador jogadorAtual) {
        if (this.jogadorAtual.equals(jogador1)) {
            this.jogadorAtual = jogador2;
        } else {
            this.jogadorAtual = jogador1;
        }
    }

}
