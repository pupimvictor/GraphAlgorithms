package br.uem.algGrafos.buscaProfundidade;

import java.util.ArrayList;
import java.util.List;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.base.GrafoListaAdj;
import br.uem.algGrafos.base.OpcoesCor;

public class GrafoBuscaProfundidade extends GrafoListaAdj{
	
	private List<OpcoesCor> cor;
	private List<Integer> tempoDescoberta;
	private List<Integer> tempoFim;
	private List<Integer> pred;

	public GrafoBuscaProfundidade(String[] V, Aresta[] E, boolean direct) {
		super(V, E, direct);
		cor = new ArrayList<OpcoesCor>();
		tempoDescoberta = new ArrayList<Integer>();
		tempoFim = new ArrayList<Integer>();
		pred = new ArrayList<Integer>();
	
		for (int i = 0; i < super.getNumV(); i++) {
			cor.add(i, OpcoesCor.BRANCO);
			tempoDescoberta.add(i, -1);
			tempoFim.add(i, -1);
			pred.add(i, null);
		}
	}
	
	public GrafoBuscaProfundidade(GrafoListaAdj grafoTransp) {
		super(grafoTransp.getV(), grafoTransp.getE(), true);
		cor = new ArrayList<OpcoesCor>();
		tempoDescoberta = new ArrayList<Integer>();
		tempoFim = new ArrayList<Integer>();
		pred = new ArrayList<Integer>();
	
		for (int i = 0; i < super.getNumV(); i++) {
			cor.add(i, OpcoesCor.BRANCO);
			tempoDescoberta.add(i, -1);
			tempoFim.add(i, -1);
			pred.add(i, null);
		}
	
	}

	public List<Integer> encontraRaizes() {
		List<Integer> naoRaizes = new ArrayList<Integer>();
		List<Integer> raizes = new ArrayList<Integer>();
		for (int i = 0; i < this.getV().length; i++) {
			naoRaizes.addAll(this.getListaAdj()[i]);
			raizes.add(i);
		}
		raizes.removeAll(naoRaizes);
		return raizes;
	}
	
	public List<OpcoesCor> getCor() {
		return cor;
	}

	public void setCor(List<OpcoesCor> cor) {
		this.cor = cor;
	}


	public List<Integer> getPred() {
		return pred;
	}

	public void setPred(List<Integer> pred) {
		this.pred = pred;
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

}
