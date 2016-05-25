package br.uem.algGrafos.buscaLargura;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.base.OpcoesCor;

public class BuscaEmLargura {
	
	private GrafoBuscaLargura G;
	private int raiz;
	private Queue<Integer> fila;

	public BuscaEmLargura(String[] V, Aresta[] E, boolean direc, int raiz) {
		G = new GrafoBuscaLargura(V, E, direc);
		this.raiz = raiz;
		fila = new LinkedList<Integer>();
	}
	
	public BFSReturn execute(){
		G.getD().set(raiz, 0);
		G.getCor().set(raiz, OpcoesCor.CINZA);
		fila.offer(raiz);
		while(!fila.isEmpty()){
			int v = fila.poll();
			for (Integer w : G.getListaAdj()[v]) {
				if (G.getCor().get(w) == OpcoesCor.BRANCO) {
					G.getCor().set(w, OpcoesCor.CINZA);
					G.getD().set(w, G.getD().get(v) + 1);
					G.getPred().set(w, v);
					fila.offer(w);
				}else if (fila.contains(w)) {
					
				}
			}
			G.getCor().set(v, OpcoesCor.PRETO);
		}
		
		BFSReturn retorno = new BFSReturn(G.getD(), G.getPred());
		return retorno;
	}
	
	public void imprimeBuscaLargura(){
		for (int i = 0; i < G.getV().length; i++) {
			System.out.println(i + " "+ G.getV()[i] + " - d: "+ G.getD().get(i) + " Pred: " + G.getPred().get(i));
		}
	}
	
	public GrafoBuscaLargura getG() {
		return G;
	}

	public void setG(GrafoBuscaLargura g) {
		G = g;
	}
	
	public static class BFSReturn{
		private List<Integer> distancias;
		private List<Integer> predecessores;
		
		public BFSReturn(List<Integer> distancias, List<Integer> predecessores) {
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
	
}
