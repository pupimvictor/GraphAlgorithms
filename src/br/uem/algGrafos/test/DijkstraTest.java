package br.uem.algGrafos.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.dijkstra.Dijkstra;
import br.uem.algGrafos.dijkstra.Dijkstra.DijkstraReturn;

public class DijkstraTest {
	
	private Aresta[] E;
	private String[] V;

	@Before
	public void setUp() throws Exception {
		String[] V = { "r", "s", "t", "u", "v"};
		this.V = V;
		
		Aresta[] E = new Aresta[10];
		E[0] = new Aresta(0, 1, 10);
		E[1] = new Aresta(0, 3, 5);
		E[2] = new Aresta(1, 2, 1);
		E[3] = new Aresta(1, 3, 2);
		E[4] = new Aresta(3, 1, 3);
		E[5] = new Aresta(2, 4, 4);
		E[6] = new Aresta(4, 2, 6);
		E[7] = new Aresta(3, 2, 9);
		E[8] = new Aresta(3, 4, 2);
		E[9] = new Aresta(4, 0, 7);
		this.E = E;
	}

	@Test
	public void testExecute() {
		Dijkstra dijkstra = new Dijkstra(V, E, true, 0);
		DijkstraReturn resultado = dijkstra.execute();
		
		List<Integer> menoresCaminhosExpected = new ArrayList<Integer>();
		menoresCaminhosExpected.add(0, 0);
		menoresCaminhosExpected.add(1, 8);
		menoresCaminhosExpected.add(2, 9);
		menoresCaminhosExpected.add(3, 5);
		menoresCaminhosExpected.add(4, 7);
		
		List<Integer> predecessoresExpected = new ArrayList<Integer>();
		predecessoresExpected.add(0, null);
		predecessoresExpected.add(1, 3);
		predecessoresExpected.add(2, 1);
		predecessoresExpected.add(3, 0);
		predecessoresExpected.add(4, 5);
		
		assertEquals(menoresCaminhosExpected, resultado.getDistancias());
		assertEquals(predecessoresExpected, resultado.getPredecessores());
	}

}
