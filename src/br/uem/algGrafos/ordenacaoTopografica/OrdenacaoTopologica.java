package br.uem.algGrafos.ordenacaoTopografica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.buscaProfundidade.BuscaEmProfundidade;

public class OrdenacaoTopologica {

	private BuscaEmProfundidade DFS;

	private List<String> verticesOrdenados;

	public OrdenacaoTopologica(String[] V, Aresta[] E, boolean direct) {
		DFS = new BuscaEmProfundidade(V, E, direct);
		verticesOrdenados = new ArrayList<>();
	}

	public List<String> execute() {
		List<Integer> dfsRetorno = DFS.execute().getTempoFim();
		List<Integer> dfsRetornoBkp =  new ArrayList<Integer>(dfsRetorno);
		
		//comparador
		Comparator<Integer> byTempoFinal = (v1, v2) -> v2.compareTo(v1);
		
		//Ordena
		dfsRetorno.sort(byTempoFinal);

		//liga aos nomes dos nós
		dfsRetorno.forEach( v -> verticesOrdenados.add(DFS.getG().getV()[dfsRetornoBkp.indexOf(v)]));
		
		return verticesOrdenados;
	}

	public BuscaEmProfundidade getDFS() {
		return DFS;
	}

	public void setDFS(BuscaEmProfundidade dFS) {
		DFS = dFS;
	}

	public void imprimeOrdTop() {
		verticesOrdenados.forEach(v -> System.out.print(v + " "));
	}


}
