package br.uem.algGrafos.componentesFortementeConexos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.base.GrafoListaAdj;
import br.uem.algGrafos.buscaProfundidade.BuscaEmProfundidade;
import br.uem.algGrafos.buscaProfundidade.GrafoBuscaProfundidade;

public class ComponentesFortementeConexos {

	private BuscaEmProfundidade DFS;
	private GrafoListaAdj grafo;
	private List<String> compFortementeConexos;
	
	public ComponentesFortementeConexos(String[] V, Aresta[] E, boolean direct) {
		DFS = new BuscaEmProfundidade(V, E, direct);
		grafo = DFS.getG();
		compFortementeConexos = new ArrayList<>();
	}
	
	public List<String> execute() {
		
		//Executa DFS do grafo
		List<Integer> dfsRetorno = DFS.execute().getTempoFim();
		
		//Ordena por maior tempo final
		Comparator<Integer> byTempoFinal = (v1, v2) -> v2.compareTo(v1);
		dfsRetorno.sort(byTempoFinal);
		
		//popula pilha com resultado do DFS ordenado
		Stack<Integer> pilha = new Stack<Integer>();
		dfsRetorno.forEach(d -> pilha.push(d));
		
		//Calcula grafo transposto
		GrafoListaAdj grafoTransp = grafo.getTransposto();
		
		//chama DFS com grafo transposto e ordem de tempo final
		GrafoBuscaProfundidade gProfundidade = new GrafoBuscaProfundidade(grafoTransp);
		gProfundidade = DFS.executeSCC(pilha, gProfundidade);
		
		//get conexos
		List<Integer>[] verticesScc = gProfundidade.getListaAdj();
		for (int i = 0; i < verticesScc.length; i++) {
			//compFortementeConexos.addAll(verticesScc[i]);
		}
		
		return compFortementeConexos;
	}
	
	public BuscaEmProfundidade getDFS() {
		return DFS;
	}
	public void setDFS(BuscaEmProfundidade dFS) {
		DFS = dFS;
	}
	public List<String> getCompFortementeConexos() {
		return compFortementeConexos;
	}
	public void setCompFortementeConexos(List<String> compFortementeConexos) {
		this.compFortementeConexos = compFortementeConexos;
	}

	public void imprimeSCC() {
		compFortementeConexos.forEach(v -> System.out.println(v));
	}
	
	
	
}
