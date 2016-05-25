package br.uem.algGrafos.bellmanFord;

import java.util.List;

import br.uem.algGrafos.base.Aresta;

public class BellmanFord {
	
	private GrafoBellmanFord G;
	private int raiz;

	public BellmanFord(String[] V, Aresta[] E, boolean direct, int raiz) {
		G = new GrafoBellmanFord(V, E, direct);
		this.raiz = raiz;
	}
	
	public BellmanFordReturn execute(){
		for (int u = 0; u < G.getNumV() -1; u++) {
			for (int v = 0; v < G.getMatrizAdj()[u].length; v++) {
				if (G.getMatrizAdj()[u][v] != null && G.getMatrizAdj()[u][v] > 0) 
					relax(u, v);
			}
		}
		for (int u = 0; u < G.getNumV() ; u++) {
			for (int v = 0; v < G.getMatrizAdj()[u].length; v++) {
				if (G.getMatrizAdj()[u][v] != null && G.getMatrizAdj()[u][v] > 0) 
					if (G.getD().get(v) > G.getD().get(u) + G.getMatrizAdj()[u][v]) 
						return null;
			}
		}
		return new BellmanFordReturn(G.getD(), G.getPred());
	}
	
	private void relax(int u, int v) {
		if ( G.getD().get(v) > G.getD().get(u) + G.getMatrizAdj()[u][v]) {
			G.getD().set(v, G.getD().get(u) + G.getMatrizAdj()[u][v]);
			G.getPred().set(v, u);
		}
	}
	
	public class BellmanFordReturn{
		private List<Integer> distancias;
		private List<Integer> predecessores;
		
		public BellmanFordReturn(List<Integer> distancias, List<Integer> predecessores) {
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

	public void imprimeBellman() {
		for (int i = 0; i < G.getV().length; i++) {
			System.out.println(i + " "+ G.getV()[i] + " - d: "+ G.getD().get(i) + " Pred: " + G.getPred().get(i));
		}
	}
	
}
