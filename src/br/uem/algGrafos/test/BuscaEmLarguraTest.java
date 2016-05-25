package br.uem.algGrafos.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.buscaLargura.BuscaEmLargura;
import br.uem.algGrafos.buscaLargura.BuscaEmLargura.BFSReturn;

public class BuscaEmLarguraTest {

	private Aresta[] E;
	private String[] V;

	@Before
	public void criaVertices() {
		String[] V = { "r", "s", "t", "u", "v", "w", "x", "y" };
		this.V = V;
	}

	@Before
	public void criaArestas() {
		Aresta[] E = new Aresta[10];
		E[0] = new Aresta(0, 1, 1);
		E[1] = new Aresta(0, 4, 1);
		E[2] = new Aresta(1, 5, 1);
		E[3] = new Aresta(2, 5, 1);
		E[4] = new Aresta(2, 6, 1);
		E[5] = new Aresta(2, 3, 1);
		E[6] = new Aresta(3, 6, 1);
		E[7] = new Aresta(3, 7, 1);
		E[8] = new Aresta(5, 6, 1);
		E[9] = new Aresta(6, 7, 1);
		this.E = E;
	}

	@Test
	public void testExecute() {
		BuscaEmLargura BFS = new BuscaEmLargura(V, E, false, 1);
		BFSReturn resultado = BFS.execute();
		
		List<Integer> menoresCaminhosExpected = new ArrayList<Integer>();
		menoresCaminhosExpected.add(0, 1);
		menoresCaminhosExpected.add(1, 0);
		menoresCaminhosExpected.add(2, 2);
		menoresCaminhosExpected.add(3, 3);
		menoresCaminhosExpected.add(4, 2);
		menoresCaminhosExpected.add(5, 1);
		menoresCaminhosExpected.add(6, 2);
		menoresCaminhosExpected.add(7, 3);
		
		List<Integer> predecessoresExpected = new ArrayList<Integer>();
		predecessoresExpected.add(0, 1);
		predecessoresExpected.add(1, null);
		predecessoresExpected.add(2, 5);
		predecessoresExpected.add(3, 2);
		predecessoresExpected.add(4, 0);
		predecessoresExpected.add(5, 1);
		predecessoresExpected.add(6, 5);
		predecessoresExpected.add(7, 6);
		
		BFS.imprimeBuscaLargura();
		
		assertEquals(menoresCaminhosExpected, resultado.getDistancias());
		assertEquals(predecessoresExpected, resultado.getPredecessores());
	}

}
