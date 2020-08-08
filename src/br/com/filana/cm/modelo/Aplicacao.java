package br.com.filana.cm.modelo;

import br.com.filana.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		// Inicia o Jogo
		new TabuleiroConsole(tabuleiro);
		
	}
}
