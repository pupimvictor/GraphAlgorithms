package br.uem.algGrafos.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.buscaProfundidade.BuscaEmProfundidade;
import br.uem.algGrafos.buscaProfundidade.BuscaEmProfundidade.DFSReturn;
import br.uem.algGrafos.buscaProfundidade.GrafoBuscaProfundidade;

public class BuscaEmProfundidadeTest {
	
	private Aresta[] E;
	private String[] V;

	@Before
	public void setUp() throws Exception {
		String[] V = {"u", "v", "w", "x"};
		this.V = V;
		
		Aresta[] E = new Aresta[4];
		E[0] = new Aresta(0, 1, 1);
		E[1] = new Aresta(1, 2, 1);
		E[2] = new Aresta(1, 3, 1);
		E[3] = new Aresta(2, 3, 1);
		this.E = E;
	}

	@Test
	public void executeTest() {
		BuscaEmProfundidade DFS = new BuscaEmProfundidade(V, E, true);
		
		List<Integer> tempoDescobertaExpected = new ArrayList<Integer>();
		tempoDescobertaExpected.add(1);
		tempoDescobertaExpected.add(2);
		tempoDescobertaExpected.add(3);
		tempoDescobertaExpected.add(4);
		

		List<Integer> tempoFimExpected = new ArrayList<Integer>();
		tempoFimExpected.add(8);
		tempoFimExpected.add(7);
		tempoFimExpected.add(6);
		tempoFimExpected.add(5);
		
		List<Integer> predExpected = new ArrayList<Integer>();
		predExpected.add(0,null);
		predExpected.add(1,0);
		predExpected.add(2,1);
		predExpected.add(3,2);
		
		DFSReturn resultExpected = new DFSReturn(tempoDescobertaExpected,tempoFimExpected, predExpected);
		
		DFSReturn result = DFS.execute();
		
		DFS.imprimeBuscaProfundidade();
		
		assertEquals(resultExpected, result);
		
		
		
	
	}

}
