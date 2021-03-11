package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.graphs.Graphs2;

public class Ejercicio3 {
	
	public static List<String> apartadoA(Map<String, List<String>> map) {
		List<String> r = new ArrayList<>();
		while(r.size() != map.keySet().size()) {
			for(String key: map.keySet()) {
				if(!r.contains(key)) {
					if(map.get(key).isEmpty()) {
						r.add(key);
					}else {
						if(r.containsAll(map.get(key))) {
							r.add(key);
						}
					}
				}
			}
		}	
		return r;
	}
	
	public static List<String> apartadoB(Map<String, List<String>> map) {
		List<String> r = new ArrayList<>();
		for(String key: map.keySet()) {
			if(map.get(key).isEmpty()) {
				r.add(key);
			}
		}
		Graph<String, DefaultEdge> graph = new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		for(String key: map.keySet()) {
			graph.addVertex(key);
			for(String s: map.get(key)) {
				graph.addEdge(s, key);
			}
		}
		Graphs2.toDot(graph, "ficheros/Ej2ApB.dot",
				v -> v.toString(),
				e -> "",
				v -> GraphColors.getColorIf(Color.blue, Color.black, r.contains(v)),
				e -> GraphColors.getColor(Color.black));
		return r;
	}
	
}
