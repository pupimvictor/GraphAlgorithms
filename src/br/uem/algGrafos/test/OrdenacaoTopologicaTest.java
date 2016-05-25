package br.uem.algGrafos.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.ordenacaoTopografica.OrdenacaoTopologica;

public class OrdenacaoTopologicaTest {
	
	private Aresta[] E;
	private String[] V;

	@Before
	public void setUp() throws Exception {
		/*String[] V = { "s", "t", "u", "v", "w", "x", "y", "z" };
		this.V = V;

		Aresta[] E = new Aresta[9];
		E[0] = new Aresta(0, 3, 1);
		E[1] = new Aresta(0, 1, 1);
		E[2] = new Aresta(1, 4, 1);
		E[3] = new Aresta(2, 4, 1);
		E[4] = new Aresta(2, 5, 1);
		E[5] = new Aresta(3, 1, 1);
		E[6] = new Aresta(4, 3, 1);
		E[7] = new Aresta(4, 3, 1);
		E[8] = new Aresta(4, 3, 1);
		this.E = E;*/
		
		String[] V = {"cueca", "calça", "cinto", "camisa", "gravata", "paleto", "meias","sapatos", "relogio"};
		this.V = V;
		
		Aresta[] E = new Aresta[7];
		E[0] = new Aresta(0, 1, 1);
		E[1] = new Aresta(1, 2, 1);
		E[2] = new Aresta(2, 5, 1);
		E[3] = new Aresta(3, 2, 1);
		E[4] = new Aresta(3, 4, 1);
		E[5] = new Aresta(4, 5, 1);
		E[6] = new Aresta(6, 7, 1);
		
		this.E = E;
	}

	@Test
	public void test() {
		OrdenacaoTopologica ordTop = new OrdenacaoTopologica(V, E, true);
		List<String> result = ordTop.execute();
		
		result.forEach(v -> System.out.print(v + " "));
	}

}
