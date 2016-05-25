package br.uem.algGrafos.base;

public class GrafoMatrizAdj extends	Grafo{
	
	private Integer matrizAdj[][];
	
	public GrafoMatrizAdj(String[] V, Aresta[] E, boolean direct) {
		super(V, E);
		this.matrizAdj = new Integer[super.getNumV()][super.getNumV()];
		
		if (direct) {
			montaAdjDirec();
		}else{
			montaAdj();
		}
	}
	
	public void montaAdj() {
		for (Aresta aresta : super.getE()) {
			insereAresta(aresta.getV1(), aresta.getV2(), aresta.getPeso());
		}		
	}

	public void montaAdjDirec() {
		for (Aresta aresta : super.getE()) {
			if (aresta != null) 
				insereArestaDirec(aresta.getV1(), aresta.getV2(), aresta.getPeso());
		}
	}

	@Override
	public void insereAresta(int v1, int v2, int peso) {
		matrizAdj[v1][v2] = peso;
		matrizAdj[v2][v1] = peso;
		
	}
	
	public void insereArestaDirec(int v1, int v2, int peso) {
			matrizAdj[v1][v2] = peso;
	}

	public Integer[][] getMatrizAdj() {
		return matrizAdj;
	}

	public void setMatrizAdj(Integer[][] matrizAdj) {
		this.matrizAdj = matrizAdj;
	}

	
}
