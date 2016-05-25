package br.uem.algGrafos.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.bellmanFord.BellmanFord;
import br.uem.algGrafos.bellmanFord.GrafoBellmanFord;
import br.uem.algGrafos.bellmanFord.BellmanFord.BellmanFordReturn;

public class BellmanFordTest {
	
	private Aresta[] E;
	private String[] V;

	@Before
	public void setUp() throws Exception {
		String[] V = { "r", "s", "t", "u", "v"};
		this.V = V;
		
		Aresta[] E = new Aresta[9];
		E[0] = new Aresta(0, 1, 6);
		E[1] = new Aresta(0, 3, 7);
		E[2] = new Aresta(1, 2, 5);
		E[3] = new Aresta(1, 3, 8);
		E[4] = new Aresta(1, 4, -4);
		E[5] = new Aresta(2, 1, -2);
		E[6] = new Aresta(3, 2, -3);
		E[7] = new Aresta(3, 4, 9);
		E[8] = new Aresta(4, 0, 2);
		this.E = E;
	}

	@Test
	public void testExecute() {
		BellmanFord bellmanFord = new BellmanFord(V, E, true, 0);
		BellmanFordReturn resultado = bellmanFord.execute();
		
		List<Integer> menoresCaminhosExpected = new ArrayList<Integer>();
		menoresCaminhosExpected.add(0, 0);
		menoresCaminhosExpected.add(1, 2);
		menoresCaminhosExpected.add(2, 4);
		menoresCaminhosExpected.add(3, 7);
		menoresCaminhosExpected.add(4, -2);
		
		List<Integer> predecessoresExpected = new ArrayList<Integer>();
		predecessoresExpected.add(0, null);
		predecessoresExpected.add(1, 2);
		predecessoresExpected.add(2, 3);
		predecessoresExpected.add(3, 0);
		predecessoresExpected.add(4, 1);
		
		assertEquals(menoresCaminhosExpected, resultado.getDistancias());
		assertEquals(predecessoresExpected, resultado.getPredecessores());
	}

}
