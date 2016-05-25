package br.uem.algGrafos.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.componentesFortementeConexos.ComponentesFortementeConexos;

public class ComponentesFortementeConexosTest {

	private Aresta[] E;
	private String[] V;

	@Before
	public void setUp() throws Exception {
		String[] V = { "a", "b", "c", "d", "e", "f", "g", "h" };
		this.V = V;

		Aresta[] E = new Aresta[13];
		E[0] = new Aresta(0, 1, 1);
		E[1] = new Aresta(1, 2, 1);
		E[2] = new Aresta(1, 4, 1);
		E[3] = new Aresta(1, 4, 1);
		E[4] = new Aresta(2, 3, 1);
		E[5] = new Aresta(3, 2, 1);
		E[6] = new Aresta(3, 7, 1);
		E[7] = new Aresta(4, 0, 1);
		E[8] = new Aresta(4, 5, 1);
		E[9] = new Aresta(5, 6, 1);
		E[10] = new Aresta(6, 5, 1);
		E[11] = new Aresta(6, 7, 1);
		E[12] = new Aresta(7, 7, 1);

		this.E = E;
	}

	@Test
	public void testExecute() {
		ComponentesFortementeConexos SCC = new ComponentesFortementeConexos(V, E, true);
		
		List<String> SCCExpected = new ArrayList<String>();
		SCCExpected.add("abc");
		SCCExpected.add("cd");
		SCCExpected.add("fg");
		SCCExpected.add("h");
		
		List<String> result = SCC.execute();
		
		result.forEach(v -> System.out.println(v));
		
		assertEquals(SCCExpected, result);		
		
	}

}
