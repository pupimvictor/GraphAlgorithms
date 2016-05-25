package br.uem.algGrafos.dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.uem.algGrafos.base.Aresta;

public class Dijkstra {
	
	private GrafoDijkstra G;
	private int raiz;
	private List<Integer> fila;
	
	
	public Dijkstra(String[] V, Aresta[] E, boolean direc, int raiz) {
		G = new GrafoDijkstra(V, E, direc);
		this.raiz = raiz;
		fila = new LinkedList<Integer>();
	}
	
	public DijkstraReturn execute() {
		List<Integer> visitados = new ArrayList<Integer>();
		fila.add(raiz);
		while (!fila.isEmpty()) {
			Integer u = extractMin(fila);
			fila.remove(u);
			visitados.add(u);
			for (int v = 0; v < G.getMatrizAdj()[u].length; v++) {
				if (G.getMatrizAdj()[u][v] != null && G.getMatrizAdj()[u][v] > 0) 
					relax(u, v);
			}
		}
		
		DijkstraReturn result = new DijkstraReturn(G.getD(), G.getPred());
		return result;
	}
	
	private void relax(int u, int v) {
		if ( G.getD().get(v) > G.getD().get(u) + G.getMatrizAdj()[u][v]) {
			G.getD().set(v, G.getD().get(u) + G.getMatrizAdj()[u][v]);
			G.getPred().set(v, u);
			fila.add(v);
		}
	}

	private int extractMin(List<Integer> fila) {
		int min = Integer.MAX_VALUE;
		for (Integer v : fila) {
			if (G.getD().get(v) < min)
				min = v;
		}
		return min;
	}

	public GrafoDijkstra getG() {
		return G;
	}

	public void setG(GrafoDijkstra g) {
		G = g;
	}

	public int getRaiz() {
		return raiz;
	}

	public void setRaiz(int raiz) {
		this.raiz = raiz;
	}

	public List<Integer> getFila() {
		return fila;
	}

	public void setFila(List<Integer> fila) {
		this.fila = fila;
	}

	public class DijkstraReturn{
		private List<Integer> distancias;
		private List<Integer> predecessores;
		
		public DijkstraReturn(List<Integer> distancias, List<Integer> predecessores) {
			super();
			this.distancias = distancias;
			this.predecessores = predecessores;
		}
		public List<Integer> getDistancias() {
			return distancias;
		}
		public void setDistancias(List<Integer> distancias) {
			this.distancias = distancias;
		}
		public List<Integer> getPredecessores() {
			return predecessores;
		}
		public void setPredecessores(List<Integer> predecessores) {
			this.predecessores = predecessores;
		}
		
	}

	public void imprimeDijkstra() {
		for (int i = 0; i < G.getV().length; i++) {
			System.out.println(i + " "+ G.getV()[i] + " - d: "+ G.getD().get(i) + " Pred: " + G.getPred().get(i));
		}
	}
	
	
	
	
	
}
