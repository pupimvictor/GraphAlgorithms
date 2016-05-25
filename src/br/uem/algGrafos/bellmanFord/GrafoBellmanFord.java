package br.uem.algGrafos.bellmanFord;

import java.util.ArrayList;
import java.util.List;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.base.GrafoMatrizAdj;
import br.uem.algGrafos.base.OpcoesCor;

public class GrafoBellmanFord extends GrafoMatrizAdj {
	private List<OpcoesCor> cor;
	private List<Integer> d;
	private List<Integer> pred;

	private static Integer INFINITO = Integer.MAX_VALUE;

	public GrafoBellmanFord(String[] V, Aresta[] E, boolean direct) {
		super(V, E, direct);
		cor = new ArrayList<OpcoesCor>();
		d = new ArrayList<Integer>();
		pred = new ArrayList<Integer>();
		
		for (int i = 0; i < super.getNumV(); i++) {
			cor.add(i, OpcoesCor.BRANCO);
			d.add(i, INFINITO);
			pred.add(i, null);
		}
		d.add(0, 0);
	}
	
	public List<OpcoesCor> getCor() {
		return cor;
	}

	public void setCor(List<OpcoesCor> cor) {
		this.cor = cor;
	}

	public List<Integer> getD() {
		return d;
	}

	public void setD(List<Integer> d) {
		this.d = d;
	}

	public List<Integer> getPred() {
		return pred;
	}

	public void setPred(List<Integer> pred) {
		this.pred = pred;
	}

}
