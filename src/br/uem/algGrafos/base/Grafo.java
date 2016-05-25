package br.uem.algGrafos.base;

public abstract class Grafo {
	
	private String V[];
	private Aresta E[];
	private int numV;
	
	public Grafo(String[] v, Aresta[] e) {
		super();
		V = v;
		numV = v.length;
		E = e;
	}

	public abstract void insereArestaDirec(int v1, int v2, int peso);
	
	public abstract void insereAresta(int v1, int v2, int peso);
	
	public abstract void montaAdj();

	public abstract void montaAdjDirec();
	
	public String[] getV() {
		return V;
	}

	public void setV(String[] v) {
		V = v;
	}

	public int getNumV() {
		return numV;
	}

	public void setNumV(int numV) {
		this.numV = numV;
	}

	public Aresta[] getE() {
		return E;
	}

	public void setE(Aresta e[]) {
		E = e;
	}
}
