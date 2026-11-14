package com.mycompany.meuesporte;

public class MeuEsporte {

    static Jogador[] jogadores = new Jogador[100];
    static int qtdJogadores = 0;
    static Time[] times = new Time[20];
    static int qtdTimes = 0;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== MEU ESPORTE =====");
            System.out.println("[1] - Cadastrar jogador;");
            System.out.println("[2] - Cadastrar time;");
            System.out.println("[3] - Listar jogadores cadastrados;");
            System.out.println("[4] - Listar times cadastrados - sem os jogadores;");
            System.out.println("[5] - Vincular jogador a um time;");
            System.out.println("[6] - Listar dados completos de um time;");
            System.out.println("[7] - Sair.");
            opcao = Entrada.leiaInt("Escolha uma opção: ");

            switch (opcao) {
                case 1: cadastrarJogador(); break;
                case 2: cadastrarTime(); break;
                case 3: listarJogadores(); break;
                case 4: listarTimes(); break;
                case 5: vincularJogadorAoTime(); break;
                case 6: listarDadosCompletosTime(); break;
                case 7: System.out.println("Encerrando o programa..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    static void cadastrarJogador() {
        if (qtdJogadores >= jogadores.length) {
            System.out.println("Limite de jogadores atingido!");
            return;
        }
        Jogador j = new Jogador();
        j.setCodigo(qtdJogadores + 1);
        j.setNome(Entrada.leiaString("Nome do jogador: "));
        j.setPosicao(Entrada.leiaString("Posição do jogador: "));
        jogadores[qtdJogadores++] = j;
        System.out.println("Jogador cadastrado com código " + j.getCodigo() + ".");
    }

    static void cadastrarTime() {
        if (qtdTimes >= times.length) {
            System.out.println("Limite de times atingido!");
            return;
        }
        Time t = new Time();
        t.setCodigo(qtdTimes + 1);
        t.setNome(Entrada.leiaString("Nome do time: "));
        t.setTecnico(Entrada.leiaString("Nome do técnico: "));
        times[qtdTimes++] = t;
        System.out.println("Time cadastrado com código " + t.getCodigo() + ".");
    }

    static void listarJogadores() {
        if (qtdJogadores == 0) {
            System.out.println("Nenhum jogador cadastrado.");
            return;
        }
        System.out.println("\n--- Jogadores cadastrados ---");
        for (int i = 0; i < qtdJogadores; i++) {
            Jogador j = jogadores[i];
            System.out.println(j.getCodigo() + " - " + j.getNome() + " - " + j.getPosicao());
        }
    }

    static void listarTimes() {
        if (qtdTimes == 0) {
            System.out.println("Nenhum time cadastrado.");
            return;
        }
        System.out.println("\n--- Times cadastrados ---");
        for (int i = 0; i < qtdTimes; i++) {
            Time t = times[i];
            System.out.println(t.getCodigo() + " - " + t.getNome() + " - " + t.getTecnico());
        }
    }

    static void vincularJogadorAoTime() {
        if (qtdJogadores == 0 || qtdTimes == 0) {
            System.out.println("É preciso ter ao menos um jogador e um time cadastrados.");
            return;
        }
        listarTimes();
        Time t = buscarTime(Entrada.leiaInt("Código do time: "));
        if (t == null) {
            System.out.println("Time não encontrado!");
            return;
        }
        listarJogadores();
        Jogador j = buscarJogador(Entrada.leiaInt("Código do jogador: "));
        if (j == null) {
            System.out.println("Jogador não encontrado!");
            return;
        }
        if (t.contemJogador(j)) {
            System.out.println("Esse jogador já está vinculado a este time.");
        } else if (t.vincularJogador(j)) {
            System.out.println(j.getNome() + " vinculado ao time " + t.getNome() + ".");
        } else {
            System.out.println("O time já está com o número máximo de jogadores.");
        }
    }

    static void listarDadosCompletosTime() {
        if (qtdTimes == 0) {
            System.out.println("Nenhum time cadastrado.");
            return;
        }
        listarTimes();
        Time t = buscarTime(Entrada.leiaInt("Código do time: "));
        if (t == null) {
            System.out.println("Time não encontrado!");
            return;
        }
        System.out.println("\n" + t.getCodigo() + " - " + t.getNome() + " - " + t.getTecnico());
        System.out.println("\nJogadores:");
        if (t.getQtdJogadores() == 0) {
            System.out.println("(nenhum jogador vinculado)");
        }
        for (int i = 0; i < t.getQtdJogadores(); i++) {
            Jogador j = t.getJogadores()[i];
            System.out.println(j.getNome() + " - " + j.getPosicao());
        }
    }

    static Time buscarTime(int codigo) {
        for (int i = 0; i < qtdTimes; i++) {
            if (times[i].getCodigo() == codigo) {
                return times[i];
            }
        }
        return null;
    }

    static Jogador buscarJogador(int codigo) {
        for (int i = 0; i < qtdJogadores; i++) {
            if (jogadores[i].getCodigo() == codigo) {
                return jogadores[i];
            }
        }
        return null;
    }
}
