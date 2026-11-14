
package com.mycompany.meuesporte;

public class Time {

    int codigo;
    String nome;
    String tecnico;
    Jogador jogadores[] = new Jogador[30];
    int qtdJogadores = 0; // controla quantos jogadores já foram vinculados

    // métodos setters e getters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogador[] jogadores) {
        this.jogadores = jogadores;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    // verifica se o jogador já está no time
    public boolean contemJogador(Jogador j) {
        for (int i = 0; i < qtdJogadores; i++) {
            if (jogadores[i] == j) {
                return true;
            }
        }
        return false;
    }

    // vincula um jogador ao time; retorna false se o time estiver cheio
    public boolean vincularJogador(Jogador j) {
        if (qtdJogadores >= jogadores.length) {
            return false;
        }
        jogadores[qtdJogadores] = j;
        qtdJogadores++;
        return true;
    }
}
