package com.company.entidades;

public class Tabuleiro {
    private char dados[][] = {
            {'_','|','_','|','_'},
            {'_','|','_','|','_'},
            {'_','|','_','|','_'}
    };

    public Tabuleiro() {

    }

    public void construirTabuleiro (char dados[][]) {
        for (int i=0; i< dados.length; i++) {
            for (int j=0; j< 5; j++) {
                System.out.print(dados[i][j]);
            }
            System.out.println();
        }
    }

    public Boolean checarVencedor() {
        if(dados[0][0] == dados[0][2] && dados[0][4] == dados[0][0] && dados[0][0] !='_') return true;
        if(dados[1][0] == dados[1][2] && dados[1][4] == dados[1][0] && dados[1][0] !='_') return true;
        if(dados[2][0] == dados[2][2] && dados[2][4] == dados[2][0] && dados[2][0] !='_') return true;
        if(dados[0][0] == dados[1][0] && dados[0][0] == dados[2][0] && dados[0][0] !='_') return true;
        if(dados[0][2] == dados[1][2] && dados[0][2] == dados[2][2] && dados[0][2] !='_') return true;
        if(dados[0][4] == dados[1][4] && dados[0][4] == dados[2][4] && dados[0][4] !='_') return true;
        if(dados[0][0] == dados[1][2] && dados[0][0] == dados[2][4] && dados[0][0] !='_') return true;
        if(dados[2][0] == dados[1][2] && dados[2][0] == dados[0][4] && dados[2][0] !='_') return true;
        else return false;
    }

    public void mostrarPosicoes(){
        char posicoes[][] = {
                {'1','|','2','|','3'},
                {'4','|','5','|','6'},
                {'7','|','8','|','9'}
        };
        construirTabuleiro(posicoes);
    }

    public void atualizarTabuleiro(int posicao, char opcao) {
        switch (posicao){
            case 1: dados[0][0] = opcao;
                break;
            case 2: dados[0][2] = opcao;
                break;
            case 3: dados[0][4] = opcao;
                break;
            case 4: dados[1][0] = opcao;
                break;
            case 5: dados[1][2] = opcao;
                break;
            case 6: dados[1][4] = opcao;
                break;
            case 7: dados[2][0] = opcao;
                break;
            case 8: dados[2][2] = opcao;
                break;
            case 9: dados[2][4] = opcao;
                break;
        }
    }

    public Boolean verificarDisponibilidadePosicao(int posicao, char opcao) {
        if(posicao == 1 && dados[0][0] =='_') return true;
        if(posicao == 2 && dados[0][2] =='_') return true;
        if(posicao == 3 && dados[0][4] =='_') return true;
        if(posicao == 4 && dados[1][0] =='_') return true;
        if(posicao == 5 && dados[1][2] =='_') return true;
        if(posicao == 6 && dados[1][4] =='_') return true;
        if(posicao == 7 && dados[2][0] =='_') return true;
        if(posicao == 8 && dados[2][2] =='_') return true;
        if(posicao == 9 && dados[2][4] =='_') return true;
        else return false;
    }

    public char[][] getDados() {
        return dados;
    }

    public void setDados(char[][] dados) {
        this.dados = dados;
    }
}
