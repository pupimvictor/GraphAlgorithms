package br.uem.algGrafos.floydWarshall;

import java.util.ArrayList;
import java.util.List;

import br.uem.algGrafos.base.Aresta;
import br.uem.algGrafos.base.GrafoMatrizAdj;

public class GrafoFloydMarshall extends GrafoMatrizAdj {
	private List<List<Integer>> D;
	private List<List<Integer>> pi;

	public GrafoFloydMarshall(String[] V, Aresta[] E, boolean direct) {
		super(V, E, direct);
		D = new ArrayList<>(V.length);
		
	}

	public List<List<Integer>> getD() {
		return D;
	}

	public void setD(List<List<Integer>> d) {
		D = d;
	}

}
