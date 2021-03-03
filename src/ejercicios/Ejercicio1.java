package ejercicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.SimpleGraph;

import datos.Amistad;
import datos.Miembro;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;

public class Ejercicio1 {
	
	public static Set<Miembro> apartadoANinguno(SimpleGraph<Miembro, Amistad> graph) {
		Set<Miembro> res = new HashSet<>();
		for(Miembro member: graph.vertexSet()) {
			if(graph.edgesOf(member).size() == 0) {
				res.add(member);
			}
		}
		return res;
	}
	
	public static Tuple2<Integer, Set<Miembro>> apartadoAMayor(SimpleGraph<Miembro, Amistad> graph) {
		Set<Miembro> res = new HashSet<>();
		Integer max = 0;
		for(Miembro member: graph.vertexSet()) {
			if(graph.edgesOf(member).size() > max) {
				max = graph.edgesOf(member).size();
				res.clear();
				res.add(member);
			}else if(graph.edgesOf(member).size() == max) {
				res.add(member);
			}
		}
		return Tuple.create(max, res);
	}
	
	public static GraphPath<Miembro, Amistad> apartadoB(SimpleGraph<Miembro, Amistad> graph, Miembro m1, Miembro m2) {
		return DijkstraShortestPath.findPathBetween(graph, m1, m2);
	}
	
	public static List<Set<Miembro>> apartadoC(SimpleGraph<Miembro, Amistad> graph) {
		ConnectivityInspector<Miembro, Amistad> conIns = new ConnectivityInspector<Miembro, Amistad>(graph);
		return conIns.connectedSets();
	}
	
	public static Set<Miembro> apartadoD(SimpleGraph<Miembro, Amistad> graph) {
		GreedyVCImpl<Miembro, Amistad> imp = new GreedyVCImpl<Miembro, Amistad>(graph);
		return imp.getVertexCover();
	}
	
}
