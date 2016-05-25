package br.uem.algGrafos.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.uem.algGrafos.bellmanFord.BellmanFord;
import br.uem.algGrafos.buscaLargura.BuscaEmLargura;
import br.uem.algGrafos.buscaProfundidade.BuscaEmProfundidade;
import br.uem.algGrafos.componentesFortementeConexos.ComponentesFortementeConexos;
import br.uem.algGrafos.dijkstra.Dijkstra;
import br.uem.algGrafos.ordenacaoTopografica.OrdenacaoTopologica;

public class Main {

	private static final String BFS = "arquivos/bfs.tfg";
	private static final String DFS = "arquivos/dfs.tfg";
	private static final String ORDTOP = "arquivos/ordTop.tfg";
	private static final String CompFortConexos = "arquivos/compFortConexos.tfg";
	private static final String DIJKSTRA = "arquivos/dijkstra.tfg";
	private static final String bellmanFord = "arquivos/bellmanFord.tfg";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Aresta[] E;
		String[] V;

		
		int alg = 0;	
		do {
		alg = Integer.parseInt(JOptionPane.showInputDialog(
				"Escolha o algoritmo que deseja rodar:\n" + "1- Busca Em Largura\n" + "2 - Busca em Profundidade\n"
						+ "3 - Ordenação Topológica\n" + "4 - Componentes Fortemente Conexos\n" + "5 - Dijkstra\n"
						+ "6 - Bellman Ford\n" + "7 - Floyd Warshall\n\n0 - sair"));
		
		List<Aresta> arestas;
		List<String> vertices;
		switch (alg) {
		case 1:

			Object[] dados = leArquivo(BFS);

			arestas = (List<Aresta>) dados[0];
			vertices = (List<String>) dados[1];

			E = new Aresta[arestas.size()];
			for (int i = 0; i < arestas.size(); i++) {
				E[i] = arestas.get(i);
			}

			V = new String[vertices.size()];
			for (int i = 0; i < vertices.size(); i++) {
				V[i] = vertices.get(i);
			}

			BuscaEmLargura BFS = new BuscaEmLargura(V, E, false, 0);
			BFS.execute();
			BFS.imprimeBuscaLargura();

			break;

		case 2:

			dados = leArquivo(Main.DFS);

			arestas = (List<Aresta>) dados[0];
			vertices = (List<String>) dados[1];

			E = new Aresta[arestas.size()];
			for (int i = 0; i < arestas.size(); i++) {
				E[i] = arestas.get(i);
			}

			V = new String[vertices.size()];
			for (int i = 0; i < vertices.size(); i++) {
				V[i] = vertices.get(i);
			}

			BuscaEmProfundidade DFS = new BuscaEmProfundidade(V, E, true);
			DFS.execute();
			DFS.imprimeBuscaProfundidade();

			break;

		case 3:
			dados = leArquivo(Main.ORDTOP);

			arestas = (List<Aresta>) dados[0];
			vertices = (List<String>) dados[1];

			E = new Aresta[arestas.size()];
			for (int i = 0; i < arestas.size(); i++) {
				E[i] = arestas.get(i);
			}

			V = new String[vertices.size()];
			for (int i = 0; i < vertices.size(); i++) {
				V[i] = vertices.get(i);
			}

			OrdenacaoTopologica ordTop = new OrdenacaoTopologica(V, E, true);
			ordTop.execute();
			ordTop.imprimeOrdTop();

			break;

		case 4:

			dados = leArquivo(Main.CompFortConexos);

			arestas = (List<Aresta>) dados[0];
			vertices = (List<String>) dados[1];

			E = new Aresta[arestas.size()];
			for (int i = 0; i < arestas.size(); i++) {
				E[i] = arestas.get(i);
			}

			V = new String[vertices.size()];
			for (int i = 0; i < vertices.size(); i++) {
				V[i] = vertices.get(i);
			}

			ComponentesFortementeConexos SCC = new ComponentesFortementeConexos(V, E, false);
			SCC.execute();
			SCC.imprimeSCC();

		case 5:

			dados = leArquivo(Main.DIJKSTRA);

			arestas = (List<Aresta>) dados[0];
			vertices = (List<String>) dados[1];

			E = new Aresta[arestas.size()];
			for (int i = 0; i < arestas.size(); i++) {
				E[i] = arestas.get(i);
			}

			V = new String[vertices.size()];
			for (int i = 0; i < vertices.size(); i++) {
				V[i] = vertices.get(i);
			}

			Dijkstra dijkstra = new Dijkstra(V, E, true, 0);
			dijkstra.execute();
			dijkstra.imprimeDijkstra();

		case 6:

			dados = leArquivo(Main.bellmanFord);

			arestas = (List<Aresta>) dados[0];
			vertices = (List<String>) dados[1];

			E = new Aresta[arestas.size()];
			for (int i = 0; i < arestas.size(); i++) {
				E[i] = arestas.get(i);
			}

			V = new String[vertices.size()];
			for (int i = 0; i < vertices.size(); i++) {
				V[i] = vertices.get(i);
			}

			BellmanFord bellmanFord = new BellmanFord(V, E, true, 0);
			bellmanFord.execute();
			bellmanFord.imprimeBellman();
		default:
			break;
		}
		} while (alg != 0);
	}

	private static Object[] leArquivo(String arq) {
		List<Aresta> arestas = new ArrayList<Aresta>();
		List<String> vertices = new ArrayList<String>();
		try {
			String str;
			BufferedReader in = new BufferedReader(new FileReader(arq));

			while (in.ready()) {
				str = in.readLine();

				if (str.equals("#")) {
					while (in.ready()) {
						str = in.readLine();
						arestas.add(processaAresta(str));
					}
				} else
					vertices.add(processaVertice(str));
			}
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Object[] retorno = new Object[] { arestas, vertices };
		return retorno;
	}

	private static Aresta processaAresta(String str) {
		Aresta a = new Aresta();
		String[] aresta = str.split(" ");
		a.setV1(Integer.parseInt(aresta[0]));
		a.setV2(Integer.parseInt(aresta[1]));
		a.setPeso(Integer.parseInt(aresta[2]));

		return a;
	}

	private static String processaVertice(String str) {
		return str.split(" ")[1];
	}

}
