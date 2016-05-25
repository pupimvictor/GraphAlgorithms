package br.uem.algGrafos.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.base.GrafoListaAdj;


public class GrafoListaAdjTest {
	
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
	public void testInsereArestaDirec() {
		GrafoListaAdj G = new GrafoListaAdj(V, E, true);
		
		List<Integer> a1 = G.getListaAdj()[G.getE()[0].getV1()];
		
		assertTrue(a1.contains(G.getE()[0].getV2()));
		
	}

	@Test
	public void testInsereAresta() {
		GrafoListaAdj G = new GrafoListaAdj(V, E, false);
		
		
		List<Integer> a1 = G.getListaAdj()[G.getE()[0].getV1()];
		List<Integer> a2 = G.getListaAdj()[G.getE()[0].getV2()];
		
		assertTrue(a1.contains(G.getE()[0].getV2()));
		assertTrue(a2.contains(G.getE()[0].getV1()));
		
	}

}
