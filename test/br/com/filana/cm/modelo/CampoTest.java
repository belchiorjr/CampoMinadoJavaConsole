package br.com.filana.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.filana.cm.exception.ExplosaoException;
import br.com.filana.cm.modelo.Campo;

class CampoTest {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void vizinhoDistanciaEsquerda() {
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	

	@Test
	void vizinhoDistanciaDireita() {
		Campo vizinho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	

	@Test
	void vizinhoDistanciaSuperior() {
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	

	@Test
	void vizinhoDistanciaInferior() {
		Campo vizinho = new Campo(4,3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	
	@Test
	void vizinhoDiagonal() {
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	

	@Test
	void naoVizinho() {
		Campo vizinho = new Campo(1,1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	
	@Test
	void testeValorPadraoMarcacao() {
		assertFalse(campo.isMarcado());
	}
	
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	

	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});	
	}
	
	@Test
	void testeAbrirComVizinhos1() {
		
		Campo campo11 = new Campo(1,1);
		Campo campo22 = new Campo(2,2);
		
		campo22.adicionarVizinho(campo11);
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	

	@Test
	void testeAbrirComVizinhos2() {
		
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);
		
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	
	
	
	
}
