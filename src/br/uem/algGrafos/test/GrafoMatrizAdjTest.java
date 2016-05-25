package br.uem.algGrafos.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.base.GrafoMatrizAdj;

public class GrafoMatrizAdjTest {

	private Aresta[] E;
	private String[] V;

	@Before
	public void criaVertices() {
		String[] V = { "a", "b", "c", "d" };
		this.V = V;
	}

	@Before
	public void criaArestas() {
		Aresta[] E = new Aresta[4];
		E[0] = new Aresta(0, 1, 1);
		E[1] = new Aresta(0, 2, 1);
		E[2] = new Aresta(1, 2, 1);
		E[3] = new Aresta(2, 3, 1);
		this.E = E;
	}

	@Test
	public void testInsereArestaDirec() {
		Aresta arestas[] = E;
		GrafoMatrizAdj G = new GrafoMatrizAdj(V, E, true);

		int a1 = G.getMatrizAdj()[G.getE()[0].getV1()][G.getE()[0].getV2()];

		int a2 = G.getMatrizAdj()[G.getE()[1].getV1()][G.getE()[1].getV2()];

		int a3 = G.getMatrizAdj()[G.getE()[2].getV1()][G.getE()[2].getV2()];

		int a4 = G.getMatrizAdj()[G.getE()[3].getV1()][G.getE()[3].getV2()];

		assertEquals(a1, arestas[0].getPeso());
		assertEquals(a2, arestas[1].getPeso());
		assertEquals(a3, arestas[2].getPeso());
		assertEquals(a4, arestas[3].getPeso());
	}

	@Test
	public void testInsereAresta() {
		Aresta[] arestas = E;
		GrafoMatrizAdj G = new GrafoMatrizAdj(V, E, false);

		G.insereAresta(G.getE()[0].getV1(), G.getE()[0].getV2(), G.getE()[0].getPeso());
		int a1 = G.getMatrizAdj()[G.getE()[0].getV1()][G.getE()[0].getV2()];
		int a1v = G.getMatrizAdj()[G.getE()[0].getV2()][G.getE()[0].getV1()];

		G.insereAresta(G.getE()[1].getV1(), G.getE()[1].getV2(), G.getE()[1].getPeso());
		int a2 = G.getMatrizAdj()[G.getE()[1].getV1()][G.getE()[1].getV2()];

		G.insereAresta(G.getE()[2].getV1(), G.getE()[2].getV2(), G.getE()[2].getPeso());
		int a3 = G.getMatrizAdj()[G.getE()[2].getV1()][G.getE()[2].getV2()];

		G.insereAresta(G.getE()[3].getV1(), G.getE()[3].getV2(), G.getE()[3].getPeso());
		int a4 = G.getMatrizAdj()[G.getE()[3].getV1()][G.getE()[3].getV2()];

		assertEquals(a1, arestas[0].getPeso());
		assertEquals(a1v, arestas[0].getPeso());
		assertEquals(a2, arestas[1].getPeso());
		assertEquals(a3, arestas[2].getPeso());
		assertEquals(a4, arestas[3].getPeso());
	}

}
