package br.uem.algGrafos.base;

import java.util.ArrayList;
import java.util.List;

public class GrafoListaAdj extends Grafo {

	private ArrayList<Integer> listaAdj[];
	
	@SuppressWarnings("unchecked")
	public GrafoListaAdj(String[] V, Aresta[] E, boolean direct) {
		super(V, E);
		listaAdj = new ArrayList[super.getNumV()];
/*		w = new ArrayList<List<Integer>>(super.getNumV());
		for(int i = 0; i < super.getNumV(); i++)  {
	        w.add(i,new ArrayList<Integer>());
	    }
*/		
		
		for (int i = 0; i < listaAdj.length; i++) {
			listaAdj[i] = new ArrayList<Integer>();
		}
		
		if (direct) {
			montaAdjDirec();
		}else{
			montaAdj();
		}
	}

	private GrafoListaAdj(String[] v, Aresta[] e) {
		super(v, e);
	}

	@SuppressWarnings("unchecked")
	public GrafoListaAdj getTransposto() {
		GrafoListaAdj grafoT = new GrafoListaAdj(super.getV(), super.getE());
		grafoT.listaAdj = new ArrayList[grafoT.getNumV()];

		for (int i = 0; i < grafoT.listaAdj.length; i++) {
			grafoT.listaAdj[i] = new ArrayList<Integer>();
		}
		
		for (Aresta aresta : grafoT.getE()) {
			if (grafoT.listaAdj[aresta.getV2()] == null) {
				grafoT.listaAdj[aresta.getV2()] = new ArrayList<Integer>();
				grafoT.listaAdj[aresta.getV2()].add(aresta.getV1());
			}else {
				grafoT.listaAdj[aresta.getV2()].add(aresta.getV1());
			}
		}
		return grafoT;
	}

	@Override
	public void montaAdj() {
		for (Aresta aresta : super.getE()) {
			insereAresta(aresta.getV1(), aresta.getV2(), aresta.getPeso());
		}	
		
	}

	@Override
	public void montaAdjDirec() {
		for (Aresta aresta : super.getE()) {
			insereArestaDirec(aresta.getV1(), aresta.getV2(), aresta.getPeso());
		}
	}
	

	@Override
	public void insereArestaDirec(int v1, int v2, int peso) {
		if (listaAdj[v1] == null) {
			listaAdj[v1] = new ArrayList<Integer>();
			listaAdj[v1].add(v2);
		}else {
			listaAdj[v1].add(v2);
		}
	}

	@Override
	public void insereAresta(int v1, int v2, int peso) {
		if (listaAdj[v1] == null) {
			listaAdj[v1] = new ArrayList<Integer>();
			listaAdj[v1].add(v2);
		}else {
			listaAdj[v1].add(v2);
		}
		if (listaAdj[v2] == null) {
			listaAdj[v2] = new ArrayList<Integer>();
			listaAdj[v2].add(v1);
		}else {
			listaAdj[v2].add(v1);
		}
//		w.get(v1).set(v2, peso);
	}
	
	public List<Integer>[] getListaAdj() {
		return listaAdj;
	}

	public void setListaAdj(ArrayList<Integer> listaAdj[]) {
		this.listaAdj = listaAdj;
	}

/*	public List<List<Integer>> getW() {
		return w;
	}

	public void setW(List<List<Integer>> w) {
		this.w = w;
	}

	*/

	

}
