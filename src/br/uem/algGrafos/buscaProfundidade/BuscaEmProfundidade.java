package br.uem.algGrafos.buscaProfundidade;

import java.util.List;
import java.util.Stack;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.base.GrafoListaAdj;
import br.uem.algGrafos.base.OpcoesCor;

public class BuscaEmProfundidade {

	private GrafoBuscaProfundidade G;
	private Stack<Integer> pilha;
	private int tempo;

	public BuscaEmProfundidade(String[] V, Aresta[] E, boolean direc) {
		G = new GrafoBuscaProfundidade(V, E, direc);
		tempo = 0;
		pilha = new Stack<Integer>();
	}

	public DFSReturn execute() {
		pilha.addAll(G.encontraRaizes());
		while (!pilha.empty()) {
			Integer u = pilha.pop();
			if (G.getCor().get(u) == OpcoesCor.BRANCO) {
				G.getCor().set(u, OpcoesCor.CINZA);
				tempo++;
				G.getTempoDescoberta().set(u, tempo);
				for (int w = 0; w < G.getListaAdj()[u].size(); w++) {
					G.getPred().set(G.getListaAdj()[u].get(w), u);
						pilha.push(G.getListaAdj()[u].get(w));
					
				}
			} else if (G.getCor().get(u) == OpcoesCor.CINZA) {
				tempo++;
				G.getTempoFim().set(u, tempo);
				G.getCor().set(u, OpcoesCor.PRETO);

				if (G.getPred().get(u) != null) {
					pilha.push(G.getPred().get(u));
				}

			} else {
				int i = 0;
				while (i < G.getNumV()) {
					if (G.getCor().get(i) != OpcoesCor.PRETO) {
						pilha.push(i);
					}
					i++;
				}
			}
		}

		DFSReturn retorno = new DFSReturn(G.getTempoDescoberta(), G.getTempoFim(), G.getPred());
		return retorno;
	}
	
	public GrafoBuscaProfundidade executeSCC(Stack<Integer> pilha, GrafoBuscaProfundidade G) {
		pilha.add(0);
		pilha.removeIf(v -> v==-1);
		int tempo = 0;
		while (!pilha.empty()) {
			Integer u = pilha.pop();
			if (G.getCor().get(u) == OpcoesCor.BRANCO) {
				G.getCor().set(u, OpcoesCor.CINZA);
				tempo++;
				G.getTempoDescoberta().set(u, tempo);
				for (int w = 0; w < G.getListaAdj()[u].size(); w++) {
					G.getPred().set(G.getListaAdj()[u].get(w), u);
						pilha.push(G.getListaAdj()[u].get(w));
				}
			} else if (G.getCor().get(u) == OpcoesCor.CINZA) {
				tempo++;
				G.getTempoFim().set(u, tempo);

				G.getCor().set(u, OpcoesCor.PRETO);

				if (G.getPred().get(u) != null) {
					pilha.push(G.getPred().get(u));
				}

			} else {
				int i = 0;
				while (i < G.getNumV()) {
					if (G.getCor().get(i) != OpcoesCor.PRETO) {
						pilha.push(i);
					}
					i++;
				}
			}
		}

		//DFSReturn retorno = new DFSReturn(G.getTempoDescoberta(), G.getTempoFim(), G.getPred());
		return G;
	}
	
	public void imprimeBuscaProfundidade(){
		for (int i = 0; i < G.getV().length; i++) {
			System.out.println(i + " "+ G.getV()[i] + " - descoberta: "+ G.getTempoDescoberta().get(i) +" - Final: "+ G.getTempoFim().get(i) + " - Pred: " + G.getPred().get(i));
		}
	}

	public GrafoBuscaProfundidade getG() {
		return G;
	}

	public void setG(GrafoBuscaProfundidade g) {
		G = g;
	}

	public static class DFSReturn {

		private List<Integer> tempoDescoberta;
		private List<Integer> tempoFim;
		private List<Integer> predecessores;

		public DFSReturn(List<Integer> tempoDescoberta, List<Integer> tempoFim, List<Integer> predecessores) {
			super();
			this.tempoDescoberta = tempoDescoberta;
			this.tempoFim = tempoFim;
			this.predecessores = predecessores;
		}

		public List<Integer> getPredecessores() {
			return predecessores;
		}

		public void setPredecessores(List<Integer> predecessores) {
			this.predecessores = predecessores;
		}

		public List<Integer> getTempoDescoberta() {
			return tempoDescoberta;
		}

		public void setTempoDescoberta(List<Integer> tempoDescoberta) {
			this.tempoDescoberta = tempoDescoberta;
		}

		public List<Integer> getTempoFim() {
			return tempoFim;
		}

		public void setTempoFim(List<Integer> tempoFim) {
			this.tempoFim = tempoFim;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((predecessores == null) ? 0 : predecessores.hashCode());
			result = prime * result + ((tempoDescoberta == null) ? 0 : tempoDescoberta.hashCode());
			result = prime * result + ((tempoFim == null) ? 0 : tempoFim.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DFSReturn other = (DFSReturn) obj;
			if (predecessores == null) {
				if (other.predecessores != null)
					return false;
			} else if (!predecessores.equals(other.predecessores))
				return false;
			if (tempoDescoberta == null) {
				if (other.tempoDescoberta != null)
					return false;
			} else if (!tempoDescoberta.equals(other.tempoDescoberta))
				return false;
			if (tempoFim == null) {
				if (other.tempoFim != null)
					return false;
			} else if (!tempoFim.equals(other.tempoFim))
				return false;
			return true;
		}

	}

}
