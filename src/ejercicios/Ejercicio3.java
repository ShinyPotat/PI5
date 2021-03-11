package ejercicios;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.graphs.Graphs2;

public class Ejercicio3 {
	
	public static Set<String> apartadoA(Map<String, Set<String>> map) {
		Set<String> r = new HashSet<>();
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
	
	public static Set<String> apartadoB(Map<String, Set<String>> map) {
		Set<String> r = new HashSet<>();
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
	
	public static Set<String> apartadoC(Map<String, Set<String>> map, Set<String> set) {
		Set<String> r = new TreeSet<>();
		for(String key: map.keySet()) {
			if(!set.contains(key)) {
				if(map.get(key).isEmpty()) {
					r.add(key);
				}else {
					if(set.containsAll(map.get(key))) {
						r.add(key);
					}
				}
			}
		}
		
		Graph<String, DefaultEdge> graph = new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		for(String key: map.keySet()) {
			graph.addVertex(key);
			for(String s: map.get(key)) {
				graph.addEdge(s, key);
			}
		}
		
		Graphs2.toDot(graph, "ficheros/Ej3.dot",
				v -> v.toString(),
				e -> "",
				v -> getColorIf(v, set, r),
				e -> GraphColors.getColor(Color.black));
		
		return r;
	}
	
	private static Map<String,Attribute> getColorIf(String v, Set<String> cursado, Set<String> pendientes) {		
		Color c = Color.black;
		if(cursado.contains(v)) {
			c = Color.blue;
		}else if(pendientes.contains(v)) {
			c = Color.orange;
		}	
		
		String cl = c.toString();
		Map<String,Attribute> m = Map.of("color", DefaultAttribute.createAttribute(cl));		
		return m;
	}
	
}
